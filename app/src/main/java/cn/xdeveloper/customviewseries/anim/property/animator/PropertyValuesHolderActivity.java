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
import android.widget.Toast;

import cn.xdeveloper.customviewseries.R;

/**
 * Created by Administrator on 2017/5/4.
 */

public class PropertyValuesHolderActivity extends AppCompatActivity implements View.OnClickListener {

    private ValueAnimator valueAnimator;
    private View mView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);

        setTitle("PropertyValuesHolder");
        Button btn_start = (Button) findViewById(R.id.btn_start);
        mView = findViewById(R.id.view);

        PropertyValuesHolder alphaHolder = PropertyValuesHolder.ofFloat("alpha", 0, 1);
        PropertyValuesHolder rotationXHolder = PropertyValuesHolder.ofFloat("rotation", 30, -30, 20, -20, 10, -10, 0);
        valueAnimator = ObjectAnimator.ofPropertyValuesHolder(mView, alphaHolder, rotationXHolder)
                .setDuration(1000);

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