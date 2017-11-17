package com.zengxh.framework_demo.Presenter;

import com.zengxh.framework_demo.TestContact;

/**
 * Created by simtech on 17/11/2017.
 */

public class TestPresenterImpl extends BasePresenterImpl<TestContact.TestView> implements TestContact.TestPresenter {

    public TestPresenterImpl(TestContact.TestView view) {
        super(view);
    }

    /**
     * 获取数据
     */
    @Override
    public void getData() {
    }
}
