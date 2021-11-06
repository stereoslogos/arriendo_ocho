package com.example.arriendo_ocho;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioButton jrbCasa,jrbApt,jrbFinca;
    TextView jtvPrecio,jtvParqueadero,jtvTotal;
    EditText jetHabitaciones;
    CheckBox jcbParqueadero;
    Button jbtCalc,jbtLimp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        jrbCasa = findViewById(R.id.rbCasa);
        jrbApt = findViewById(R.id.rbApt);
        jrbFinca = findViewById(R.id.rbFinca);
        jtvPrecio = findViewById(R.id.tvPrecio);
        jtvParqueadero = findViewById(R.id.tvParqueadero);
        jtvTotal = findViewById(R.id.tvTotal);
        jetHabitaciones = findViewById(R.id.etHabitaciones);
        jcbParqueadero = findViewById(R.id.cbParqueadero);
        jbtCalc = findViewById(R.id.btCalc);
        jbtLimp = findViewById(R.id.btLimp);
    }

    public void calc_total(){
        String qty;
        qty = jetHabitaciones.getText().toString();
        if(qty.isEmpty()){
            Toast.makeText(this, "Cantidad de habitaciones requerida", Toast.LENGTH_SHORT).show();
            jetHabitaciones.requestFocus();
        }else{
            int vlr_place,vlr_parq,vlr_tot,vlr_qty;

            vlr_qty = Integer.parseInt(qty);

            if(vlr_qty < 3){
                vlr_qty = 100000;
            }else if(vlr_qty == 3 || vlr_qty == 4){
                vlr_qty = 200000;
            }else{
                vlr_qty = 300000;
            }

            vlr_place = Integer.parseInt(jtvPrecio.getText().toString());
            vlr_parq = Integer.parseInt(jtvParqueadero.getText().toString());
            vlr_tot = (vlr_place + vlr_parq) + vlr_qty;
            jtvTotal.setText(String.valueOf(vlr_tot));
        }
    }

    public void calc(View view){
        calc_total();
    }

    public void Casa(View view){
        jtvPrecio.setText("400000");
        calc_total();
    }

    public void Apt(View view){
        jtvPrecio.setText("300000");
        calc_total();
    }

    public void Finca(View view){
        jtvPrecio.setText("600000");
        calc_total();
    }

    public void Parqueadero(View view){
        if(jcbParqueadero.isChecked()){
            jtvParqueadero.setText("100000");
        }else{
            jtvParqueadero.setText("0");
        }
        calc_total();
    }

    public void Limpiar(View view){
        jetHabitaciones.setText("");
        jtvParqueadero.setText("0");
        jtvPrecio.setText("400000");
        jtvTotal.setText("0");
        jrbCasa.setChecked(true);
        jcbParqueadero.setChecked(false);
        jetHabitaciones.requestFocus();
    }
}