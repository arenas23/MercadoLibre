package com.moviles.mercadolibreapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

import com.moviles.mercadolibreapp.Model.Factura;
import com.moviles.mercadolibreapp.databinding.ActivityBuyBinding;
import com.moviles.mercadolibreapp.databinding.ActivityOffertsBinding;

public class BuyActivity extends AppCompatActivity {

    ActivityBuyBinding activityBuyBinding;
    TextView salir;
    Factura factura;
    FacturaAdapter adapter ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityBuyBinding = ActivityBuyBinding.inflate(getLayoutInflater());
        View view = activityBuyBinding.getRoot();
        setContentView(view);
        //startTimer();
        Bundle facturaEnviada = getIntent().getExtras();

        factura = null;

        if(facturaEnviada != null){
            factura = (Factura) facturaEnviada.getSerializable("factura");
            mostrarFactura();
        }
    }

    public final void startTimer() {
        (new CountDownTimer(3000L, 1000L) {
            public void onTick(long millisUntilFinished) { }
            public void onFinish() {
                    Intent intentHome = new Intent(getApplicationContext(),HomeActivity.class);
                    startActivity(intentHome);
            }
        }).start();
    }

    public void mostrarFactura(){
        adapter = new FacturaAdapter(BuyActivity.this,factura.getProductos());
        activityBuyBinding.RecyclerFacturas.setHasFixedSize(true);
        activityBuyBinding.RecyclerFacturas.setLayoutManager(new LinearLayoutManager(BuyActivity.this,LinearLayoutManager.VERTICAL,false));
        activityBuyBinding.RecyclerFacturas.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        activityBuyBinding.txtTotal.setText(factura.getTotal().toString());
        activityBuyBinding.txtfecha.setText(factura.getFecha().toString());
    }
}