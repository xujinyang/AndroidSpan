package jamesxu.androidspan;


import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.os.Build;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.BulletSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.LocaleSpan;
import android.text.style.MaskFilterSpan;
import android.text.style.QuoteSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.ScaleXSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TextAppearanceSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;

import java.util.Locale;

/**
 * Created by james on 13/10/15.
 */
public class AndroidSpan {

    private SpannableStringBuilder spannableStringBuilder;

    public AndroidSpan() {
        spannableStringBuilder = new SpannableStringBuilder("");
    }

    private WordPosition getWordPosition(String text) {
        int start = spannableStringBuilder.toString().length();
        int end = start + text.length();
        return new WordPosition(start, end);
    }

    /**
     * 下划线
     *
     * @param text
     * @return
     */
    public AndroidSpan drawUnderlineSpan(String text) {
        UnderlineSpan span = new UnderlineSpan();
        drawSpan(span, text);
        return this;
    }

    public AndroidSpan drawBulletSpan(String text, int gapWidth, int color) {
        BulletSpan span = new BulletSpan(gapWidth, color);
        drawSpan(span, text);
        return this;
    }

    public AndroidSpan drawQuoteSpan(String text, int color) {
        QuoteSpan span = new QuoteSpan(color);
        drawSpan(span, text);
        return this;
    }

    public AndroidSpan drawAlignmentSpan(String text, Layout.Alignment align) {
        AlignmentSpan.Standard span = new AlignmentSpan.Standard(align);
        drawSpan(span, text);
        return this;
    }

    public AndroidSpan drawStrikethroughSpan(String text) {
        StrikethroughSpan span = new StrikethroughSpan();
        drawSpan(span, text);
        return this;
    }

    public AndroidSpan drawBackgroundColorSpan(String text, int color) {
        BackgroundColorSpan span = new BackgroundColorSpan(color);
        drawSpan(span, text);
        return this;
    }

    /**
     * @param text
     * @param density
     * @param style   BlurMaskFilter.Blur.NORMAL
     * @return
     */
    public AndroidSpan drawMaskFilterSpan(String text, float density, BlurMaskFilter.Blur style) {
        MaskFilterSpan span = new MaskFilterSpan(new BlurMaskFilter(density, style));
        drawSpan(span, text);
        return this;
    }

    public AndroidSpan drawSubscriptSpan(String text) {
        SubscriptSpan span = new SubscriptSpan();
        drawSpan(span, text);
        return this;
    }

    public AndroidSpan drawSuperscriptSpan(String text) {
        SuperscriptSpan span = new SuperscriptSpan();
        drawSpan(span, text);
        return this;
    }

    /**
     * @param text
     * @param style Typeface.BOLD | Typeface.ITALIC
     * @return
     */
    public AndroidSpan drawStyleSpan(String text, int style) {
        StyleSpan span = new StyleSpan(style);
        drawSpan(span, text);
        return this;
    }

    public AndroidSpan drawAbsoluteSizeSpan(String text, int size, boolean dip) {
        AbsoluteSizeSpan span = new AbsoluteSizeSpan(size, dip);
        drawSpan(span, text);
        return this;
    }

    public AndroidSpan drawRelativeSizeSpan(String text, float proportion) {
        RelativeSizeSpan span = new RelativeSizeSpan(proportion);
        drawSpan(span, text);
        return this;
    }

    public AndroidSpan drawTextAppearanceSpan(String text, Context context, int appearance) {
        TextAppearanceSpan span = new TextAppearanceSpan(context, appearance);
        drawSpan(span, text);
        return this;
    }

    /**
     * @param text
     * @param locale Locale.CHINESE
     * @return
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    public AndroidSpan drawLocaleSpan(String text, Locale locale) {
        LocaleSpan span = new LocaleSpan(locale);
        drawSpan(span, text);
        return this;
    }

    public AndroidSpan drawScaleXSpan(String text, float proportion) {
        ScaleXSpan span = new ScaleXSpan(proportion);
        drawSpan(span, text);
        return this;
    }

    /**
     * @param text
     * @param typeface serif
     * @return
     */
    public AndroidSpan drawTypefaceSpan(String text, String typeface) {
        TypefaceSpan span = new TypefaceSpan(typeface);
        drawSpan(span, text);
        return this;
    }

    public AndroidSpan drawImageSpan(String text, Context context, int imgId) {
        ImageSpan span = new ImageSpan(context, imgId);
        drawSpan(span, text);
        return this;
    }


    /**
     * 文本颜色
     *
     * @param text
     * @return
     */
    public AndroidSpan drawForegroundColor(String text, int color) {
        ForegroundColorSpan span = new ForegroundColorSpan(color);
        drawSpan(span, text);
        return this;
    }

    /**
     * 同比放大索小
     *
     * @param text
     * @param size
     * @return
     */
    public AndroidSpan drawRelativeSize(String text, float size) {
        RelativeSizeSpan span = new RelativeSizeSpan(size);
        drawSpan(span, text);
        return this;
    }

    private void drawSpan(Object span, String text) {
        WordPosition wordPosition = getWordPosition(text);
        spannableStringBuilder.append(text);
        spannableStringBuilder.setSpan(span, wordPosition.start, wordPosition.end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
    }

    public SpannableStringBuilder getSpanText() {
        return spannableStringBuilder;
    }

    public AndroidSpan drawWithOptions(String text, SpanOptions spanOptions) {
        WordPosition wordPosition = getWordPosition(text);
        spannableStringBuilder.append(text);
        for (Object span : spanOptions.getListSpan()) {
            spannableStringBuilder.setSpan(span, wordPosition.start, wordPosition.end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        return this;
    }
}
