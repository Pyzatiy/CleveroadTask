package com.example.android_request_for_cleveroad;

import com.example.android_request_for_cleveroad.objects.RootResult;
import retrofit2.Call;
import retrofit2.http.GET;

public interface UserService {
    @GET("?results=5000")
    Call<RootResult> doGetListResources();


}
