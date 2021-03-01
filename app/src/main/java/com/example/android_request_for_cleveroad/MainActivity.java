package com.example.android_request_for_cleveroad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.android_request_for_cleveroad.Recycler.UserAdapter;
import com.example.android_request_for_cleveroad.objects.RootResult;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RootResult result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.list);
        // создаем адаптер
        UserAdapter adapter = new UserAdapter(this);
        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter);



        UserService apiInterface= ApiClient.getClient().create(UserService.class);


        /**
         GET List Resources
         **/
        Call<RootResult> call = apiInterface.doGetListResources();
        call.enqueue(new Callback<RootResult>() {
            @Override
            public void onResponse(Call<RootResult> call, Response<RootResult> response) {


                Log.d("TAG",response.code()+"");
                Log.d("TAG",response.body().toString()+"");
                RootResult result = response.body();
                adapter.setUsers(result.getUsers());
            }

            @Override
            public void onFailure(Call<RootResult> call, Throwable t) {
                call.cancel();
            }
        });


    }
}