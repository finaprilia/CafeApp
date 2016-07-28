package com.example.jenong.cafeapp.Configure;

import com.example.jenong.cafeapp.View.CafeUtama;
import com.example.jenong.cafeapp.Present.CafeUtamaPresent;

/**
 * Created by gits on Configurator
 */
public class CafeUtamaConfigure {
    private static CafeUtamaConfigure ourInstance = new CafeUtamaConfigure();

    private CafeUtamaConfigure() {
    }

    public static CafeUtamaConfigure getInstance() {
        return ourInstance;
    }

    public void config(CafeUtama activity) {
        CafeUtamaPresent present = new CafeUtamaPresent();
        present.output = activity;
        activity.input = present;
    }
}
