package com.zengxh.framework_demo.View.Activity;

import android.os.Bundle;
import android.widget.ListView;

import com.zengxh.framework_demo.Contract.TestContract;
import com.zengxh.framework_demo.Model.Speaker;
import com.zengxh.framework_demo.Presenter.TestPresenterImpl;
import com.zengxh.framework_demo.R;
import com.zengxh.framework_demo.View.Adapter.TestAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by simtech on 24/11/2017.
 */

public class ListDemoActivity extends BaseActivity<TestContract.TestPresenter> implements TestContract.TestView {

    @Bind(R.id.lv_test_data)
    ListView lvTestData;
    TestAdapter adapter;
    List<Speaker> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_list);
        ButterKnife.bind(this);
        initView();
        presenter.getData();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public TestContract.TestPresenter initPresenter() {
        return new TestPresenterImpl(this);
    }

    @Override
    public void dismissLoadingDialog() {
        super.dismissLoadingDialog();
    }

    @Override
    public void initView() {

    }

    @Override
    public void initEvent() {

    }

    @Override
    public void showLoadingDialog(String msg) {
        super.showLoadingDialog(msg);
    }

    @Override
    public void setSpeakerData(List<Speaker> dataList) {
        data = dataList;
        adapter = new TestAdapter(context, data);
        lvTestData.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
