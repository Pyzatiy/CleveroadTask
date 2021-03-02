package com.example.android_request_for_cleveroad.api;

import com.example.android_request_for_cleveroad.objects.SimpleUser;
import com.example.android_request_for_cleveroad.intefaces.CallBackReadUsers;
import com.example.android_request_for_cleveroad.objects.RootResult;
import com.example.android_request_for_cleveroad.utils.Utils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QueryManager {

    private CallBackReadUsers callBackReadUsers;

    public  void getUsersData(CallBackReadUsers callBackReadUsers){
        this.callBackReadUsers = callBackReadUsers;

        UserService apiInterface= ApiClient.getClient().create(UserService.class);

        Call<RootResult> call = apiInterface.doGetListResources();
        call.enqueue(new Callback<RootResult>() {
            @Override
            public void onResponse(Call<RootResult> call, Response<RootResult> response) {
                RootResult result = response.body();
                if(result!=null) {
                    List<SimpleUser> simpleUsers = Utils.getSimpleUsers(result);
                    callBackReadUsers.setUsers(simpleUsers);
                }
            }

            @Override
            public void onFailure(Call<RootResult> call, Throwable t) {
                call.cancel();
            }
        });
    }
}
