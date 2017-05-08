package cn.xdeveloper.customviewseries.view.view1;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.PathMeasure;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import static android.R.attr.duration;

/**
 * Created by Administrator on 2017/5/4.
 */

public class SubmitAnimButton extends View implements View.OnClickListener {

    private static String TAG = SubmitAnimButton.class.getName();

    private int mWidth;
    private int mHeight;

    /**
     * 圆角半径
     */
    private int mCircleAngle;

    /**
     * 两个圆心的距离
     */
    private int default_two_circle_distance;

    /**
     * 根据view的大小设置成矩形
     */
    private RectF mRect = new RectF();
    private Paint mRectPaint;

    private Rect mTextRect = new Rect();
    private Paint mTextPaint;


    /**
     * 路径--用来获取对勾的路径
     */
    private Path path = new Path();
    /**
     * 取路径的长度
     */
    private PathMeasure pathMeasure;
    /**
     * 对路径处理实现绘制动画效果
     */
    private PathEffect effect;

    /**
     * 对勾（√）画笔
     */
    private Paint okPaint;

    /**
     * 是否开始绘制对勾
     */
    private boolean startDrawOk;

    private AnimatorSet mAnimatorSet = new AnimatorSet();
    private int mOffSetDistance;

    public SubmitAnimButton(Context context) {
        this(context, null);
    }

    public SubmitAnimButton(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SubmitAnimButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initPaint();
        setOnClickListener(this);
    }

    /**
     * 初始化动画
     */
    private void initAnimator() {
        ObjectAnimator roundRectAnimator = ObjectAnimator.ofInt(this, "circleAngle", 0, mHeight / 2).setDuration(1000);
        ValueAnimator shrinkRectAnimator = ValueAnimator.ofInt(0, default_two_circle_distance).setDuration(1000);
        shrinkRectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mOffSetDistance = (int) animation.getAnimatedValue();

                int alpha = 255 - (mOffSetDistance * 255) / default_two_circle_distance;
                mTextPaint.setAlpha(alpha);
            }
        });

        ValueAnimator animator_draw_ok = ValueAnimator.ofFloat(1, 0);
        animator_draw_ok.setDuration(1000);
        animator_draw_ok.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                startDrawOk = true;
                float value = (Float) animation.getAnimatedValue();

                effect = new DashPathEffect(new float[]{pathMeasure.getLength(), pathMeasure.getLength()}, value * pathMeasure.getLength());
                okPaint.setPathEffect(effect);
                invalidate();
            }
        });

        mAnimatorSet.play(roundRectAnimator).with(shrinkRectAnimator).before(animator_draw_ok);
    }

    /**
     * 初始化画笔
     */
    private void initPaint() {
        mRectPaint = new Paint();
        mRectPaint.setStrokeWidth(4);
        mRectPaint.setStyle(Paint.Style.FILL);
        mRectPaint.setAntiAlias(true);
        mRectPaint.setColor(0xffbc7d53);

        mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setTextSize(50);
        mTextPaint.setColor(Color.WHITE);
        mTextPaint.setTextAlign(Paint.Align.CENTER);
        mTextPaint.setAntiAlias(true);

        okPaint = new Paint();
        okPaint.setStrokeWidth(10);
        okPaint.setStyle(Paint.Style.STROKE);
        okPaint.setAntiAlias(true);
        okPaint.setColor(Color.WHITE);
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        mWidth = w;
        mHeight = h;
        default_two_circle_distance = (w - h) / 2;

        //对勾的路径
        path.moveTo(default_two_circle_distance + mHeight / 8 * 3, mHeight / 2);
        path.lineTo(default_two_circle_distance + mHeight / 2, mHeight / 5 * 3);
        path.lineTo(default_two_circle_distance + mHeight / 3 * 2, mHeight / 5 * 2);
        pathMeasure = new PathMeasure(path, true);

        initAnimator();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mRect.left = mOffSetDistance;
        mRect.top = 0;
        mRect.right = mWidth - mOffSetDistance;
        mRect.bottom = mHeight;

        //画圆角矩形
        canvas.drawRoundRect(mRect, mCircleAngle, mCircleAngle, mRectPaint);

        mTextRect.left = 0;
        mTextRect.top = 0;
        mTextRect.right = mWidth;
        mTextRect.bottom = mHeight;
        Paint.FontMetricsInt fontMetrics = mTextPaint.getFontMetricsInt();
        int baseline = (mTextRect.bottom + mTextRect.top - fontMetrics.bottom - fontMetrics.top) / 2;
        //文字绘制到整个布局的中心位置
        canvas.drawText("登录", mTextRect.centerX(), baseline, mTextPaint);

        if (startDrawOk) {
            canvas.drawPath(path, okPaint);
        }
    }

    @Override
    public void onClick(View v) {
        if (mAnimatorSet.isRunning()) {
            return;
        }

        mAnimatorSet.start();
    }


    public void setCircleAngle(int mCircleAngle) {
        this.mCircleAngle = mCircleAngle;
        invalidate();
    }



}

