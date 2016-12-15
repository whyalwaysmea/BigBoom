package com.whyalwaysmea.bigboom.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;

import com.socks.library.KLog;

import java.util.ArrayList;

/**
 * Created by Long
 * on 2016/10/25.
 */

public class MyNestedScrollView extends NestedScrollView implements NestedScrollingParent {


    /**
     * Tag for views that should stick and have constant drawing. e.g. TextViews, ImageViews etc
     */
    public static final String STICKY_TAG = "sticky";

    /**
     * Flag for views that should stick and have non-constant drawing. e.g. Buttons, ProgressBars etc
     */
    public static final String FLAG_NONCONSTANT = "-nonconstant";

    /**
     * Flag for views that have aren't fully opaque
     */
    public static final String FLAG_HASTRANSPARANCY = "-hastransparancy";


    private ArrayList<View> stickyViews;
    private View currentlyStickingView;
    private boolean redirectTouchesToStickyView;
    private float stickyViewTopOffset;
    private int stickyViewLeftOffset;
    private boolean clippingToPadding;
    private boolean clipToPaddingHasBeenSet;


    private final Runnable invalidateRunnable = new Runnable() {

        @Override
        public void run() {
            if(currentlyStickingView!=null){
                int l = getLeftForViewRelativeOnlyChild(currentlyStickingView);
                int t  = getBottomForViewRelativeOnlyChild(currentlyStickingView);
                int r = getRightForViewRelativeOnlyChild(currentlyStickingView);
                int b = (int) (getScrollY() + (currentlyStickingView.getHeight() + stickyViewTopOffset));
                invalidate(l,t,r,b);
            }
            postDelayed(this, 16);
        }
    };

    public MyNestedScrollView(Context context) {
        this(context, null);
    }

