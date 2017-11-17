package com.zengxh.framework_demo.View.Activity;

import android.os.Bundle;

import com.zengxh.framework_demo.Model.Speaker;
import com.zengxh.framework_demo.Presenter.BasePresenter;
import com.zengxh.framework_demo.R;
import com.zengxh.framework_demo.TestContact;

import java.util.List;

public class MainActivity extends BaseActivity<TestContact.TestPresenter> implements TestContact.TestView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public TestContact.TestPresenter initPresenter() {
        return null;
    }

    @Override
    public void setPresenter(BasePresenter P) {

    }

    @Override
    public void setData(List<Speaker> dataList) {

    }
}
