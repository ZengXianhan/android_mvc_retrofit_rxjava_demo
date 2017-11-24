package com.zengxh.framework_demo.Presenter;

import android.content.Context;
import android.util.Log;

import com.zengxh.framework_demo.Contract.GreenDaoContract;
import com.zengxh.framework_demo.Database.SpeakerDB;
import com.zengxh.framework_demo.Model.DataBean;
import com.zengxh.framework_demo.Model.Speaker;
import com.zengxh.framework_demo.Util.RetrofitFactory;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by simtech on 24/11/2017.
 */

public class GreenDaoPresenterImpl extends BasePresenterImpl<GreenDaoContract.View> implements GreenDaoContract.Presenter {
    private static String LOG_TAG = "TestPresenterImpl";
    private SpeakerDB speakerDB;
    public GreenDaoPresenterImpl(GreenDaoContract.View view) {
        super(view);
    }

    @Override
    public void saveData(final Context context) {
        speakerDB = new SpeakerDB(context);
        RetrofitFactory.getInstance()
                .test()//测试接口
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(@NonNull Disposable disposable) throws Exception {
                        Log.d(LOG_TAG,"doOnSubscribe");
                        addDisposable(disposable);//请求加入管理
                        view.showLoadingDialog("Loading");
                    }
                })
                .map(new Function<DataBean<Speaker>, List<Speaker>>() {
                    @Override
                    public List<Speaker> apply(@NonNull DataBean<Speaker> testBean) throws Exception {
                        Log.d(LOG_TAG,"map");
                        return testBean.getData();//转换数据
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Speaker>>() {
                    @Override
                    public void accept(@NonNull List<Speaker> speakerBean) throws Exception {
                        Log.d(LOG_TAG, "subscribe success");
                        speakerDB.insertList(speakerBean);
                        view.dismissLoadingDialog();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        view.dismissLoadingDialog();
                        Log.e(LOG_TAG,throwable.getMessage());
                    }
                });
    }

    @Override
    public void getData() {

    }
}
