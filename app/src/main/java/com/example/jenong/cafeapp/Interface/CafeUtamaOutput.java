package com.example.jenong.cafeapp.Interface;

import com.example.jenong.cafeapp.Model.CafeUtamaModel;
import com.example.jenong.cafeapp.Model.RootObject;

/**
 * Created by gits on VIP
 * Output For Response Processs
 */
public interface CafeUtamaOutput {
    void displaySomething(CafeUtamaModel response);
    void displayError(String error);
    void displayUtama(RootObject datum);
}