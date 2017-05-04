package cn.xdeveloper.customviewseries.anim.property;

import android.animation.AnimatorSet;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;

import cn.xdeveloper.customviewseries.R;
import cn.xdeveloper.customviewseries.anim.property.animator.AnimatorSetActivity;
import cn.xdeveloper.customviewseries.anim.property.animator.KeyframeActivity;
import cn.xdeveloper.customviewseries.anim.property.animator.ObjectAnimatorActivity;
import cn.xdeveloper.customviewseries.anim.property.animator.PropertyValuesHolderActivity;
import cn.xdeveloper.customviewseries.anim.property.animator.ValueAnimatorActivity;

/**
 * Created by Administrator on 2017/4/24.
 */

public class PropertyAnimatorActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_view_animator_enter);
        setTitle("Property动画");


        findViewById(R.id.btn_value_animator).setOnClickListener(this);
        findViewById(R.id.btn_obj_animator).setOnClickListener(this);
        findViewById(R.id.btn_property_values_holder).setOnClickListener(this);
        findViewById(R.id.btn_keyframe).setOnClickListener(this);
        findViewById(R.id.btn_animator_set).setOnClickListener(this);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_value_animator:
                startActivity(new Intent(this, ValueAnimatorActivity.class));
                break;
            case R.id.btn_obj_animator:
                startActivity(new Intent(this, ObjectAnimatorActivity.class));
                break;
            case R.id.btn_property_values_holder:
                startActivity(new Intent(this, PropertyValuesHolderActivity.class));
                break;
            case R.id.btn_keyframe:
                startActivity(new Intent(this, KeyframeActivity.class));
                break;
            case R.id.btn_animator_set:
                startActivity(new Intent(this, AnimatorSetActivity.class));
                break;
        }
    }
}
