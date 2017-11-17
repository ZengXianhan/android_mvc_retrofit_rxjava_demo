package com.zengxh.framework_demo.Model;

import java.util.List;

/**
 * Created by simtech on 17/11/2017.
 */

public class DataBean<V> {
    private String message;
    private String Status;
    private List<V> data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public List<V> getData() {
        return data;
    }

    public void setData(List<V> data) {
        this.data = data;
    }
}
