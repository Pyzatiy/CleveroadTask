package com.example.android_request_for_cleveroad.DataBase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.android_request_for_cleveroad.objects.SimpleUser;

import java.util.List;

@Dao
public interface UserDao {
    @Insert
    void insertAll(SimpleUser... simpleUsers);

    // Удаление Person из бд
    @Delete
    void delete(SimpleUser simpleUser);

   // Получение всех Person из бд
    @Query("SELECT * FROM simpleuser")
    List<SimpleUser> getAllPeople();

}
