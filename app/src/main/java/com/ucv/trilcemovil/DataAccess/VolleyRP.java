package com.ucv.trilcemovil.DataAccess;

import android.content.Context;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;


/*
    Created by KFelix  on 15/06/2017. 15
  Esta clase sirve para :
    -Conexion con php
 */

public class VolleyRP {//una ultima cosaaaaaa lo ultimo jaja
    
    private static VolleyRP mVolleyRP = null;
    private RequestQueue mRequestQueue;

    private VolleyRP(Context context) {
        mRequestQueue = Volley.newRequestQueue(context);
    }

    public static VolleyRP getInstance(Context context) {
        if (mVolleyRP == null) {
            mVolleyRP = new VolleyRP(context);
        }
        return mVolleyRP;
    }


    public RequestQueue getRequestQueue() {
        return mRequestQueue;
    }

    public static void addToQueue(Request request, RequestQueue fRequestQueue, Context context, VolleyRP volley) {
        if (request != null) {
            request.setTag(context);
            if (fRequestQueue == null)
                fRequestQueue = volley.getRequestQueue();
            request.setRetryPolicy(new DefaultRetryPolicy(
                    60000, 3, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
            ));
            fRequestQueue.add(request);
        }
    }
}
