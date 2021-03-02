package com.example.android_request_for_cleveroad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.android_request_for_cleveroad.DataBase.DataBaseManager;
import com.example.android_request_for_cleveroad.Recycler.UserAdapter;
import com.example.android_request_for_cleveroad.api.QueryManager;
import com.example.android_request_for_cleveroad.intefaces.CallBackReadUsers;
import com.example.android_request_for_cleveroad.objects.SimpleUser;
import com.example.android_request_for_cleveroad.utils.Utils;

import java.util.List;

public class MainActivity extends AppCompatActivity implements CallBackReadUsers {
    private UserAdapter adapter;
    private DataBaseManager dataBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.list);
        // создаем адаптер
        adapter = new UserAdapter(this);
        dataBase = new DataBaseManager(this);
        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter);

        if (!Utils.isNetworkAvailable(this)){
            //если нет инета вытаскиваем юзеров из БД и подгружаем в RV
            Toast toast = Toast.makeText(this, "is internet connection error" ,Toast.LENGTH_LONG);
            toast.show();
           dataBase.readUsers(this);
        }else {
            new QueryManager().getUsersData(this);
        }
    }

    @Override
    public void setUsers(List<SimpleUser> list) {
        if (Utils.isNetworkAvailable(this))
            dataBase.save(list);
        adapter.setUsers(list);
    }
}