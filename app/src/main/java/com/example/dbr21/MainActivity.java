package com.example.dbr21;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.Manifest;
import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;



import com.example.dbr21.DataClass.AppDatabase;
import com.example.dbr21.DataClass.TimetableClassDao;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import MView.MViewModel;

public class MainActivity extends AppCompatActivity {
    TimetableAdapter adapter;
    AppDatabase db;
    EditText editText, editText2;
    Button buttonAdd, buttonDelete;
    public static /*Array*/ List<Timetable> timetables = new ArrayList<Timetable>();




    private static final int REQUEST_CODE_READ_CONTACTS=1;
    private static boolean READ_CONTACTS_GRANTED =false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MViewModel mv = new ViewModelProvider(this).get(MViewModel.class);
        //new MView.CreateAsyncTask().execute(db);


        //setInitialData();
        /*editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonDelete = (Button) findViewById(R.id.buttonDelete);


        RecyclerView recyclerView = findViewById(R.id.list);*/
        //////////////////////////////////////////////////
        //////////////////////////////////////////////////
        /*{
            db = Room.databaseBuilder(getApplicationContext(),
                    AppDatabase.class, "timetable").build(); //создание бд
            new STAsyncTask().execute(db);


            adapter = new TimetableAdapter(this, timetables); //создание адаптера


            recyclerView.setAdapter(adapter); //установка адаптера
        }*/
        //////////////////////////////////////////////////
        //////////////////////////////////////////////////

        int hasReadContactPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS);
        if(hasReadContactPermission == PackageManager.PERMISSION_GRANTED){
            READ_CONTACTS_GRANTED = true;
        }
        else{
            // вызываем диалоговое окно для установки разрешений
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, REQUEST_CODE_READ_CONTACTS);
        }
        // если разрешение установлено, загружаем контакты
        if (READ_CONTACTS_GRANTED){
            //mv.loadContacts();

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_list_item_1, mv.loadContacts());
            /*ArrayAdapter<String> adapter = new ContactAdapter<>(this,
                    R.layout.list_item, mv.loadContacts());*/

            //ListView contactList = findViewById(R.id.contactList);
            ListView contactList = findViewById(R.id.contactList);

            contactList.setAdapter(adapter);
        }



/*
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.buttonAdd:
                        System.out.println("buttonAdd:");
                        new CreateAsyncTask().execute(db);
                        break;
                    case R.id.buttonDelete:
                        System.out.println("buttonDelete:");
                        new DeleteAsyncTask().execute(db);

                        break;
                }
            }
        };
*/

        //buttonDelete.setOnClickListener(onClickListener);
        //buttonAdd.setOnClickListener(onClickListener);

    }

    /*private void loadContacts(){
        ContentResolver contentResolver = getContentResolver();
        //contentResolver.
        Cursor cursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        ArrayList<String> contacts = new ArrayList<String>();

        if(cursor!=null){
            while (cursor.moveToNext()) {

                int i = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME_PRIMARY);
                int e = cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER);
                System.out.println("cursor.getColumnCount();\t" + cursor.getColumnCount());
                String n = cursor.getString(e);


                String contact = cursor.getString(i);
                System.out.println("contact\t" + contact);
                System.out.println("number\t" + n);
                System.out.println(cursor.getPosition());
                if (contact==null){
                continue;
                }
                contacts.add(contact);

            }
            cursor.close();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, contacts);

        ListView contactList = findViewById(R.id.contactList);
        contactList.setAdapter(adapter);
    }*/


    /*private class CreateAsyncTask extends AsyncTask<AppDatabase, String, Void> {

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            new STAsyncTask().execute(db);
            adapter.notifyDataSetChanged();
        }

        @Override
        protected Void doInBackground(AppDatabase... appDatabases) {

            System.out.println("CreateAsyncTask");

            EditText editText = findViewById(R.id.editText);
            //EditText editText2 = findViewById(R.id.editText2);
            TimetableClassDao timetableClassDao = appDatabases[0].timetableClassDao();
            Timetable timetable = new Timetable(editText.getText().toString(), " ", " ");
            timetableClassDao.insert(timetable);
            timetables.add(timetable);

            return null;
        }
    }

    private class DeleteAsyncTask extends AsyncTask<AppDatabase, String, Void> {

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            adapter.notifyDataSetChanged();
        }

        @Override
        protected Void doInBackground(AppDatabase... appDatabases) {
            System.out.println("DeleteAsyncTask");


            //int i = Integer.parseInt(editText.getText().toString());
            int i = Integer.parseInt(editText2.getText().toString());

            TimetableClassDao timetableClassDao = appDatabases[0].timetableClassDao();

            Timetable t = timetables.get(i - 1);
            timetables.remove(i - 1);

            timetableClassDao.delete(t);
            return null;
        }
    }

    public static class STAsyncTask extends AsyncTask<AppDatabase, String, Void> {

        @Override
        protected Void doInBackground(AppDatabase... appDatabases) {
//            timetables.clear();
//            timetables.addAll(appDatabases[0].timetableClassDao().getAll());
            adapter.setData(appDatabases[0].timetableClassDao().getAll());
            System.out.println("STAsyncTask");


            //System.out.println("Timetable.size  " + Timetable.size);
            System.out.println("\t" + appDatabases[0].timetableClassDao().getMax());

            //Timetable.size = timetables.size();
            //System.out.println("Timetable.size  " + Timetable.size);

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            adapter.notifyDataSetChanged();
        }

    }*/

    private void setInitialData() {
        //timetables.add(new Timetable("Обоснование и разработка требований к программным системам", "someone", "A-12"));
        //timetables.add(new Timetable("что-то", "кто-то", "где-то"));
        //timetables.add(new Timetable("Встраиваемые системы управления базами данными для мобильных приложений", "someone", "Г-301в"));
    }
}
