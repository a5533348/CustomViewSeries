package cn.xdeveloper.customviewseries.anim.interpolator.sample;

import android.view.animation.Interpolator;

/**
 * 自定义正弦插值器
 * Created by Administrator on 2017/4/19.
 */
public class SinInterpolator implements Interpolator {

    @Override
    public float getInterpolation(float input) {
        return (float) Math.sin((input / 2) * Math.PI);
    }
}
