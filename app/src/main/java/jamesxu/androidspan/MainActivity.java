package jamesxu.androidspan;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.Spanned;
import android.util.Log;
import android.util.Property;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;

import me.jamesxu.androidspan.AndroidSpan;
import me.jamesxu.androidspan.FireworksSpanGroup;
import me.jamesxu.androidspan.SpanOptions;
import me.jamesxu.androidspan.span.MutableForegroundColorSpan;


public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private AccelerateDecelerateInterpolator mSmoothInterpolator;
    private SpannableString spannableString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.text);
//        setText();
        fireWork();

    }

    private void fireWork() {
        mSmoothInterpolator = new AccelerateDecelerateInterpolator();
        spannableString = new SpannableString("许锦洋");
        FireworksSpanGroup spanGroup = buildFireworksSpanGroup(spannableString, 0, spannableString.length() - 1);
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(spanGroup, FIREWORKS_GROUP_PROGRESS_PROPERTY, 0.0f, 1.0f);
        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //refresh
                textView.setText(spannableString);
            }
        });
        objectAnimator.setInterpolator(mSmoothInterpolator);
        objectAnimator.setDuration(2000);
        objectAnimator.start();
    }

    private void setText() {
        AndroidSpan androidSpan = new AndroidSpan()
                .drawUnderlineSpan("测试文本")
                .drawRelativeSize("我要变大", 2.0f)
                .drawForegroundColor("红色的文本", Color.RED)
                .drawWithOptions("综合效果", new SpanOptions().addBackgroundColorSpan(Color.GREEN).addUnderlineSpan());
        textView.setText(androidSpan.getSpanText());

    }

    private static final Property<FireworksSpanGroup, Float> FIREWORKS_GROUP_PROGRESS_PROPERTY =
            new Property<FireworksSpanGroup, Float>(Float.class, "FIREWORKS_GROUP_PROGRESS_PROPERTY") {

                @Override
                public void set(FireworksSpanGroup spanGroup, Float value) {
                    Log.i("mainActivity", "value=" + value);
                    spanGroup.setProgress(value);
                }

                @Override
                public Float get(FireworksSpanGroup spanGroup) {
                    return spanGroup.getProgress();
                }
            };

    private FireworksSpanGroup buildFireworksSpanGroup(SpannableString spannableString, int start, int end) {
        final FireworksSpanGroup group = new FireworksSpanGroup();
        for (int index = start; index <= end; index++) {
            MutableForegroundColorSpan span = new MutableForegroundColorSpan(0, Color.GREEN);
            group.addSpan(span);
            spannableString.setSpan(span, index, index + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        group.init();
        return group;
    }


}
