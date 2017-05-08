package cn.xdeveloper.customviewseries.view.view1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import cn.xdeveloper.customviewseries.R;

/**
 * 提交动画按钮
 * Created by Administrator on 2017/5/4.
 */
public class SubmitAnimButtonActivity extends AppCompatActivity {

    private static final String TAG = "Activity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"---------onCreate---------");

        setContentView(R.layout.activity_submit_anim_btn);
    }



}
