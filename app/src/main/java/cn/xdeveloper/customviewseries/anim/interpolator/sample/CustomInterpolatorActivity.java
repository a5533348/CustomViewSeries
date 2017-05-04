package cn.xdeveloper.customviewseries.anim.interpolator.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import cn.xdeveloper.customviewseries.R;


/**
 * 自定义Interpolator
 * Created by Administrator on 2017/4/19.
 */

public class CustomInterpolatorActivity extends AppCompatActivity {

    private Animation mScaleAnim;
    private View mView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);

        setTitle("自定义Interpolator");
        Button btn_start = (Button) findViewById(R.id.btn_start);

        mView = findViewById(R.id.view);
        mScaleAnim = AnimationUtils.loadAnimation(CustomInterpolatorActivity.this, R.anim.translate_anim);
        mScaleAnim.setInterpolator(new SinInterpolator());

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mView.startAnimation(mScaleAnim);
            }
        });

    }
}
