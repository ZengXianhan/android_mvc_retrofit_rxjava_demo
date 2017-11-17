package com.zengxh.framework_demo.View.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.zengxh.framework_demo.Presenter.BasePresenter;
import com.zengxh.framework_demo.Util.ActivityManager;
import com.zengxh.framework_demo.View.BaseView;

/**
 * Created by simtech on 17/11/2017.
 */

public abstract class BaseActivity <P extends BasePresenter> extends AppCompatActivity implements BaseView {
    protected P presenter;
    public Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        ActivityManager.getAppInstance().addActivity(this);//将当前activity添加进入管理栈
        presenter = initPresenter();
    }

    @Override
    protected void onDestroy() {
        ActivityManager.getAppInstance().finishActivity(this);//将当前activity移除管理栈
        if (presenter != null) {
            presenter.detach();//在presenter中解绑释放view
            presenter = null;
        }
        super.onDestroy();
    }

    /**
     * 在子类中初始化对应的presenter
     *
     * @return 相应的presenter
     */
    public abstract P initPresenter();


    @Override
    public void dismissLoadingDialog() {

    }

    @Override
    public void showLoadingDialog(String msg) {

    }
}
