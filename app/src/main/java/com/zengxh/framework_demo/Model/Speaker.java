package com.zengxh.framework_demo.Model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by simtech on 17/11/2017.
 */

@Entity
public class Speaker {
    /**
     * s_companay : American Bureau of Shipping
     * s_job : -
     * UpdatedTime : 1509716325.9683
     * s_address : -
     * clientID : 293
     * s_mobile : -
     * s_profilepic : http://203.127.83.146/mobileotcasia2018/Images/FrontEnd_Photos/-
     * ID : RID14381
     * s_country : -
     * s_fullname : Ruiyi Zhu
     * s_bio : -
     * s_email : ruzhu@eagle.org
     */

    private String s_companay;
    private String s_job;
    private String UpdatedTime;
    private String s_address;
    private String clientID;
    private String s_mobile;
    private String s_profilepic;
    private String ID;
    private String s_country;
    private String s_fullname;
    private String s_bio;
    private String s_email;

    @Generated(hash = 2062144608)
    public Speaker(String s_companay, String s_job, String UpdatedTime, String s_address,
            String clientID, String s_mobile, String s_profilepic, String ID,
            String s_country, String s_fullname, String s_bio, String s_email) {
        this.s_companay = s_companay;
        this.s_job = s_job;
        this.UpdatedTime = UpdatedTime;
        this.s_address = s_address;
        this.clientID = clientID;
        this.s_mobile = s_mobile;
        this.s_profilepic = s_profilepic;
        this.ID = ID;
        this.s_country = s_country;
        this.s_fullname = s_fullname;
        this.s_bio = s_bio;
        this.s_email = s_email;
    }

    @Generated(hash = 2083994827)
    public Speaker() {
    }

    public String getS_companay() {
        return s_companay;
    }

    public void setS_companay(String s_companay) {
        this.s_companay = s_companay;
    }

    public String getS_job() {
        return s_job;
    }

    public void setS_job(String s_job) {
        this.s_job = s_job;
    }

    public String getUpdatedTime() {
        return UpdatedTime;
    }

    public void setUpdatedTime(String UpdatedTime) {
        this.UpdatedTime = UpdatedTime;
    }

    public String getS_address() {
        return s_address;
    }

    public void setS_address(String s_address) {
        this.s_address = s_address;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getS_mobile() {
        return s_mobile;
    }

    public void setS_mobile(String s_mobile) {
        this.s_mobile = s_mobile;
    }

    public String getS_profilepic() {
        return s_profilepic;
    }

    public void setS_profilepic(String s_profilepic) {
        this.s_profilepic = s_profilepic;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getS_country() {
        return s_country;
    }

    public void setS_country(String s_country) {
        this.s_country = s_country;
    }

    public String getS_fullname() {
        return s_fullname;
    }

    public void setS_fullname(String s_fullname) {
        this.s_fullname = s_fullname;
    }

    public String getS_bio() {
        return s_bio;
    }

    public void setS_bio(String s_bio) {
        this.s_bio = s_bio;
    }

    public String getS_email() {
        return s_email;
    }

    public void setS_email(String s_email) {
        this.s_email = s_email;
    }
}
