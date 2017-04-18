package cn.xdeveloper.customviewseries;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import cn.xdeveloper.customviewseries.anim.view.ViewAnimationActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_view).setOnClickListener(this);
        findViewById(R.id.btn_property).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_view:
                startActivity(new Intent(this, ViewAnimationActivity.class));
                break;
            case R.id.btn_property:

                break;
        }
    }
}
