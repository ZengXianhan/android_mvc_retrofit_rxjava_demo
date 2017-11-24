package com.zengxh.framework_demo.Database;

import android.content.Context;

import com.zengxh.framework_demo.Model.Speaker;
import com.zengxh.greendao.db.DaoMaster;
import com.zengxh.greendao.db.DaoSession;
import com.zengxh.greendao.db.SpeakerDao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/**
 * Created by simtech on 24/11/2017.
 */

public class SpeakerDB extends DBManager implements BaseDB<Speaker> {
    private static String LOG_TAG = "com.zengxh.framework_demo.Database.SpeakerDB";

    public SpeakerDB(Context context) {
        super(context);
    }

    @Override
    public void insert(Speaker speaker) {
        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        SpeakerDao dao = daoSession.getSpeakerDao();
        dao.insert(speaker);
    }

    @Override
    public void insertList(List<Speaker> speakers) {
        if (speakers == null || speakers.isEmpty()) {
            return;
        }
        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        SpeakerDao dao = daoSession.getSpeakerDao();
        dao.insertInTx(speakers);
    }

    @Override
    public void delete(Speaker speaker) {
        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        SpeakerDao dao = daoSession.getSpeakerDao();
        dao.delete(speaker);
    }

    @Override
    public void delete(String id) {
        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        SpeakerDao dao = daoSession.getSpeakerDao();
        dao.delete(read(id));
    }

    @Override
    public void update(Speaker speaker) {
        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        SpeakerDao dao = daoSession.getSpeakerDao();
        dao.update(speaker);
    }

    @Override
    public void update(String id) {
        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        SpeakerDao dao = daoSession.getSpeakerDao();
        dao.update(read(id));
    }

    @Override
    public List<Speaker> readList() {
        DaoMaster daoMaster = new DaoMaster(getReadableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        SpeakerDao dao = daoSession.getSpeakerDao();
        QueryBuilder<Speaker> qb = dao.queryBuilder();
        List<Speaker> list = qb.list();
        return list;
    }

    @Override
    public Speaker read(String id) {
        DaoMaster daoMaster = new DaoMaster(getReadableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        SpeakerDao dao = daoSession.getSpeakerDao();
        QueryBuilder<Speaker> qb = dao.queryBuilder();
        Speaker speaker = qb.uniqueOrThrow();
        return speaker;
    }
}
