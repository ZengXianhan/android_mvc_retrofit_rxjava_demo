package com.zengxh.framework_demo.View.Adapter;

import android.content.Context;
import android.support.constraint.Guideline;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zengxh.framework_demo.Model.Speaker;
import com.zengxh.framework_demo.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TestAdapter extends BaseAdapter {

    private List<Speaker> objects = new ArrayList<Speaker>();

    private Context context;
    private LayoutInflater layoutInflater;

    public TestAdapter(Context context, List<Speaker> objects) {
        this.context = context;
        this.objects = objects;
        this.layoutInflater = LayoutInflater.from(context);
    }

    public void updateAdapter(List<Speaker> data){
        objects = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Speaker getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.adapter_test, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews((Speaker) getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(Speaker object, ViewHolder holder) {
        //TODO implement
        holder.testName.setText(object.getS_fullname());
        holder.testCompany.setText(object.getS_companay());
    }

    static class ViewHolder {
        @Bind(R.id.test_company)
        TextView testCompany;
        @Bind(R.id.gl_vertical60)
        Guideline glVertical60;
        @Bind(R.id.test_name)
        TextView testName;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
