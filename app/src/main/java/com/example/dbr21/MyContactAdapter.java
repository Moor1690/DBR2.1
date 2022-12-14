package com.example.dbr21;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

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
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = inflater.inflate(layout,parent);
        MyContact myContact = contacts.get(position);

        TextView nameView = convertView.findViewById(R.id.name);
        TextView idView = convertView.findViewById(R.id.id);
        TextView numberView = convertView.findViewById(R.id.number);

        nameView.setText(myContact.name);
        idView.setText(myContact.id);
        numberView.setText(myContact.number);

        return convertView;

        //view.findViewById(R.id.name).setText(myContact.name/*проверка на нул*/);
        //view.setText
    }



}
