package cn.xdeveloper.customviewseries.anim.property.animator;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AnimationSet;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import cn.xdeveloper.customviewseries.R;

import static android.animation.ObjectAnimator.ofFloat;
import static cn.xdeveloper.customviewseries.R.id.view;


/**
 * AnimatorSet
 * Created by Administrator on 2017/4/25.
 */

public class AnimatorSetActivity extends AppCompatActivity implements View.OnClickListener {

    private AnimatorSet animatorSet;
    private List<Animator> list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator_set);

        setTitle("AnimatorSet");

        findViewById(R.id.btn_seq).setOnClickListener(this);
        findViewById(R.id.btn_together).setOnClickListener(this);

        Button btn_1 = (Button) findViewById(R.id.btn_1);
        Button btn_2 = (Button) findViewById(R.id.btn_2);

        animatorSet = new AnimatorSet();
        list = new ArrayList<>();

        Animator animator1 = ObjectAnimator.ofArgb(btn_1, "backgroundColor", 0xffff00ff, 0xffffff00, 0xffff00ff).setDuration(2000);
        Animator animator2 = ObjectAnimator.ofFloat(btn_2, "scaleX", 1, 2, -2, 1).setDuration(2000);
        Animator animator3 = ObjectAnimator.ofFloat(btn_1, "translationY", 0, -100, 100, 0).setDuration(2000);
        list.add(animator1);
        list.add(animator2);
        list.add(animator3);

        animatorSet.playSequentially(list);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_seq:

                animatorSet.start();
                break;
            case R.id.btn_together:
//                animatorSet.playTogether(list);
//                animatorSet.start();
                break;
        }
    }
}
