package com.wzhy.mvpdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.TextView;

import com.wzhy.mvpdemo.R;
import com.wzhy.mvpdemo.bean.User;

import java.io.Serializable;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivityMain extends AppCompatActivity {

    @BindView(R.id.tv_welcome)
    TextView mTvWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        User _user = (User) getIntent().getSerializableExtra("user");

        StringBuilder _builder = new StringBuilder();
        _builder.append("欢迎<font color = 'red' >");
        _builder.append(_user.getUsername() + "</font>" +"登陆");
        mTvWelcome.setText(Html.fromHtml(_builder.toString()));
//        mTvWelcome.setText(_user.getUsername());
    }
}
