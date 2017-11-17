package com.zengxh.framework_demo.View;

/**
 * Created by simtech on 17/11/2017.
 */

public interface BaseView {
    //显示dialog
    void showLoadingDialog(String msg);

    //取消dialog
    void dismissLoadingDialog();
}
