package com.example.jenong.cafeapp.Interface;

import com.example.jenong.cafeapp.Model.DATA;
import com.example.jenong.cafeapp.Model.DetailActivityModel;
import com.example.jenong.cafeapp.Model.RootObjectDetail;

/**
 * Created by gits on VIP
 * Output For Response Processs
 */
public interface DetailActivityOutput {
    void displaySomething(DetailActivityModel response);
    void displayError(String error);
    void displayDetail(DATA deskripsi);
}