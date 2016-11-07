package com.shellever.hanzitopinyin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

// Link:
// http://www.codefans.net/articles/933.shtml
// http://blog.csdn.net/lmj623565791/article/details/23187701
// http://pinyin4j.sourceforge.net/

// http://unicode-table.com/en/
// https://en.wikipedia.org/wiki/Pinyin
// http://pinyin4j.sourceforge.net/html/combination.html
public class MainActivity extends AppCompatActivity {

    private TextView tv_pinyin;
    private EditText et_hanzi;
    private Button btn_convert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_pinyin = (TextView) findViewById(R.id.tv_pinyin);
        et_hanzi = (EditText) findViewById(R.id.et_hanzi);
        btn_convert = (Button) findViewById(R.id.btn_convert);

        btn_convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hanzi = et_hanzi.getText().toString();
                if (TextUtils.isEmpty(hanzi)) {
                    Toast.makeText(MainActivity.this, "No hanzi, please input again.", Toast.LENGTH_SHORT).show();
                } else {
                    StringBuilder builder = new StringBuilder();
                    builder.append(hanzi);
                    builder.append("\n=>\n");
                    // 拼音字母全部小写，没有分隔符
                    builder.append(PinyinUtils.toPinyinString(hanzi));
                    builder.append("\n=>\n");
                    // 拼音首字母大写
                    builder.append(PinyinUtils.toPinyinString(hanzi, PinyinUtils.CASE_CAPITALIZE));
                    builder.append("\n=>\n");
                    // 拼音取首字母且大写，从左到右
                    builder.append(PinyinUtils.toPinyinString(hanzi,
                            PinyinUtils.CASE_UPPERCASE | PinyinUtils.LETTER_FIRST));
                    builder.append("\n=>\n");
                    // 拼音取首字母且大写，从右到左，连字符分隔
                    builder.append(PinyinUtils.toPinyinString(hanzi,
                            PinyinUtils.CASE_UPPERCASE
                                    | PinyinUtils.LETTER_FIRST_INV
                                    | PinyinUtils.SEPARATOR_HYPHEN));
                    builder.append("\n=>\n");
                    // 拼音取尾字母且大写，从右到左
                    builder.append(PinyinUtils.toPinyinString(hanzi,
                            PinyinUtils.CASE_UPPERCASE | PinyinUtils.LETTER_LAST_INV));
                    builder.append("\n=>\n");
                    // 拼音首字母大写且空格分开
                    builder.append(PinyinUtils.toPinyinString(hanzi,
                            PinyinUtils.CASE_CAPITALIZE | PinyinUtils.SEPARATOR_BLANK));
                    builder.append("\n=>\n");
                    // 拼音首字母大写且英文句号分开
                    builder.append(PinyinUtils.toPinyinString(hanzi,
                            PinyinUtils.CASE_CAPITALIZE | PinyinUtils.SEPARATOR_POINT));
                    tv_pinyin.setText(builder.toString());
                    et_hanzi.setText("");
                }
            }
        });
    }

    // ??
    // HanziToPinyin是一个单例，获得该类实例后，get方法传入一个字符串，
    // 然后会对每个字符串的每个字符进行解析，解析结果存入Token中
    public void testHanziToPinyin(String s) {
        Toast.makeText(MainActivity.this, "testHanziToPinyin", Toast.LENGTH_SHORT).show();
        ArrayList<HanziToPinyin.Token> list = HanziToPinyin.getInstance().get(s);
        if (list.isEmpty()) {       // ?? Token list is empty []
            Toast.makeText(MainActivity.this, "Token list is empty", Toast.LENGTH_SHORT).show();
            return;
        }
        for (HanziToPinyin.Token token : list) {
            String info = token.source + " , " + token.target + " , " + token.type;
            System.out.print(info);
            Toast.makeText(MainActivity.this, info, Toast.LENGTH_SHORT).show();
            System.out.println();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // 点击空白区域 自动隐藏软键盘
        if(this.getCurrentFocus() != null){
            InputMethodManager mInputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            return mInputMethodManager.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), 0);
        }
        return super.onTouchEvent(event);
    }
}

/*
// 零零碎碎的生活
// WITH_U_AND_COLON / WITH_TONE_NUMBER
10-12 15:06:56.805 31059-31059/com.shellever.hanzitopinyin I/System.out: [ling2]
10-12 15:06:56.805 31059-31059/com.shellever.hanzitopinyin I/System.out: [ling2]
10-12 15:06:56.805 31059-31059/com.shellever.hanzitopinyin I/System.out: [sui4]
10-12 15:06:56.805 31059-31059/com.shellever.hanzitopinyin I/System.out: [sui4]
10-12 15:06:56.805 31059-31059/com.shellever.hanzitopinyin I/System.out: [de5, di4, di2]
10-12 15:06:56.805 31059-31059/com.shellever.hanzitopinyin I/System.out: [sheng1]
10-12 15:06:56.805 31059-31059/com.shellever.hanzitopinyin I/System.out: [huo2]

// WITH_U_UNICODE / WITH_TONE_MARK
10-12 15:13:04.152 3118-3118/com.shellever.hanzitopinyin I/System.out: [líng]
10-12 15:13:04.153 3118-3118/com.shellever.hanzitopinyin I/System.out: [líng]
10-12 15:13:04.153 3118-3118/com.shellever.hanzitopinyin I/System.out: [suì]
10-12 15:13:04.154 3118-3118/com.shellever.hanzitopinyin I/System.out: [suì]
10-12 15:13:04.156 3118-3118/com.shellever.hanzitopinyin I/System.out: [de, dì, dí]
10-12 15:13:04.157 3118-3118/com.shellever.hanzitopinyin I/System.out: [shēng]
10-12 15:13:04.157 3118-3118/com.shellever.hanzitopinyin I/System.out: [huó]
 */