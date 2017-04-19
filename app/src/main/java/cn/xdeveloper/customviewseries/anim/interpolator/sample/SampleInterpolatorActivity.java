package cn.xdeveloper.customviewseries.anim.interpolator.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;

import cn.xdeveloper.customviewseries.R;

import static cn.xdeveloper.customviewseries.R.id.view;


/**
 * 示例
 * Created by Administrator on 2017/4/19.
 */

public class SampleInterpolatorActivity extends AppCompatActivity {

    private Animation mScaleAnim;
    private View mView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);

        setTitle("示例1");
        Button btn_start = (Button) findViewById(R.id.btn_start);

        mView = findViewById(R.id.view);
        mScaleAnim = AnimationUtils.loadAnimation(SampleInterpolatorActivity.this, R.anim.rotate_anim);
        mScaleAnim.setInterpolator(new BounceInterpolator());

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mView.startAnimation(mScaleAnim);
            }
        });

    }
}
