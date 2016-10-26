package com.whyalwaysmea.bigboom.module.moviedetail.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.BaseAdapter;
import com.whyalwaysmea.bigboom.base.BaseViewHolder;
import com.whyalwaysmea.bigboom.bean.Comment;
import com.whyalwaysmea.bigboom.imageloader.ImageUtils;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Long
 * on 2016/10/26.
 */

public class CommentAdapter extends BaseAdapter<Comment.CommentsBean> {


    public CommentAdapter(Context context, List<Comment.CommentsBean> data) {
        super(context, data);
    }

    @Override
    protected BaseViewHolder onCreateNormalViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.item_comment, parent, false);
        return new CommentViewHolder(view);
    }

    class CommentViewHolder extends BaseViewHolder {

        @BindView(R.id.avatart)
        ImageView mAvatart;
        @BindView(R.id.name)
        TextView mName;
        @BindView(R.id.content)
        TextView mContent;

        public CommentViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void bindData(int position) {
            Comment.CommentsBean commentsBean = mData.get(position);

            ImageUtils.getInstance().displayCircleImg(mAvatart, commentsBean.getAuthor().getAvatar());
            mName.setText(commentsBean.getAuthor().getName());
            mContent.setText(commentsBean.getContent());
        }
    }
}
