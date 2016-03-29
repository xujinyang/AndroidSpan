package jamesxu.androidspan;

import android.graphics.BlurMaskFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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
                .drawBulletSpan("bullet", 40, Color.GREEN)
                .drawRelativeSize("我要变大", 2.0f)
                .drawUnderlineSpan("测试文本")
                .drawForegroundColor("红色的文本", Color.RED)
                .drawImageSpan("来个图片试试", getApplicationContext(), R.mipmap.ic_launcher)
                .drawURLSpan("tel:18721850636")
                .drawCommonSpan("没有效果")
                .drawStrikethroughSpan("删除线")
                .drawURLSpan("http://www.baidu.com")
                .drawStyleSpan("粗体", android.graphics.Typeface.BOLD)
                .drawSubscriptSpan("上标")
                .drawSuperscriptSpan("下标")
                .drawMaskFilterSpan("模糊效果", 1f, BlurMaskFilter.Blur.NORMAL)
                .drawWithOptions("点击效果", new SpanOptions().addSpan(new ClickableSpan() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getApplicationContext(), "哎呦，疼", Toast.LENGTH_LONG).show();
                    }
                }))
                .drawWithOptions("综合效果", new SpanOptions().addBackgroundColorSpan(Color.GREEN).addUnderlineSpan())
                .drawWithOptions("tel:18721850636", new SpanOptions().addForegroundColor(Color.GREEN));

        textView.setText(androidSpan.getSpanText());
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

}
