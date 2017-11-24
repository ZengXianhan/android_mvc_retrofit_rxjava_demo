package com.zengxh.framework_demo.View.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zengxh.framework_demo.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends Activity {
    Intent intent;

    @Bind(R.id.btn_main_go_to_list)
    Button btnMainGoToList;
    @Bind(R.id.btn_main_go_to_green_dao)
    Button btnMainGoToGreenDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initEvent();
    }

    private void initEvent(){
        btnMainGoToList.setOnClickListener(onClickListener);
        btnMainGoToGreenDao.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_main_go_to_list:
                    //TODO implement
                    intent = new Intent(getApplicationContext(),ListDemoActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_main_go_to_green_dao:
                    //TODO implement
                    intent = new Intent(getApplicationContext(),GreenDaoDemoActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };
}
