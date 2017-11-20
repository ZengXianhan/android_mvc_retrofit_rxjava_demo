package com.zengxh.framework_demo.Presenter;

import android.util.Log;

import com.zengxh.framework_demo.Contract.TestContract;
import com.zengxh.framework_demo.Model.DataBean;
import com.zengxh.framework_demo.Model.Speaker;
import com.zengxh.framework_demo.Util.Api;
import com.zengxh.framework_demo.Util.RetrofitFactory;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by simtech on 17/11/2017.
 */

public class TestPresenterImpl extends BasePresenterImpl<TestContract.TestView> implements TestContract.TestPresenter {

    public TestPresenterImpl(TestContract.TestView view) {
        super(view);
    }

    /**
     * 获取数据
     */
    @Override
    public void getData() {
        RetrofitFactory.getInstance()
                .test()//测试接口
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(@NonNull Disposable disposable) throws Exception {
                        Log.e("Log","doOnSubscribe");
                        addDisposable(disposable);//请求加入管理
                        view.showLoadingDialog("Loading");
                    }
                })
                .map(new Function<DataBean<Speaker>, List<Speaker>>() {
                    @Override
                    public List<Speaker> apply(@NonNull DataBean<Speaker> testBean) throws Exception {
                        Log.e("Log","map");
                        return testBean.getData();//转换数据
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Speaker>>() {
                    @Override
                    public void accept(@NonNull List<Speaker> speakerBean) throws Exception {
                        Log.e("Log", "subscribe success");
                        view.setData(speakerBean);
                        view.dismissLoadingDialog();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        view.dismissLoadingDialog();
                        Log.e("Log",throwable.getMessage());
                    }
                });
    }
}
