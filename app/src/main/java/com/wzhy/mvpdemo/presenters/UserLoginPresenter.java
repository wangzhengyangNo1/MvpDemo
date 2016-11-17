package com.wzhy.mvpdemo.presenters;

import android.os.Handler;

import com.wzhy.mvpdemo.bean.User;
import com.wzhy.mvpdemo.model.OnLoginListener;
import com.wzhy.mvpdemo.model.UserModel;
import com.wzhy.mvpdemo.view.IUserLoginView;

/**
 * Created by wzhy on 2016/11/16.
 */

public class UserLoginPresenter {

    private UserModel mUserModel;
    private IUserLoginView mUserLoginView;
    private Handler mHandler = new Handler();

    public UserLoginPresenter(IUserLoginView mUserLoginView) {
        this.mUserModel = new UserModel();
        this.mUserLoginView = mUserLoginView;
    }

    public void login(){
        mUserLoginView.showLoading();
        mUserModel.login(mUserLoginView.getUsername(), mUserLoginView.getPassword(), new OnLoginListener() {
            @Override
            public void success(final User pUser) {

                //需要在UI线程中执行
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mUserLoginView.toActivity(pUser);
                        mUserLoginView.hideLoading();
                    }
                });
            }

            @Override
            public void error() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mUserLoginView.showError();
                        mUserLoginView.hideLoading();
                    }
                });
            }
        });
    }

    public void clear(){
        mUserLoginView.clearUsername();
        mUserLoginView.clearPassword();
    }
}
