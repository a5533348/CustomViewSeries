package cn.xdeveloper.customviewseries.anim.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import cn.xdeveloper.customviewseries.R;
import cn.xdeveloper.customviewseries.anim.view.animation.AlphaAnimActivity;
import cn.xdeveloper.customviewseries.anim.view.animation.RotateAnimActivity;
import cn.xdeveloper.customviewseries.anim.view.animation.ScaleAnimActivity;
import cn.xdeveloper.customviewseries.anim.view.animation.SetAnimActivity;
import cn.xdeveloper.customviewseries.anim.view.animation.TranslateAnimActivity;

/**
 * View动画
 * Created by Lie on 2017/4/18.
 */
public class ViewAnimationActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_view_anim_enter);
        setTitle("View动画");

        findViewById(R.id.btn_scale).setOnClickListener(this);
        findViewById(R.id.btn_alpha).setOnClickListener(this);
        findViewById(R.id.btn_rotate).setOnClickListener(this);
        findViewById(R.id.btn_translate).setOnClickListener(this);
        findViewById(R.id.btn_set).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_scale:
                startActivity(new Intent(this, ScaleAnimActivity.class));

                break;
            case R.id.btn_alpha:
                startActivity(new Intent(this, AlphaAnimActivity.class));
                break;

            case R.id.btn_rotate:
                startActivity(new Intent(this, RotateAnimActivity.class));
                break;

            case R.id.btn_translate:
                startActivity(new Intent(this, TranslateAnimActivity.class));
                break;
            case R.id.btn_set:
                startActivity(new Intent(this, SetAnimActivity.class));
                break;


        }
    }
}
