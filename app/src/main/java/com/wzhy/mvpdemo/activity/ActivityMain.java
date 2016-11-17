package com.wzhy.mvpdemo.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

import com.wzhy.mvpdemo.R;
import com.wzhy.mvpdemo.bean.User;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivityMain extends AppCompatActivity {

    @BindView(R.id.tv_welcome)
    TextView mTvWelcome;
    private int mStartIndex = 0;
    int[] mColors = new int[]{
            Color.rgb(0xFF,0x00,0x00), Color.rgb(0xFF,0x80,0x00),
            Color.rgb(0xFF,0xFF,0x00), Color.rgb(0x00,0xFF,0x00),
            Color.rgb(0x00,0xFF,0x80), Color.rgb(0x00,0xFF,0xFF),
            Color.rgb(0x00,0x00,0xFF), Color.rgb(0x80,0x00,0xFF),
            Color.rgb(0xFF,0x00,0xFF)};
    private SpannableStringBuilder mBuilder;
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            mBuilder.setSpan(new ForegroundColorSpan(mColors[(mStartIndex++) % mColors.length]), mLen, mLen + mUserName.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            mTvWelcome.setText(mBuilder);
            sendEmptyMessageDelayed(0,60);
        }
    };
    private Thread mTask;
    private int mLen;
    private String mUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        User _user = (User) getIntent().getSerializableExtra("user");

        mUserName = _user.getUsername();

        showText(mUserName);

        //showInfo(mUserName);
    }


    /**
     * 为TextView设置文字，部分文字颜色为红色
     * @param pText 红色字体部分文字
     */
    private void showInfo(String pText) {
        StringBuilder _builder = new StringBuilder();
        _builder.append("欢迎<font color = 'red' >");
        _builder.append(pText + "</font>" +"登陆");
        mTvWelcome.setText(Html.fromHtml(_builder.toString()));
    }

    /**
     * 为TextView设置文字，部分文字颜色不停变化
     * @param pText 红色字体部分文字
     */
    public void showText(String pText){
        mBuilder = new SpannableStringBuilder();
        mBuilder.append("欢迎");
        mLen = mBuilder.length();
        mBuilder.append(pText);
        mBuilder.append("登陆");

        mTask = new Thread(new Runnable() {

            @Override
            public void run() {
                mHandler.sendEmptyMessageDelayed(0,60);
            }
        });
        mTask.start();

    }

    @Override
    protected void onDestroy() {
        mTask.interrupt();
        super.onDestroy();
    }
}
