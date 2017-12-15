package com.zengxh.framework_demo.Presenter;

import android.content.Context;
import android.util.Log;

import com.zengxh.framework_demo.Contract.GreenDaoContract;
import com.zengxh.framework_demo.Database.SpeakerDB;
import com.zengxh.framework_demo.Model.DataBean;
import com.zengxh.framework_demo.Model.Speaker;
import com.zengxh.framework_demo.Util.RetrofitFactory;
import com.zengxh.greendao.db.SpeakerDao;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
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
    public void downloadData(final Context context) {
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
                        speakerDB.insertList(testBean.getData());
                        return testBean.getData();//转换数据
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Speaker>>() {
                    @Override
                    public void accept(@NonNull List<Speaker> speakerBean) throws Exception {
                        Log.d(LOG_TAG, "subscribe success");
                        view.setSpeakerData(speakerBean);
                        view.updateListView();
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
    public void saveData(Context context, final List<Speaker> speakers) {
        speakerDB = new SpeakerDB(context);
        Observable
                .create(new ObservableOnSubscribe<List<Speaker>>() {
                    @Override
                    public void subscribe(ObservableEmitter<List<Speaker>> emitter){
                        speakerDB.insertList(speakers);
                    }
                })
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(@NonNull Disposable disposable) throws Exception {
                        Log.d(LOG_TAG,"doOnSubscribe");
                        addDisposable(disposable);//请求加入管理
                        view.showLoadingDialog("Loading");
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Speaker>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(List<Speaker> data) {
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.getMessage();
                        view.dismissLoadingDialog();
                    }

                    @Override
                    public void onComplete() {
                        view.updateListView();
                        view.dismissLoadingDialog();
                    }
                });
    }

    @Override
    public void clearData(Context context) {
        speakerDB = new SpeakerDB(context);
        Observable
                .create(new ObservableOnSubscribe<List<Speaker>>() {
                    @Override
                    public void subscribe(ObservableEmitter<List<Speaker>> emitter) {
                        speakerDB.clearAllSpeaker();
                        emitter.onNext(speakerDB.readList());
                        emitter.onComplete();
                    }
                })
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(@NonNull Disposable disposable) throws Exception {
                        Log.d(LOG_TAG, "doOnSubscribe");
                        addDisposable(disposable);//请求加入管理
                        view.showLoadingDialog("Loading");
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Speaker>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(List<Speaker> data) {
                        view.setSpeakerData(data);
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.getMessage();
                        view.dismissLoadingDialog();
                    }

                    @Override
                    public void onComplete() {
                        view.updateListView();
                        view.dismissLoadingDialog();
                    }
                });
    }

    @Override
    public void getData(Context context) {
        speakerDB = new SpeakerDB(context);
        Observable
                .create(new ObservableOnSubscribe<List<Speaker>>() {
                    @Override
                    public void subscribe(ObservableEmitter<List<Speaker>> emitter) {
                        emitter.onNext(speakerDB.readList());
                    }
                })
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(@NonNull Disposable disposable) throws Exception {
                        addDisposable(disposable);//请求加入管理
                        view.showLoadingDialog("Loading");
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Speaker>>() {
                    @Override
                    public void accept(@NonNull List<Speaker> speakerBean) throws Exception {
                        view.setSpeakerData(speakerBean);
                        view.updateListView();
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
}
