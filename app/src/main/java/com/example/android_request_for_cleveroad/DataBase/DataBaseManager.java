package com.example.android_request_for_cleveroad.DataBase;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import androidx.room.Room;

import com.example.android_request_for_cleveroad.objects.SimpleUser;
import com.example.android_request_for_cleveroad.intefaces.CallBackReadUsers;

import java.util.List;


public class DataBaseManager {

    private Context context;
    private List<SimpleUser> simpleUsers;
    private CallBackReadUsers callBackReadUsers;

    public DataBaseManager(Context context) {
        this.context = context;
    }

    public void  save(List<SimpleUser> simpleUsers){
        this.simpleUsers = simpleUsers;
        new InsertUserTask().execute();
    }

    public void readUsers(CallBackReadUsers callBackReadUsers) {
        this.callBackReadUsers = callBackReadUsers;
        new ReadUserTask().execute();
    }

    class InsertUserTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {

            UserDataBase db = Room.databaseBuilder(context,
                    UserDataBase.class, "user-database").build();

            for (SimpleUser user : simpleUsers ) {
                db.userDao().insertAll(user);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Toast.makeText(context, "save users in db", Toast.LENGTH_SHORT).show();
        }
    }

    class ReadUserTask extends AsyncTask<Void, Void, List<SimpleUser>> {

        @Override
        protected List<SimpleUser> doInBackground(Void... voids) {
            UserDataBase db = Room.databaseBuilder(context,
                    UserDataBase.class, "user-database").build();
            return db.userDao().getAllPeople();
        }

        @Override
        protected void onPostExecute(List<SimpleUser> simpleUsers) {
            Toast.makeText(context, "old  data", Toast.LENGTH_SHORT).show();;
            callBackReadUsers.setUsers(simpleUsers);
        }
    }
}


