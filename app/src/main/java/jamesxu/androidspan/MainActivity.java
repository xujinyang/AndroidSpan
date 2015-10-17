package jamesxu.androidspan;

import android.graphics.BlurMaskFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import me.jamesxu.androidspan.AndroidSpan;
import me.jamesxu.androidspan.SpanOptions;


public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.text);
        setText();
    }

    private void setText() {
        AndroidSpan androidSpan = new AndroidSpan()
                .drawUnderlineSpan("测试文本")
                .drawRelativeSize("我要变大", 2.0f)
                .drawForegroundColor("红色的文本", Color.RED)
                .drawWithOptions("综合效果", new SpanOptions().addBackgroundColorSpan(Color.GREEN).addUnderlineSpan())
                .drawImageSpan("来个图片试试", getApplicationContext(), R.mipmap.ic_launcher)
                .drawBulletSpan("bullet", 20, Color.GREEN)
                .drawURLSpan("tel:18721850636", getApplicationContext(), null)
                .drawStrikethroughSpan("删除线")
                .drawURLSpan("http://www.baidu.com", getApplicationContext(), null)
                .drawStyleSpan("粗体", android.graphics.Typeface.BOLD)
                .drawSubscriptSpan("上标")
                .drawSuperscriptSpan("下标")
                .drawMaskFilterSpan("模糊效果", 1f, BlurMaskFilter.Blur.NORMAL);

        textView.setText(androidSpan.getSpanText());
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

}
