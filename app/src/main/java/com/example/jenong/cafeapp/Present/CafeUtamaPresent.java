package com.example.jenong.cafeapp.Present;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.jenong.cafeapp.API.AppController;
import com.example.jenong.cafeapp.API.Const;
import com.example.jenong.cafeapp.Interface.CafeUtamaInput;
import com.example.jenong.cafeapp.Interface.CafeUtamaOutput;
import com.example.jenong.cafeapp.Model.CafeUtamaModel;
import com.example.jenong.cafeapp.Model.Datum;
import com.example.jenong.cafeapp.Model.RootObject;
import com.google.gson.Gson;

import org.json.JSONObject;

/**
 * Created by gits on VIP.
 * Present for process
 */
public class CafeUtamaPresent implements CafeUtamaInput {
    public CafeUtamaOutput output;
    private String tag_json_array="jarray_req";
    private String TAG= CafeUtamaPresent.class.getSimpleName();

    @Override
    public void doSomething(String strA, String strB) {
        CafeUtamaModel response = new CafeUtamaModel();
        response.setVarA(strA);
        response.setVarB(strB);
        output.displaySomething(response);
    }

    @Override
    public void makeJsonCafe() {
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET,
                Const.URL_API_CAFE, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        RootObject rootObject = new Gson().fromJson(response.toString(), RootObject.class);
                        output.displayUtama(rootObject);
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