package com.zengxh.framework_demo.View.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zengxh.framework_demo.Presenter.BasePresenter;
import com.zengxh.framework_demo.R;
import com.zengxh.framework_demo.View.BaseView;

public class MainActivity extends BaseActivity<BasePresenter> implements BaseView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public BasePresenter initPresenter() {
        return null;
    }
}
