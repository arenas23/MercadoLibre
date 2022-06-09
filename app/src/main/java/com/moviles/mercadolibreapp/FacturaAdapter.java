package com.moviles.mercadolibreapp;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.moviles.mercadolibreapp.Interface.CartService;
import com.moviles.mercadolibreapp.Model.Car;
import com.moviles.mercadolibreapp.databinding.ActivityBuyBinding;
import com.moviles.mercadolibreapp.databinding.ActivityCartBinding;
import com.moviles.mercadolibreapp.databinding.ActivityHistoryBinding;
import com.moviles.mercadolibreapp.databinding.ItemFacturaBinding;
import com.moviles.mercadolibreapp.databinding.ItemList2Binding;
import com.moviles.mercadolibreapp.databinding.ItemListBinding;
import com.moviles.mercadolibreapp.databinding.ProductscardsBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FacturaAdapter extends RecyclerView.Adapter<FacturaAdapter.CarViewHolder> {
    private Context context;
    ItemFacturaBinding itemFacturaBinding;
    ActivityBuyBinding activityBuyBinding;
    private ArrayList<Car> lista;


    public FacturaAdapter(Context context, ArrayList<Car> lista) {
        this.context = context;
        this.lista = lista;
    }

    @NonNull
    @Override
    public FacturaAdapter.CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        itemFacturaBinding = ItemFacturaBinding.inflate(LayoutInflater.from(context));
        activityBuyBinding = ActivityBuyBinding.inflate(LayoutInflater.from(context));
        return new FacturaAdapter.CarViewHolder(itemFacturaBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull FacturaAdapter.CarViewHolder holder, int position) {
        Car car = lista.get(position);
        holder.itemFacturaBinding.txtNombre.setText(car.getNombre_producto());
        //holder.itemList2Binding.desCar.setText(String.valueOf(car.getCantidad()));
        holder.itemFacturaBinding.txtValor.setText(String.valueOf(car.getPrecio_producto()));


    }



    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class CarViewHolder extends RecyclerView.ViewHolder {
        ItemFacturaBinding itemFacturaBinding;

        public CarViewHolder(@NonNull  ItemFacturaBinding itemFacturaBinding) {
            super(itemFacturaBinding.getRoot());
            this.itemFacturaBinding= itemFacturaBinding;


        }
    }
}