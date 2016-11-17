package com.wzhy.mvpdemo.model;

import com.wzhy.mvpdemo.bean.User;

/**
 * Created by wzhy on 2016/11/16.
 */

public interface OnLoginListener {
    void success(User pUser);

    void error();
}