    public MyNestedScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.scrollViewStyle);
    }

    public MyNestedScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setup();
    }


    public void setup(){
        stickyViews = new ArrayList<View>();
    }


    private int getLeftForViewRelativeOnlyChild(View v){
        int left = v.getLeft();
        while(v.getParent() != getChildAt(0)){
            v = (View) v.getParent();
            left += v.getLeft();
        }
        return left;
    }

    private int getTopForViewRelativeOnlyChild(View v){
        int top = v.getTop();
        while(v.getParent() != getChildAt(0)){
            v = (View) v.getParent();
            top = v.getTop() + top + 10;
        }
        return top;
    }

    private int getRightForViewRelativeOnlyChild(View v){
        int right = v.getRight();
        while(v.getParent() != getChildAt(0)){
            v = (View) v.getParent();
            right += v.getRight();
        }
        return right;
    }

    private int getBottomForViewRelativeOnlyChild(View v){
        int bottom = v.getBottom();
        while(v.getParent() != getChildAt(0)){
            v = (View) v.getParent();
            bottom += v.getBottom();
        }
        return bottom;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if(!clipToPaddingHasBeenSet){
            clippingToPadding = true;
        }
        notifyHierarchyChanged();
    }

    /**
     * 该属性的解释:
     * Defines whether the ViewGroup will clip its drawing surface so as to exclude the padding area.
     * 什么意思呢?就是说:
     * clipToPadding属性定义了是否允许ViewGroup在padding中绘制,该值默认为true,即不允许.
     * 所以若我们给ListView设置了android:paddingTop="70dip" android:paddingBottom="70dip"
     * 那么我们可以看到ListView的头部以上和尾部以下都占有70大小的padding,在滑动ListView的过程
     * 中这个padding当然是存在的.在padding部分是看不到ListView的item的,本质上是在这两部分没有绘制
     * 我们的ListView
     * 假若我们此时为ListView设置属性android:clipToPadding="false",同样再滑动ListView此时可以
     * 发现在ListView的头部以上和尾部以下都占有70大小的padding部分依然可以显示我们的ListView的
     * item,本质上是在这两部分绘制了我们的ListView
     *
     * 该属性很适合的应用场景:
     * 设置ListView的第一个(最后一个)Item距离屏幕TOP(BOTTOM)有一段距离的情况
     *
     * @param clipToPadding
     */
    @Override
    public void setClipToPadding(boolean clipToPadding) {
        super.setClipToPadding(clipToPadding);
        clippingToPadding  = clipToPadding;
        clipToPaddingHasBeenSet = true;
    }

    @Override
    public void addView(View child) {
        super.addView(child);
        findStickyViews(child);
    }

    @Override
    public void addView(View child, int index) {
        super.addView(child, index);
        findStickyViews(child);
    }

    @Override
    public void addView(View child, int index, android.view.ViewGroup.LayoutParams params) {
        super.addView(child, index, params);
        findStickyViews(child);
    }

    @Override
    public void addView(View child, int width, int height) {
        super.addView(child, width, height);
        findStickyViews(child);
    }

    @Override
    public void addView(View child, android.view.ViewGroup.LayoutParams params) {
        super.addView(child, params);
        findStickyViews(child);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if(currentlyStickingView != null){
            canvas.save();
            canvas.translate(getPaddingLeft() + stickyViewLeftOffset, getScrollY() + stickyViewTopOffset + (clippingToPadding ? getPaddingTop() : 0));
            canvas.clipRect(0, (clippingToPadding ? -stickyViewTopOffset : 0), getWidth(), currentlyStickingView.getHeight());
            // 关键
            currentlyStickingView.draw(canvas);
            canvas.restore();
        }
    }

    /**
     * 触摸事件分发
     * @param ev
     * @return
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if(ev.getAction()==MotionEvent.ACTION_DOWN){
            redirectTouchesToStickyView = true;
        }

        if(redirectTouchesToStickyView){
            redirectTouchesToStickyView = currentlyStickingView != null;
            if(redirectTouchesToStickyView){
                redirectTouchesToStickyView =
                        ev.getY()<=(currentlyStickingView.getHeight()+stickyViewTopOffset) &&
                                ev.getX() >= getLeftForViewRelativeOnlyChild(currentlyStickingView) &&
                                ev.getX() <= getRightForViewRelativeOnlyChild(currentlyStickingView);
            }
        }else if(currentlyStickingView == null){
            redirectTouchesToStickyView = false;
        }
        if(redirectTouchesToStickyView){
            ev.offsetLocation(0, -1*((getScrollY() + stickyViewTopOffset) - getTopForViewRelativeOnlyChild(currentlyStickingView)));
        }
        return super.dispatchTouchEvent(ev);
    }



    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        doTheStickyThing();
    }

    /**
     *
     */
    private void doTheStickyThing() {
        View viewThatShouldStick = null;
        View approachingView = null;
        // 遍历stick view
        for(View v : stickyViews){
            // 判断是否达到顶部     stickyView距离Top的距离 - Y轴滑动的距离  + paddingTop的距离
            int viewTop = getTopForViewRelativeOnlyChild(v) - getScrollY() + (clippingToPadding ? 0 : getPaddingTop());
            if(viewTop<=0){
                // 到达了顶部
                if(viewThatShouldStick==null || viewTop>(getTopForViewRelativeOnlyChild(viewThatShouldStick) - getScrollY() + (clippingToPadding ? 0 : getPaddingTop()))){
                    viewThatShouldStick = v;
                }
            }else{
                if(approachingView == null || viewTop<(getTopForViewRelativeOnlyChild(approachingView) - getScrollY() + (clippingToPadding ? 0 : getPaddingTop()))){
                    approachingView = v;
                }
            }
        }
        if(viewThatShouldStick!=null){
            stickyViewTopOffset = approachingView == null ? 0 : Math.min(0, getTopForViewRelativeOnlyChild(approachingView) - getScrollY()  + (clippingToPadding ? 0 : getPaddingTop()) - viewThatShouldStick.getHeight());
            if(viewThatShouldStick != currentlyStickingView){
                if(currentlyStickingView!=null){
                    stopStickingCurrentlyStickingView();
                }
                // only compute the left offset when we start sticking.
                stickyViewLeftOffset = getLeftForViewRelativeOnlyChild(viewThatShouldStick);
                startStickingView(viewThatShouldStick);
            }
        }else if(currentlyStickingView!=null){
            stopStickingCurrentlyStickingView();
        }
    }

    /**
     * 开始固定View
     * @param viewThatShouldStick
     */
    private void startStickingView(View viewThatShouldStick) {
        currentlyStickingView = viewThatShouldStick;
        if(getStringTagForView(currentlyStickingView).contains(FLAG_HASTRANSPARANCY)){
            hideView(currentlyStickingView);
        }
        if(((String)currentlyStickingView.getTag()).contains(FLAG_NONCONSTANT)){
            post(invalidateRunnable);
        }
    }


    /**
     * 结束固定View
     */
    private void stopStickingCurrentlyStickingView() {
        if(getStringTagForView(currentlyStickingView).contains(FLAG_HASTRANSPARANCY)){
            showView(currentlyStickingView);
        }
        currentlyStickingView = null;
        removeCallbacks(invalidateRunnable);
    }


    private void notifyHierarchyChanged(){
        if(currentlyStickingView!=null){
            stopStickingCurrentlyStickingView();
        }
        stickyViews.clear();
        findStickyViews(getChildAt(0));
        doTheStickyThing();
        invalidate();
    }

    /**
     * 找到那个stick view
     * @param v
     */
    private void findStickyViews(View v) {
        if(v instanceof ViewGroup){
            ViewGroup vg = (ViewGroup)v;
            for(int i = 0 ; i<vg.getChildCount() ; i++){
                String tag = getStringTagForView(vg.getChildAt(i));
                if(tag!=null && tag.contains(STICKY_TAG)){
                    stickyViews.add(vg.getChildAt(i));
                }else if(vg.getChildAt(i) instanceof ViewGroup){
                    findStickyViews(vg.getChildAt(i));
                }
            }
        }else{
            String tag = (String) v.getTag();
            if(tag!=null && tag.contains(STICKY_TAG)){
                stickyViews.add(v);
            }
        }
    }

    /**
     * 获取view的tag值
     * @param v
     * @return
     */
    private String getStringTagForView(View v){
        Object tagObject = v.getTag();
        return String.valueOf(tagObject);
    }

    /**
     * 隐藏View
     * @param v
     */
    private void hideView(View v) {
        KLog.e("hideView");
        if(Build.VERSION.SDK_INT>=11){
            v.setAlpha(0);
        }else{
            AlphaAnimation anim = new AlphaAnimation(1, 0);
            anim.setDuration(0);
            anim.setFillAfter(true);
            v.startAnimation(anim);
        }
    }

    /**
     * 显示View
     * @param v
     */
    private void showView(View v) {
        KLog.e("showView");

        if(Build.VERSION.SDK_INT>=11){
            v.setAlpha(1);
        }else{
            AlphaAnimation anim = new AlphaAnimation(0, 1);
            anim.setDuration(0);
            anim.setFillAfter(true);
            v.startAnimation(anim);
        }
    }
}
