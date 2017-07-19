package com.ucv.trilcemovil;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by user on 19/07/2017. 19
 */

public class Mensaje {

    public static void mostrarMensaje(Context c,String mensaje){
        Toast.makeText(c,mensaje, Toast.LENGTH_SHORT).show();
    }

}
