package com.example.jenong.cafeapp.Model;

import java.util.List;

public class RootObject
{
    public boolean STATUS;
    public int STATUS_CODE;
    public MESSAGE MESSAGE;

    public List<Datum> getDATA() {
        return DATA;
    }

    public void setDATA(List<Datum> DATA) {
        this.DATA = DATA;
    }

    public com.example.jenong.cafeapp.Model.MESSAGE getMESSAGE() {
        return MESSAGE;
    }

    public void setMESSAGE(com.example.jenong.cafeapp.Model.MESSAGE MESSAGE) {
        this.MESSAGE = MESSAGE;
    }

    public int getSTATUS_CODE() {
        return STATUS_CODE;
    }

    public void setSTATUS_CODE(int STATUS_CODE) {
        this.STATUS_CODE = STATUS_CODE;
    }

    public boolean isSTATUS() {
        return STATUS;
    }

    public void setSTATUS(boolean STATUS) {
        this.STATUS = STATUS;
    }

    public List<Datum> DATA;
}