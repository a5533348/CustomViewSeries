package cn.xdeveloper.customviewseries.anim.view.animation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import cn.xdeveloper.customviewseries.R;

import static cn.xdeveloper.customviewseries.R.id.view;

/**
 * Set动画集合
 * Created by Administrator on 2017/4/18.
 */

public class SetAnimActivity extends AppCompatActivity {

    private AnimationSet mAnimationSet;
    private View mView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);

        setTitle("Set动画集合");
        Button btn_start = (Button) findViewById(R.id.btn_start);

        mView = findViewById(view);
        mAnimationSet = (AnimationSet) AnimationUtils.loadAnimation(SetAnimActivity.this, R.anim.set_anim);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mView.startAnimation(mAnimationSet);
            }
        });

    }
}
