package com.wzhy.mvpdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class ActivityLogin extends AppCompatActivity {

    /*绑定控件*/
    @BindView(R.id.edt_user_name)
    AppCompatEditText mEdtUserName;
    @BindView(R.id.edt_password)
    AppCompatEditText mEdtPassword;
    @BindView(R.id.btn_login)
    AppCompatButton mBtnLogin;
    @BindView(R.id.btn_clear)
    AppCompatButton mBtnClear;
    private Unbinder mUnbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mUnbinder = ButterKnife.bind(this);

    }

    @OnClick({R.id.btn_login, R.id.btn_clear})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:

                break;
            case R.id.btn_clear:

                break;
        }
    }

    @Override
    protected void onDestroy() {
        mUnbinder.unbind();
        super.onDestroy();
    }
}
