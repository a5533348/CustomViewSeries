package cn.xdeveloper.customviewseries.anim.property.animator;

import android.animation.IntEvaluator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.Toast;

import cn.xdeveloper.customviewseries.R;

import static cn.xdeveloper.customviewseries.R.id.view;

/**
 * ValueAnimator
 * Created by Administrator on 2017/4/18.
 */

public class ValueAnimatorActivity extends AppCompatActivity implements View.OnClickListener {

    private ValueAnimator valueAnimator;
    private View mView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);

        setTitle("ValueAnimator");
        Button btn_start = (Button) findViewById(R.id.btn_start);

        mView = findViewById(R.id.view);
        valueAnimator = ValueAnimator.ofInt(100, 500);
        valueAnimator.setDuration(1000);
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int value = (int) animation.getAnimatedValue();
                mView.layout(mView.getLeft(), value, mView.getRight(), mView.getHeight() + value);
            }
        });

        btn_start.setOnClickListener(this);
        mView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start:
                valueAnimator.start();
                break;
            case R.id.view:
                Toast.makeText(this, "view is clicked!", Toast.LENGTH_SHORT).show();
                break;

        }
    }
}
