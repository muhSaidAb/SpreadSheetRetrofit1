package com.kangzayd.spreadsheetretrofit.model;

import com.google.gson.annotations.SerializedName;
import com.kangzayd.spreadsheetretrofit.model.UserItem;

import java.util.List;

public class Response {

    @SerializedName("user")
    public List<UserItem> user;
}