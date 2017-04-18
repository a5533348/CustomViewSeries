package cn.xdeveloper.customviewseries.anim.view.animation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import cn.xdeveloper.customviewseries.R;

import static cn.xdeveloper.customviewseries.R.id.view;

/**
 * Translate动画
 * Created by Administrator on 2017/4/18.
 */

public class TranslateAnimActivity extends AppCompatActivity {

    private Animation mScaleAnim;
    private View mView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);

        setTitle("Translate动画");
        Button btn_start = (Button) findViewById(R.id.btn_start);

        mView = findViewById(view);
        mScaleAnim = AnimationUtils.loadAnimation(TranslateAnimActivity.this, R.anim.translate_anim);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mView.startAnimation(mScaleAnim);
            }
        });

    }
}
