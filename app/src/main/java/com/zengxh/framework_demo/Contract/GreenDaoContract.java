package com.zengxh.framework_demo.Contract;

import android.content.Context;

import com.zengxh.framework_demo.Model.Speaker;
import com.zengxh.framework_demo.Presenter.BasePresenter;
import com.zengxh.framework_demo.View.BaseView;

import java.util.List;

/**
 * Created by simtech on 24/11/2017.
 */

public interface GreenDaoContract {
    interface View extends BaseView {
        /**
         * 设置数据
         *
         * @param dataList
         */
        void setSpeakerData(List<Speaker> dataList);  //set Data to the View
        void updateData(List<Speaker> dataList);
        void searchDataById(String id);
    }

    interface Presenter extends BasePresenter {
        /**
         * 获取数据
         */
        void saveData(Context context);
        void getData(); //get data from Model
    }
}
