package me.jamesxu.androidspan;


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
import android.text.style.URLSpan;
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
        drawSpan(text, span);
        return this;
    }

    /**
     * 没有效果
     *
     * @param text
     * @return
     */
    public AndroidSpan drawCommonSpan(String text) {
        drawSpan(text, null);
        return this;
    }

    /**
     * 段落的开始处加上项目符号
     *
     * @param gapWidth 项目符号和文本之间的间隙
     * @param color    项目符号的颜色，默认为透明
     * @return
     */
    public AndroidSpan drawBulletSpan(String text, int gapWidth, int color) {
        BulletSpan span = new BulletSpan(gapWidth, color);
        drawSpan(text, span);
        return this;
    }

    /**
     * 左侧添加一条表示引用的竖线
     *
     * @param text
     * @param color
     * @return
     */
    public AndroidSpan drawQuoteSpan(String text, int color) {
        QuoteSpan span = new QuoteSpan(color);
        drawSpan(text, span);
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
        drawSpan(text, span);
        return this;
    }


    /**
     * URL效果
     * 需要实现textView.setMovementMethod(LinkMovementMethod.getInstance());
     *
     * @param url 格式为：电话：tel:18721850636，邮箱：mailto:1119117546@qq.com，网站：http://www.baidu.com,短信：mms:4155551212，彩信：mmsto:18721850636,地图：geo:38.899533,-77.036476
     * @return
     */

    public AndroidSpan drawURLSpan(final String url) {
        URLSpan Urlspan = new URLSpan(url);
        drawSpan(url, Urlspan);
        return this;
    }

    /**
     * 标准文本对齐样式
     *
     * @param text
     * @param align "ALIGN_CENTER"、"ALIGN_NORMAL" 或"ALIGN_OPPOSITE"中的之一
     * @return
     */
    public AndroidSpan drawAlignmentSpan(String text, Layout.Alignment align) {
        AlignmentSpan.Standard span = new AlignmentSpan.Standard(align);
        drawSpan(text, span);
        return this;
    }

    /**
     * 删除线样式
     *
     * @param text
     * @return
     */
    public AndroidSpan drawStrikethroughSpan(String text) {
        StrikethroughSpan span = new StrikethroughSpan();
        drawSpan(text, span);
        return this;
    }

    /**
     * 背景样式
     *
     * @param text
     * @param color
     * @return
     */
    public AndroidSpan drawBackgroundColorSpan(String text, int color) {
        BackgroundColorSpan span = new BackgroundColorSpan(color);
        drawSpan(text, span);
        return this;
    }

    /**
     * 模糊效果
     *
     * @param text
     * @param density
     * @param style   BlurMaskFilter.Blur.NORMAL
     * @return
     */
    public AndroidSpan drawMaskFilterSpan(String text, float density, BlurMaskFilter.Blur style) {
        MaskFilterSpan span = new MaskFilterSpan(new BlurMaskFilter(density, style));
        drawSpan(text, span);
        return this;
    }

    /**
     * 脚注样式，比如化学式的常见写法，当然，还可以对脚注的文字做一定的缩放
     *
     * @param text
     * @return
     */
    public AndroidSpan drawSubscriptSpan(String text) {
        SubscriptSpan span = new SubscriptSpan();
        drawSpan(text, span);
        return this;
    }

    /**
     * 上标样式，比如数学上的次方运算
     * @param text
     * @return
     */
    public AndroidSpan drawSuperscriptSpan(String text) {
        SuperscriptSpan span = new SuperscriptSpan();
        drawSpan(text, span);
        return this;
    }

    /**
     * 由正常、粗体、斜体和同时加粗倾斜四种样式
     * @param text
     * @param style Typeface.BOLD | Typeface.ITALIC |Typeface.BOLD_ITALIC
     * @return
     */
    public AndroidSpan drawStyleSpan(String text, int style) {
        StyleSpan span = new StyleSpan(style);
        drawSpan(text, span);
        return this;
    }

    /**
     * 指定绝对尺寸来改变文本的字体大小
     * @param text
     * @param size
     * @param dip
     * @return
     */
    public AndroidSpan drawAbsoluteSizeSpan(String text, int size, boolean dip) {
        AbsoluteSizeSpan span = new AbsoluteSizeSpan(size, dip);
        drawSpan(text, span);
        return this;
    }

    /**
     * 同比放大索小
     *
     * @param text
     * @return
     */
    public AndroidSpan drawRelativeSizeSpan(String text, float proportion) {
        RelativeSizeSpan span = new RelativeSizeSpan(proportion);
        drawSpan(text, span);
        return this;
    }

    /**
     * style文件来定义文本样式
     * @param text
     * @param context
     * @param appearance
     * @return
     */
    public AndroidSpan drawTextAppearanceSpan(String text, Context context, int appearance) {
        TextAppearanceSpan span = new TextAppearanceSpan(context, appearance);
        drawSpan(text, span);
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
        drawSpan(text, span);
        return this;
    }

    /**
     * 缩放X大小
     * @param text
     * @param proportion
     * @return
     */
    public AndroidSpan drawScaleXSpan(String text, float proportion) {
        ScaleXSpan span = new ScaleXSpan(proportion);
        drawSpan(text, span);
        return this;
    }

    /**
     * 字体样式
     * @param text
     * @param typeface serif
     * @return
     */
    public AndroidSpan drawTypefaceSpan(String text, String typeface) {
        TypefaceSpan span = new TypefaceSpan(typeface);
        drawSpan(text, span);
        return this;
    }

    /**
     * 图片样式
     * @param text
     * @param context
     * @param imgId
     * @return
     */
    public AndroidSpan drawImageSpan(String text, Context context, int imgId) {
        ImageSpan span = new ImageSpan(context, imgId);
        drawSpan(text, span);
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
        drawSpan(text, span);
        return this;
    }

    public void drawSpan(String text, Object span) {
        WordPosition wordPosition = getWordPosition(text);
        spannableStringBuilder.append(text);
        if (span == null) {
            return;
        }
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
