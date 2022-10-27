package MView;

import android.app.Application;
import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import com.example.dbr21.DataClass.AppDatabase;
import com.example.dbr21.R;
import com.example.dbr21.TimetableAdapter;

import java.util.ArrayList;

public class MViewModel extends AndroidViewModel {

    public TimetableAdapter adapter;
    public AppDatabase db;

    public MViewModel(@NonNull Application application) {
        super(application);
    }

    //  public MViewModel(TimetableAdapter adapter, AppDatabase db){
    //    super();
      //  this.adapter = adapter;
     //   this.db = db;
  //  }

    public ArrayList<String> loadContacts(){
        ContentResolver contentResolver = getApplication().getContentResolver();
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
        return contacts;

    }



//    public void Add(Adapter adapter, AppDatabase db){
        /*public class CreateAsyncTask extends AsyncTask<AppDatabase, String, Void> {

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                new MView.STAsyncTask().execute(db);
                adapter.notifyDataSetChanged();
            }

            @Override
            protected Void doInBackground(AppDatabase... appDatabases) {

                System.out.println("CreateAsyncTask");

                //                EditText editText = findViewById(R.id.editText);
                EditText editText = editText.findViewById(R.id.editText);
                //EditText editText2 = findViewById(R.id.editText2);
                TimetableClassDao timetableClassDao = appDatabases[0].timetableClassDao();
                Timetable timetable = new Timetable(editText.getText().toString(), " ", " ");
                timetableClassDao.insert(timetable);
                timetables.add(timetable);

                return null;
            }
        }
//    }

//    public void Del(TimetableAdapter adapter){
        class DeleteAsyncTask extends AsyncTask<AppDatabase, String, Void> {

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
//    }

//    public void St(TimetableAdapter adapter){
        class STAsyncTask extends AsyncTask<AppDatabase, String, Void> {

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
//    }
}