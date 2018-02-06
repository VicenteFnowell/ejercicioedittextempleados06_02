package com.example.ejercicioedittextempleados06_02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {




    Spinner spDias,spMeses,spAnos;
    EditText etNombre, etTelefono,etSueldo,etPrima,etTotal;
    Button btnIva;
    int prima;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Identificar vistas
        spDias=(Spinner)findViewById(R.id.spdias);
        spMeses=(Spinner)findViewById(R.id.spmeses);
        spAnos=(Spinner)findViewById(R.id.spanos);
        btnIva=(Button)findViewById(R.id.btniva);
        etNombre=(EditText)findViewById(R.id.etnombre);
        etTelefono=(EditText)findViewById(R.id.ettelefono);
        etSueldo=(EditText)findViewById(R.id.etsueldo);
        etPrima=(EditText)findViewById(R.id.etprima);
        etTotal=(EditText)findViewById(R.id.ettotal);

        prima = 0;




        //Rellenar los Spinners
        String[] dias={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26",
                "27","28","29","30","31"};
        ArrayAdapter<String> adaptadordias = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,dias);
        spDias.setAdapter(adaptadordias);

        String[] meses={"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
        ArrayAdapter<String> adaptadormeses = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,meses);
        spMeses.setAdapter(adaptadormeses);

        String[] anos={"2015","2016","2017","2018"};
        ArrayAdapter<String> adaptadoranos = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,anos);
        spAnos.setAdapter(adaptadoranos);






    }//Fin OnCreate



    public void clickiva (View view){
        String cajaSueldo = etSueldo.getText().toString();
        if (cajaSueldo.equals("")){
            Toast.makeText(getApplicationContext(),"Debes rellenar el sueldo", Toast.LENGTH_LONG).show();
        }else {
            double sueldo = Double.parseDouble(cajaSueldo);
            double sueldoNuevo = sueldo - (sueldo* 0.10);
            etSueldo.setText(sueldoNuevo+"");//añadimos comillas vacias (concatenar) para convertir la linea en String, ya que es Int (números)
            btnIva.setEnabled(false);
            etSueldo.setEnabled(false);
            btnIva.setText("Aplicado");
        }
    }

    public void clickmas (View view){
        //prima++; Sumar de 1 en 1
        if(prima<100){
            prima=prima+10;
            etPrima.setText(prima+"");
        }

    }

    public void clickmenos (View view){
        //prima--; Restar de 1 en 1
        if(prima>0){
            prima=prima-10;
            etPrima.setText(prima+"");
        }

    }

    public void clickcalcular (View view){

    }

    public void clickgenerar (View view) {
        //Recoger el valor de la caja de texto NombreCompleto
        String nombreCompleto = etNombre.getText().toString();

        //Comprobar si el nombre está vacío
        if (nombreCompleto.equals("") || nombreCompleto.length() == 0) {
            Toast.makeText(getApplicationContext(), "Debes rellenar tu nombre", Toast.LENGTH_LONG).show();

        } else {
            //Split:devuelve un array de String separados por el valor que le demos
            String[]arrayNombre = nombreCompleto.split(" ");
            //Si el arrayNombre tiene menos de 3 posiciones avisamos al usuario (\N es un salto de línea)
            if (arrayNombre.length<3){
                Toast.makeText(getApplicationContext(), "El formato del nombre no es correcto.\n" +
                        "Formato: Nombre Apellido1 Apellido2", Toast.LENGTH_LONG).show();


            }else{
                //Validación Apellidos
                int tamArray = arrayNombre.length;
                String apellido2 = arrayNombre[tamArray-1];
                String apellido1 = arrayNombre[tamArray-2];

                //Validación Nombres
                int tamRestante = tamArray-2;
                String nombre = "";
                for (int i=0; i<tamRestante; i++){
                    nombre+=arrayNombre[i]+" ";
                }
                Toast.makeText(getApplicationContext(), "Nombre: "+nombre+" Apellido1: "+apellido1+" Apellido 2: "+apellido2, Toast.LENGTH_LONG).show();


            }
        }


        //Comprobar teléfono

        String cajaTelefono=etTelefono.getText().toString();

        if(cajaTelefono.equals("")){
            Toast.makeText(getApplicationContext(),"Debes rellenar el teléfono", Toast.LENGTH_LONG).show();

        }else{
            //Convertir el valor String a int
            int telefono = Integer.parseInt(cajaTelefono);

            if (telefono<600000000||telefono>999999999 ){
                Toast.makeText(getApplicationContext(),"Formato incorrecto. Debe comenzar por 6,7,8 o 9",Toast.LENGTH_LONG).show();

            }else{
                Toast.makeText(getApplicationContext(),"Teléfono correcto "+telefono,Toast.LENGTH_LONG).show();
            }
        }


    }





}//Fin MainActivity
