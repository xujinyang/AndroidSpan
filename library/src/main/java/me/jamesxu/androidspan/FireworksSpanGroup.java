
package me.jamesxu.androidspan;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;

import me.jamesxu.androidspan.span.MutableForegroundColorSpan;


public final class FireworksSpanGroup {

    private static final boolean DEBUG = false;
    private static final String TAG = "FireworksSpanGroup";

    private final float mProgress;
    private final ArrayList<MutableForegroundColorSpan> mSpans;
    private final ArrayList<Integer> mSpanIndexes;

    public FireworksSpanGroup() {
        mProgress = 0;
        mSpans = new ArrayList<MutableForegroundColorSpan>();
        mSpanIndexes = new ArrayList<Integer>();
    }

    public void addSpan(MutableForegroundColorSpan span) {
        span.setAlpha(0);
        mSpanIndexes.add(mSpans.size());
        mSpans.add(span);
    }

    public void init() {
        Collections.shuffle(mSpans);
    }

    public void setProgress(float progress) {
        int size = mSpans.size();
        float total = 1.0f * size * progress;


        for (int index = 0; index < size; index++) {
            MutableForegroundColorSpan span = mSpans.get(index);

            if (total >= 1.0f) {
                Log.d(TAG, "显示了" + total);
                span.setAlpha(255);
                total -= 1.0f;
            } else {
                span.setAlpha((int) (total * 255));
                total = 0.0f;
            }
        }
    }

    public float getProgress() {
        return mProgress;
    }
}