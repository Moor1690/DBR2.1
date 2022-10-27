package com.example.dbr21;

import android.widget.ArrayAdapter;

public class MyContact {
    public int id;
    public String name;
    public String number;

    public MyContact(int id, String name, String number){
        this.id = id;
        this.name = name;
        this.number = number;
    }
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String capital) {
        this.number = capital;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int flagResource) {
        this.id = flagResource;
    }
}
