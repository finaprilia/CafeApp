package com.example.jenong.cafeapp.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.jenong.cafeapp.Interface.CafeUtamaInput;
import com.example.jenong.cafeapp.Model.CafeUtamaModel;
import com.example.jenong.cafeapp.Interface.CafeUtamaOutput;
import com.example.jenong.cafeapp.Configure.CafeUtamaConfigure;
import com.example.jenong.cafeapp.Model.Datum;
import com.example.jenong.cafeapp.Model.RootObject;
import com.example.jenong.cafeapp.R;

import java.util.ArrayList;
import java.util.List;

public class CafeUtama extends AppCompatActivity implements CafeUtamaOutput {

    public CafeUtamaInput input;
    private List<Datum> data = new ArrayList();
    private RecyclerView rec;
    private MyAdapter adapter = new MyAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafe_utama);
        CafeUtamaConfigure.getInstance().config(this);

        rec = (RecyclerView) findViewById(R.id.rec);
        rec.setLayoutManager(new LinearLayoutManager(CafeUtama.this));
        rec.setAdapter(adapter);

        input.makeJsonCafe();

        doSomething();
    }

    private void doSomething() {
        input.doSomething("this", "input");
    }

    @Override
    public void displaySomething(CafeUtamaModel response) {
        Log.d("RESULT", "RESULT");
    }

    @Override
    public void displayError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void displayUtama(RootObject datum) {
        adapter.addAll(datum.DATA);
        adapter.notifyDataSetChanged();

    }

}
