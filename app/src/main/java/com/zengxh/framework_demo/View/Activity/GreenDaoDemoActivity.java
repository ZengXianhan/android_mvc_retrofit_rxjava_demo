package com.zengxh.framework_demo.View.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.zengxh.framework_demo.Contract.GreenDaoContract;
import com.zengxh.framework_demo.Model.Speaker;
import com.zengxh.framework_demo.Presenter.GreenDaoPresenterImpl;
import com.zengxh.framework_demo.R;
import com.zengxh.framework_demo.View.Adapter.TestAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GreenDaoDemoActivity extends BaseActivity<GreenDaoContract.Presenter> implements GreenDaoContract.View {
    @Bind(R.id.et_gd_search_id)
    EditText etGdSearchId;
    @Bind(R.id.btn_gd_get_data)
    Button btnGdGetData;
    @Bind(R.id.lv_gd_data)
    ListView lvGdData;
    @Bind(R.id.btn_gd_create_data)
    Button btnGdCreateData;
    @Bind(R.id.btn_gd_download_data)
    Button btnGdDownloadData;
    @Bind(R.id.btn_gd_clear_data)
    Button btnGdClearData;

    List<Speaker> data = new ArrayList<>();
    TestAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_green_dao);
        ButterKnife.bind(this);
        initView();
        initEvent();
    }

    @Override
    public GreenDaoContract.Presenter initPresenter() {
        return new GreenDaoPresenterImpl(this);
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
    public void initView() {
        presenter.getData(context);
        initListView();
    }

    @Override
    public void initEvent() {
        btnGdDownloadData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.downloadData(context);
            }
        });

        btnGdClearData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.clearData(context);
            }
        });
    }

    @Override
    public void setSpeakerData(List<Speaker> dataList) {
        data = dataList;
    }

    @Override
    public void searchDataById(String id) {

    }

    @Override
    public void updateListView() {
        adapter.updateAdapter(data);
    }

    @Override
    public void initListView() {
        adapter = new TestAdapter(context, data);
        lvGdData.setAdapter(adapter);
    }

    @Override
    public void dismissLoadingDialog() {
        super.dismissLoadingDialog();
    }

    @Override
    public void showLoadingDialog(String msg) {
        super.showLoadingDialog(msg);
    }
}
