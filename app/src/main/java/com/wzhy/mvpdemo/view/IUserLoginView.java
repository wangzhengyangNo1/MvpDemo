package com.wzhy.mvpdemo.view;


import com.wzhy.mvpdemo.bean.User;

/**
 * Created by wzhy on 2016/11/16.
 */

public interface IUserLoginView {

    String getUsername();

    String getPassword();

    void clearUsername();

    void clearPassword();

    void showLoading();

    void hideLoading();

    void toActivity(User pUser);

    void showError();
}
