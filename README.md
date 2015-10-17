#AndroidSpan
The AndroidSpan is a tool library for easy to use Android SpannableStringBuilder

#Demo
![demo](http://7o4zmy.com1.z0.glb.clouddn.com/QQ20151017-2.png)

#Usage

#Gradle
```
dependencies {
   compile 'com.daimajia.numberprogressbar:library:1.2@aar'
}
```
##### Use it in your own code:
```
  AndroidSpan androidSpan = new AndroidSpan()
                .drawUnderlineSpan("测试文本")
                .drawRelativeSize("我要变大", 2.0f)
                .drawForegroundColor("红色的文本", Color.RED)
                .drawImageSpan("来个图片试试", getApplicationContext(), R.mipmap.ic_launcher)
                .drawBulletSpan("bullet", 20, Color.GREEN)
                .drawURLSpan("tel:18721850636")
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
```
##### you will see the demo picture
