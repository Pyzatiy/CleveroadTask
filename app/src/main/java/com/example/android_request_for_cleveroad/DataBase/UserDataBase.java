package com.example.android_request_for_cleveroad.DataBase;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.android_request_for_cleveroad.objects.SimpleUser;

@Database(entities = {SimpleUser.class}, version = 1)
public abstract class UserDataBase extends RoomDatabase {
    public abstract UserDao userDao();
}
