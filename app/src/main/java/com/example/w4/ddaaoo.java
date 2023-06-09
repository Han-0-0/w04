package com.example.w4;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ddaaoo {
    @Insert
    void insertAll(User... users);

    @Delete
    void delete(User user);

    @Query("SELECT * FROM User")
    List<User> getAll();

//    @Query("DELETE FROM user WHERE selected = 0")



//    @Delete
//    void deleteAll(User... users);

}
