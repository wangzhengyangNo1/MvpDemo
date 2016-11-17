package com.wzhy.mvpdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.wzhy.mvpdemo.R;
import com.wzhy.mvpdemo.bean.User;
import com.wzhy.mvpdemo.presenters.UserLoginPresenter;
import com.wzhy.mvpdemo.view.IUserLoginView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class ActivityLogin extends AppCompatActivity implements IUserLoginView {

    /*绑定控件*/
    @BindView(R.id.edt_user_name)
    AppCompatEditText mEdtUserName;
    @BindView(R.id.edt_password)
    AppCompatEditText mEdtPassword;
    @BindView(R.id.progress_bar)
    ProgressBar mProgressBar;
    @BindView(R.id.btn_login)
    AppCompatButton mBtnLogin;
    @BindView(R.id.btn_clear)
    AppCompatButton mBtnClear;

    private Unbinder mUnbinder;

    private UserLoginPresenter mLoginPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mUnbinder = ButterKnife.bind(this);

        mLoginPresenter = new UserLoginPresenter(this);

    }

   @OnClick({R.id.btn_login, R.id.btn_clear})
   public void onClick(AppCompatButton pBtn){
       switch (pBtn.getId()){
           case R.id.btn_login:
               mLoginPresenter.login();
               break;

           case R.id.btn_clear:
               mLoginPresenter.clear();
               break;
       }
   }

    @Override
    protected void onDestroy() {
        //ButterKnife解除绑定
        mUnbinder.unbind();
        super.onDestroy();
    }

    @Override
    public String getUsername() {
        String _username = mEdtUserName.getText().toString();
        return TextUtils.isEmpty(_username) ? null : _username;
    }

    @Override
    public String getPassword() {
        String _password = mEdtPassword.getText().toString();
        return TextUtils.isEmpty(_password) ? null : _password;
    }

    @Override
    public void clearUsername() {
        mEdtUserName.setText("");
    }

    @Override
    public void clearPassword() {
        mEdtPassword.setText("");
    }

    @Override
    public void showLoading() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void toActivity(User pUser) {
        showTip("登陆成功");
        startActivity(new Intent(getApplicationContext(),ActivityMain.class).putExtra("user",pUser));
        finish();
    }

    @Override
    public void showError() {
        showTip("用户名或密码不正确");
    }

    private void showTip(String pTip){
        Toast.makeText(getApplicationContext(), pTip, Toast.LENGTH_SHORT).show();
    }
}
