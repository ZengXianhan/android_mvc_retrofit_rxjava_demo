package com.zengxh.framework_demo.View;

import com.zengxh.framework_demo.Presenter.BasePresenter;

/**
 * Created by simtech on 17/11/2017.
 */

public interface BaseView<P> {
    //初始化view
    void initView();
    //初始化事件
    void initEvent();
    //显示dialog
    void showLoadingDialog(String msg);
    //取消dialog
    void dismissLoadingDialog();
}
