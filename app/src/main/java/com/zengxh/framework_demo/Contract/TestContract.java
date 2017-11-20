package com.zengxh.framework_demo.Contract;

import com.zengxh.framework_demo.Model.Speaker;
import com.zengxh.framework_demo.Presenter.BasePresenter;
import com.zengxh.framework_demo.View.BaseView;

import java.util.List;

/**
 * Created by simtech on 17/11/2017.
 */

public interface TestContract {
    interface TestView extends BaseView {
        /**
         * 设置数据
         *
         * @param dataList
         */
        void setData(List<Speaker> dataList);
    }

    interface TestPresenter extends BasePresenter {
        /**
         * 获取数据
         */
        void getData();
    }
}
