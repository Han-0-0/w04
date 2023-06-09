package com.example.w4;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    public int id;
    //프라이머리키를 포함한 열
    public String Name;

    public boolean selected;

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    //    public ImageView UserImage;
}