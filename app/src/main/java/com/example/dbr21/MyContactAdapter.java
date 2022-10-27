package com.example.dbr21;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;


public class MyContactAdapter extends ArrayAdapter<MyContactAdapter> {

    private LayoutInflater inflater;
    private int layout;
    private List<MyContact> contacts;

    public MyContactAdapter(@NonNull Context context, int resource, List<MyContact> contacts) {
        super(context, resource);
        this.contacts = contacts;
        this.layout =resource;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = inflater.inflate(layout,parent);
        MyContact myContact = contacts.get(position);
        view.findViewById(text).setText(myContact.name/*проверка на нул*/);
    }
}
