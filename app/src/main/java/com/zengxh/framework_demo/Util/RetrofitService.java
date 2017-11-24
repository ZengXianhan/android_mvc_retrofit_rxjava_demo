package com.zengxh.framework_demo.Util;

import com.zengxh.framework_demo.Model.DataBean;
import com.zengxh.framework_demo.Model.Speaker;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by simtech on 17/11/2017.
 */

public interface RetrofitService {

    String Test_URL = "http://203.127.83.146/mobileotcasia2018/apiv1/";

    /**
     * 测试接口
     *
     * @return
     */
    @GET("MasterAPI?Page=Speaker&lang=en")
    Observable<DataBean<Speaker>> test();
}
