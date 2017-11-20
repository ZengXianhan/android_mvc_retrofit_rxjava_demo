package com.zengxh.framework_demo.View.Activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.ListView;

import com.zengxh.framework_demo.Model.Speaker;
import com.zengxh.framework_demo.Presenter.BasePresenter;
import com.zengxh.framework_demo.Presenter.TestPresenterImpl;
import com.zengxh.framework_demo.R;
import com.zengxh.framework_demo.Contract.TestContract;
import com.zengxh.framework_demo.View.Adapter.TestAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<TestContract.TestPresenter> implements TestContract.TestView {

    @Bind(R.id.lv_test_data)
    ListView lvTestData;

    TestAdapter adapter;
    List<Speaker> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        presenter.getData();
    }

    @Override
    public TestContract.TestPresenter initPresenter() {
        return new TestPresenterImpl(this);
    }

    @Override
    public void initView() {
    }

    @Override
    public void initEvent() {

    }

    @Override
    public void setPresenter(BasePresenter P) {

    }

    @Override
    public void setData(List<Speaker> dataList) {
        data = dataList;
        adapter = new TestAdapter(context, data);
        lvTestData.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
