package com.example.jenong.cafeapp.Configure;

import com.example.jenong.cafeapp.View.DetailActivity;
import com.example.jenong.cafeapp.Present.DetailActivityPresent;

/**
 * Created by gits on Configurator
 */
public class DetailActivityConfigure {
    private static DetailActivityConfigure ourInstance = new DetailActivityConfigure();

    private DetailActivityConfigure() {
    }

    public static DetailActivityConfigure getInstance() {
        return ourInstance;
    }

    public void config(DetailActivity activity) {
        DetailActivityPresent present = new DetailActivityPresent();
        present.output = activity;
        activity.input = present;
    }
}
