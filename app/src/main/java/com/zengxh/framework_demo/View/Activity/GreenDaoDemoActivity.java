package com.zengxh.framework_demo.View.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.zengxh.framework_demo.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GreenDaoDemoActivity extends Activity {
    @Bind(R.id.et_gd_search_id)
    EditText etGdSearchId;
    @Bind(R.id.btn_gd_get_data)
    Button btnGdGetData;
    @Bind(R.id.lv_gd_data)
    ListView lvGdData;
    @Bind(R.id.btn_gd_create_data)
    Button btnGdCreateData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_green_dao);
        ButterKnife.bind(this);
    }
}
