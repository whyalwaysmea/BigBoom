package com.whyalwaysmea.bigboom.view.menu.ui;

import android.content.Intent;
import android.os.Bundle;

import com.whyalwaysmea.bigboom.MainActivity;
import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.wangyuwei.particleview.ParticleView;

public class SplashActivity extends BaseActivity {

    @BindView(R.id.particleview)
    ParticleView mParticleview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        mParticleview.setOnParticleAnimListener(new ParticleView.ParticleAnimListener() {
            @Override
            public void onAnimationEnd() {
                Intent intent = new Intent(mContext, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        mParticleview.startAnim();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }
}
