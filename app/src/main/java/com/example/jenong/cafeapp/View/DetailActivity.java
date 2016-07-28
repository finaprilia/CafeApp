
package com.example.jenong.cafeapp.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.jenong.cafeapp.Configure.DetailActivityConfigure;
import com.example.jenong.cafeapp.Interface.DetailActivityInput;
import com.example.jenong.cafeapp.Interface.DetailActivityOutput;
import com.example.jenong.cafeapp.Model.DATA;
import com.example.jenong.cafeapp.Model.Datum;
import com.example.jenong.cafeapp.Model.DetailActivityModel;
import com.example.jenong.cafeapp.Model.Fasilita;
import com.example.jenong.cafeapp.Model.RootObjectDetail;
import com.example.jenong.cafeapp.R;
import com.squareup.picasso.Picasso;

import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity implements DetailActivityOutput {

    public DetailActivityInput input;
    public final static String KEY_MEMBER = "keymember";
    private String TAG=DetailActivity.class.getSimpleName();
    private Datum object;
    private DATA obj;
    ImageView gambar;
    TextView nama;
    TextView alamat;
    TextView des;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        DetailActivityConfigure.getInstance().config(this);

        if(getIntent().hasExtra(KEY_MEMBER)) {
            object = (Datum) getIntent().getParcelableExtra(KEY_MEMBER);
            Log.e(TAG, "AAAAAAAAAAAAAAAA : "+object.getId());
            Log.e(TAG, "AAAAAAAAAAAAAAAA : "+object.getNama());
            Log.e(TAG, "AAAAAAAAAAAAAAAA : "+object.getAlamat());
            Log.e(TAG, "AAAAAAAAAAAAAAAA : "+object.getUrl_foto());
        }else {
            Toast.makeText(getApplicationContext(), "Maaf data tidak ditemukan", Toast.LENGTH_SHORT).show();
        }

        gambar = (ImageView) findViewById(R.id.imageBelakang);
        nama = (TextView) findViewById(R.id.cafeNama);
        alamat = (TextView) findViewById(R.id.cafeAlamat);
        des = (TextView) findViewById(R.id.tvDeskripsi);

        Picasso.with(getApplicationContext()).load(object.getUrl_foto()).into(gambar);
        nama.setText(object.getNama());
        alamat.setText(object.getAlamat());

        input.makeJson(object.getId());



        doSomething();
    }

    private void doSomething() {
        input.doSomething("this", "input");
    }

    @Override
    public void displaySomething(DetailActivityModel response) {
        Log.d("RESULT", "RESULT");
    }

    @Override
    public void displayError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void displayDetail(DATA deskripsi) {
        des.setText(deskripsi.getDeskripsi());
        LinearLayout lin = (LinearLayout) findViewById(R.id.linearFasilitas);
        for(Fasilita r : deskripsi.getFasilitas()){
            View v = getLayoutInflater().inflate(R.layout.item_fasilitas, lin, false);
            TextView txt = (TextView) findViewById(R.id.tvFasilitas);
            txt.setText(r.getNama());
            lin.addView(v);
        }
    }

}
