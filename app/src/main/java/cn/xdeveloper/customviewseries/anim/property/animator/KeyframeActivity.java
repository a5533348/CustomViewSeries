package cn.xdeveloper.customviewseries.anim.property.animator;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import cn.xdeveloper.customviewseries.R;

/**
 * Created by Administrator on 2017/5/4.
 */

public class KeyframeActivity extends AppCompatActivity implements View.OnClickListener {

    private ValueAnimator valueAnimator;
    private ImageView iv_tel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);

        setTitle("Keyframe");
        Button btn_start = (Button) findViewById(R.id.btn_start);
        iv_tel = (ImageView) findViewById(R.id.view);
        iv_tel.setImageResource(R.mipmap.telephone);

        Keyframe frame1 = Keyframe.ofFloat(0.1f, 0);
        Keyframe frame2 = Keyframe.ofFloat(0.2f, 0);
        Keyframe frame3 = Keyframe.ofFloat(0.3f, 20);
        Keyframe frame4 = Keyframe.ofFloat(0.4f, -20);
        Keyframe frame5 = Keyframe.ofFloat(0.5f, 60);
        Keyframe frame6 = Keyframe.ofFloat(0.6f, -50);
        Keyframe frame7 = Keyframe.ofFloat(0.7f, 45);
        Keyframe frame8 = Keyframe.ofFloat(0.8f, -20);
        Keyframe frame9 = Keyframe.ofFloat(0.9f, -10);
        Keyframe frame10 = Keyframe.ofFloat(1.0f, 0);


        Keyframe frame11 = Keyframe.ofFloat(0.1f, 1);
        Keyframe frame12 = Keyframe.ofFloat(0.4f, 1);
        Keyframe frame13 = Keyframe.ofFloat(0.5f, 1.2f);
        Keyframe frame14 = Keyframe.ofFloat(0.5f, 1.3f);
        Keyframe frame15 = Keyframe.ofFloat(1.0f, 1f);


        PropertyValuesHolder rotationXHolder = PropertyValuesHolder.ofKeyframe("rotation", frame1, frame2, frame3, frame4, frame5, frame6, frame7, frame8, frame9, frame10);
        PropertyValuesHolder scaleHolder = PropertyValuesHolder.ofKeyframe("scaleX", frame11, frame12, frame13, frame14, frame15);
        valueAnimator = ObjectAnimator.ofPropertyValuesHolder(iv_tel, rotationXHolder,scaleHolder)
                .setDuration(2000);


        btn_start.setOnClickListener(this);
        iv_tel.setOnClickListener(this);
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