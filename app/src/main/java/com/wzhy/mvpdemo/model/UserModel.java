package com.wzhy.mvpdemo.model;

import com.wzhy.mvpdemo.bean.User;

/**
 * Created by wzhy on 2016/11/16.
 */

public class UserModel implements IUserModel {

    @Override
    public void login(final String pName, final String pPsd, final OnLoginListener pLoginListener) {

            //模拟子线程耗时操作
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    //模拟登陆成功
                    if ("username".equals(pName)&&"password".equals(pPsd)){
                        pLoginListener.success(new User(pName,pPsd));
                    }else{
                        pLoginListener.error();
                    }

                }
            }).start();
    }
}
