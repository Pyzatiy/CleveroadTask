package com.example.android_request_for_cleveroad.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.android_request_for_cleveroad.objects.SimpleUser;
import com.example.android_request_for_cleveroad.objects.RootResult;

import java.util.ArrayList;
import java.util.List;


public class Utils {

    public static List<SimpleUser> getSimpleUsers(RootResult rootResult){
        List<SimpleUser> simpleUsers = new ArrayList<>();
        for (int i = 0; i < rootResult.getUsers().size() ; i++) {
            SimpleUser simpleUser = new SimpleUser();
            simpleUser.setTitle(rootResult.getUsers().get(i).getName().getTitle());
            simpleUser.setFirst(rootResult.getUsers().get(i).getName().getFirst());
            simpleUser.setLast(rootResult.getUsers().get(i).getName().getLast());
            simpleUser.setPicture(rootResult.getUsers().get(i).getPicture().getThumbnail());

            simpleUsers.add(simpleUser);
        }
        return simpleUsers;
    }
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

}
