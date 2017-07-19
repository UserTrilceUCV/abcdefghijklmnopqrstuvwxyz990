package com.ucv.trilcemovil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ucv.trilcemovil.DataAccess.RequestJSON;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {//por que me asle error? xd

    private EditText edtUsuario,edtContrasenia;//contraseña o contrasenia? jajajaja bueno
    private Button btnLogin;//login estaria bien? aca no hay xd

    private Categoria categoria = Categoria.A;//Creo que ya se como se usan

    private Categoria categoriaActual;

    public void setCategoriaActual(Categoria categoriaActual) {
        this.categoriaActual = categoriaActual;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUsuario = (EditText) findViewById(R.id.edtUsuario);
        edtContrasenia = (EditText) findViewById(R.id.edtContrasenia);
        btnLogin = (Button) findViewById(R.id.btn);

        //seteo en la categoria que estoy actualmente
        setCategoriaActual(Categoria.A);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //esta bien asi?
                //mmmmmm no se como hacerlo jaja es lo maximo que pude hacerlo para reducirlo
                //a ver rapidito como haria para el error en donde lo hago o como xd sis
                RequestJSON r = new RequestJSON() {
                    @Override
                    public void SolicitudCompleta(JSONObject j) {//completa verdad?
                        //recibo el objeto
                    }

                    @Override
                    public void solicitudErronea() {//si bueno ya voy a avanzar con el diseño y ya cuando vuelva me dice si esta bien o para arreglarlo
                        //tratare de no escribir mucho codigo duro xd herencia? carpetas?
                        //eso lo he visto pero nunca lo entendi xd
                        //para que sirve? con un if?
                        //lo hago ahora? mmmm ya le entiendo creo
                        //Comparo si estoy en la categoria a
                        if(categoriaActual==categoria){//asi masomenos creo xd, ya pues
                            //sis ahorita lo subo a git por cualquier error que haga despues xd
                        }
                        Mensaje.mostrarMensaje(MainActivity.this,"Ocurrio un error al logearse");//asi? xd ssiis
                        //ah pero esta bien que sea static? hay otra forma pero no se cual es mejor xd, ah ya vale
                        //ahh yayaya vale
                    }
                };
                r.solicitudJsonGET(MainActivity.this,RequestJSON.URL_GET_ALL_DATOS);
            }
        });

    }
}
