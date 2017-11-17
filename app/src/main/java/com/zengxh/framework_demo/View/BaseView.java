package com.zengxh.framework_demo.View;

import com.zengxh.framework_demo.Presenter.BasePresenter;

/**
 * Created by simtech on 17/11/2017.
 */

public interface BaseView<P> {
    //设置Presenter
    void setPresenter(BasePresenter P);
    //显示dialog
    void showLoadingDialog(String msg);
    //取消dialog
    void dismissLoadingDialog();
}
