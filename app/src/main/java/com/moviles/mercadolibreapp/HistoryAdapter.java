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
import com.moviles.mercadolibreapp.databinding.ActivityCartBinding;
import com.moviles.mercadolibreapp.databinding.ActivityHistoryBinding;
import com.moviles.mercadolibreapp.databinding.ItemList2Binding;
import com.moviles.mercadolibreapp.databinding.ItemListBinding;
import com.moviles.mercadolibreapp.databinding.ProductscardsBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.CarViewHolder> {
    private Context context;
    ItemList2Binding itemList2Binding;
    ActivityHistoryBinding activityHistoryBinding;
    private ArrayList<Car> lista;

    int identificacion;

    public HistoryAdapter(Context context, ArrayList<Car> lista) {
        this.context = context;
        this.lista = lista;
    }

    public void readPreferences(){
        SharedPreferences sharedPref = context.getSharedPreferences(context.getString(R.string.SharedPreference), Context.MODE_PRIVATE);
        identificacion = sharedPref.getInt(context.getString(R.string.Identificacion), 0);
    }

    @NonNull
    @Override
    public HistoryAdapter.CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        itemList2Binding = ItemList2Binding.inflate(LayoutInflater.from(context));
        activityHistoryBinding = ActivityHistoryBinding.inflate(LayoutInflater.from(context));
        readPreferences();
        return new HistoryAdapter.CarViewHolder(itemList2Binding);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryAdapter.CarViewHolder holder, int position) {
        Car car = lista.get(position);
        holder.itemList2Binding.nombreCar.setText(car.getNombre_producto());
        //holder.itemList2Binding.desCar.setText(String.valueOf(car.getCantidad()));
        holder.itemList2Binding.valueCar.setText(String.valueOf(car.getPrecio_producto()));
        Glide.with(context).load(car.getUrl_producto()).into(holder.itemList2Binding.imgCar);

    }



    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class CarViewHolder extends RecyclerView.ViewHolder {
        ItemList2Binding itemList2Binding;

        public CarViewHolder(@NonNull  ItemList2Binding itemList2Binding) {
            super(itemList2Binding.getRoot());
            this.itemList2Binding = itemList2Binding;


        }
    }
}
