package com.wzhy.mvpdemo.model;

/**
 * Created by wzhy on 2016/11/16.
 */

public interface IUserModel {
    void login(String pName, String pPsd, OnLoginListener pLoginListener);
}
