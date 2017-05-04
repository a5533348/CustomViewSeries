package cn.xdeveloper.customviewseries.anim.property.animator;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import cn.xdeveloper.customviewseries.R;


/**
 * ObjectAnimator
 * Created by Administrator on 2017/4/25.
 */

public class ObjectAnimatorActivity extends AppCompatActivity implements View.OnClickListener {

    private ObjectAnimator mRotateAnim;
    private ObjectAnimator mAlphaAnim;
    private ObjectAnimator mScaleAnim;
    private ObjectAnimator mTranslateAnim;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_anim);

        setTitle("ObjectAnimator");

        findViewById(R.id.btn_alpha).setOnClickListener(this);
        findViewById(R.id.btn_rotate).setOnClickListener(this);
        findViewById(R.id.btn_scale).setOnClickListener(this);
        findViewById(R.id.btn_translate).setOnClickListener(this);

        ImageView view = (ImageView) findViewById(R.id.view);

        mRotateAnim = ObjectAnimator.ofFloat(view, "rotation", 0, 180, 360).setDuration(2000);
        mAlphaAnim = ObjectAnimator.ofFloat(view, "alpha", 1, 0, 1).setDuration(2000);
        mScaleAnim = ObjectAnimator.ofFloat(view, "scaleX", 1, 2, -2, 1).setDuration(2000);
        mTranslateAnim = ObjectAnimator.ofFloat(view, "translationY", 0, -100, 100, 0).setDuration(2000);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_alpha:
                mAlphaAnim.start();
                break;
            case R.id.btn_rotate:
                mRotateAnim.start();
                break;
            case R.id.btn_scale:
                mScaleAnim.start();
                break;
            case R.id.btn_translate:
                mTranslateAnim.start();
                break;

        }
    }
}
