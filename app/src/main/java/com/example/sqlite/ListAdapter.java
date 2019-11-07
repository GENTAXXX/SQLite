package com.example.sqlite;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater layoutInflater;
    List<ContactModel> contact;

    public ListAdapter(Activity activity, List<ContactModel> contact) {
        this.activity = activity;
        this.contact = contact;
    }

    @Override
    public int getCount() {
        return contact.get(i);
    }

    @Override
    public Object getItem(int i) {
        return contact.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 1;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (layoutInflater == null){
            layoutInflater = (layoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (view == null){
            view = layoutInflater.inflate(R.layout.list_row, null);
        }
        TextView textId, textName, textNumber, textAddress;
        textId = view.findViewById(R.id.textId);
        textName = view.findViewById(R.id.textName);
        textNumber = view.findViewById(R.id.textNumber);
        textAddress = view.findViewById(R.id.textAddress);

        ContactModel data = contact.get(i);
        textId.setText(Integer.toString(data.getId()));
        textName.setText(data.getName());
        textNumber.setText(data.getPhone());
        textAddress.setText(data.getAddress());
        return view;
    }
}
