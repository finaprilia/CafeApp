package com.example.jenong.cafeapp.Present;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.jenong.cafeapp.API.AppController;
import com.example.jenong.cafeapp.API.Const;
import com.example.jenong.cafeapp.Interface.DetailActivityInput;
import com.example.jenong.cafeapp.Interface.DetailActivityOutput;
import com.example.jenong.cafeapp.Model.DATA;
import com.example.jenong.cafeapp.Model.DetailActivityModel;
import com.example.jenong.cafeapp.Model.RootObject;
import com.example.jenong.cafeapp.Model.RootObjectDetail;
import com.example.jenong.cafeapp.View.DetailActivity;
import com.google.gson.Gson;

import org.json.JSONObject;

/**
 * Created by gits on VIP.
 * Present for process
 */
public class DetailActivityPresent implements DetailActivityInput {
    public DetailActivityOutput output;
    private String tag_json_array="jarray_req";
    private String TAG= DetailActivity.class.getSimpleName();

    @Override
    public void doSomething(String strA, String strB) {
        DetailActivityModel response = new DetailActivityModel();
        response.setVarA(strA);
        response.setVarB(strB);
        output.displaySomething(response);
    }

    @Override
    public void makeJson(String aidi) {
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET,
                "http://dev.gits.co.id/apicafe/public/list"+aidi, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        RootObjectDetail rootObject = new Gson().fromJson(response.toString(), RootObjectDetail.class);
                        output.displayDetail(rootObject.DATA);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error : " + error.getMessage());
                output.displayError("Maaf Error");
            }
        });

        AppController.getInstance().addToRequestQueue(req, tag_json_array);
    }

}