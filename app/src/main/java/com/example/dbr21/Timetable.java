package com.example.dbr21;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Timetable {

    //public static int size = 0;
    @PrimaryKey(autoGenerate = true)
    public int id;
    private String name;
    private String lecturer;
    private String cabinet;

    public Timetable(String name, String lecturer, String cabinet){

        //size = MainActivity.timetables.size();
        System.out.println("constTimetable");

        //this.id = size;
        //size++;
        this.name = name;
        this.lecturer = lecturer;
        this.cabinet = cabinet;
        System.out.println(this.name + " " + this.id + " " + this.lecturer);
    }

    public String getName(){
        return name;
    }

    public String getLecturer(){
        return lecturer;
    }

    public String getCabinet() {
        return cabinet;
    }

    public String getId(){ return String.valueOf(id+1); }

/*    public Timetable(String name, String lecturer, String cabinet, int id){
        System.out.println("constTimetable");
        //this.id = id;
        size++;
        this.name = name;
        this.lecturer = lecturer;
        this.cabinet = cabinet;
        System.out.println(this.name + " " + this.id + " " + this.lecturer);
    }*/
}
