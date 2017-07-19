package com.ucv.trilcemovil.DataAccess;

import android.content.Context;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

/**
 * Created by user on 15/06/2017. 15
 */

public abstract class RequestJSON {

    public final static String URL_GET_ALL_DATOS = "http://kevinandroidkap.pe.hu/ArchivosPHP/Datos_GETALL.ph";//lo escribire asi a ver que sale

    public abstract void SolicitudCompleta(JSONObject j);
    public abstract void solicitudErronea();

    public RequestJSON(){}

    public void solicitudJsonGET(final Context c, String URL){
        JsonObjectRequest solicitud = new JsonObjectRequest(URL,null, new Response.Listener<JSONObject>(){
            @Override
            public void onResponse(JSONObject datos) {
                SolicitudCompleta(datos);
            }
        },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {//mm como? ahhhh eso sale en php, mmmm pero como se si esta mal la URL o sea
                //a ver espere voy a escribir mal la URL aproposito a ver is sale algo
                solicitudErronea();
            }
        });
        VolleyRP.addToQueue(solicitud,VolleyRP.getInstance(c).getRequestQueue(),c,VolleyRP.getInstance(c));
    }

}
