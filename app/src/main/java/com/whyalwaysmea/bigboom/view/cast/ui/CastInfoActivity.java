package com.whyalwaysmea.bigboom.view.cast.ui;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.jakewharton.rxbinding.support.v7.widget.RxToolbar;
import com.whyalwaysmea.bigboom.Constants;
import com.whyalwaysmea.bigboom.R;
import com.whyalwaysmea.bigboom.base.BaseActivity;
import com.whyalwaysmea.bigboom.bean.CastDetail;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CastInfoActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.name)
    TextView mName;
    @BindView(R.id.name_en)
    TextView mNameEn;
    @BindView(R.id.sex)
    TextView mSex;
    @BindView(R.id.constellation)
    TextView mConstellation;
    @BindView(R.id.birthday)
    TextView mBirthday;
    @BindView(R.id.birthplace)
    TextView mBirthplace;
    @BindView(R.id.more_name)
    TextView mMoreName;
    @BindView(R.id.content)
    TextView mContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cast_info);
        ButterKnife.bind(this);

        initData();
    }

    @Override
    protected void initData() {
        CastDetail castDetail = (CastDetail) getIntent().getSerializableExtra(Constants.KEY.CAST);
        if(castDetail != null) {
            mName.setText(castDetail.getName());
            if(!TextUtils.isEmpty(castDetail.getName_en())) {
                mNameEn.setText(castDetail.getName_en());
            } else {
                mNameEn.setVisibility(View.VISIBLE);
            }

            mSex.setText(castDetail.getGender());
            mBirthday.setText(castDetail.getBirthday());
            mBirthplace.setText(castDetail.getBorn_place());
            mConstellation.setText(castDetail.getConstellation());
            mContent.setText(castDetail.getSummary());
            if(castDetail.getAka().isEmpty()) {
                mMoreName.setVisibility(View.GONE);
            } else {
                StringBuffer sbName = new StringBuffer();
                for (int i = 0; i < castDetail.getAka().size(); i++) {
                    if(i == castDetail.getAka().size() - 1) {
                        sbName.append(castDetail.getAka().get(i));
                    } else {
                        sbName.append(castDetail.getAka().get(i) + "/");
                    }
                }
                mMoreName.setText(sbName.toString());
            }

            mToolbar.setTitle(R.string.cast_info);
            setSupportActionBar(mToolbar);
            mToolbar.setNavigationIcon(R.drawable.icon_back);
            RxToolbar.navigationClicks(mToolbar).subscribe(aVoid -> finish());
        }
    }

    @Override
    protected void initView() {

    }
}
