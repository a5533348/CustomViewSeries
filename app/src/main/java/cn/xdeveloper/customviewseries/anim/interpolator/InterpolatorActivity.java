package cn.xdeveloper.customviewseries.anim.interpolator;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import cn.xdeveloper.customviewseries.R;
import cn.xdeveloper.customviewseries.anim.interpolator.sample.CustomInterpolatorActivity;
import cn.xdeveloper.customviewseries.anim.interpolator.sample.SampleInterpolatorActivity;

/**
 * 插值器
 * Created by Administrator on 2017/4/19.
 */

public class InterpolatorActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interpolator);

        setTitle("Interpolator 插值器");

        findViewById(R.id.btn_case1).setOnClickListener(this);
        findViewById(R.id.btn_custom).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_case1:
                startActivity(new Intent(InterpolatorActivity.this, SampleInterpolatorActivity.class));
                break;
            case R.id.btn_custom:
                startActivity(new Intent(InterpolatorActivity.this, CustomInterpolatorActivity.class));
                break;
        }
    }
}
