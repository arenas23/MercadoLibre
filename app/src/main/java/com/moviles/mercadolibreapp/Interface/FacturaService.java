package com.moviles.mercadolibreapp.Interface;

import com.moviles.mercadolibreapp.Model.Factura;
import com.moviles.mercadolibreapp.Model.Register;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface FacturaService {
    @POST("compra/compra.php")
    Call<String> setFactura(@Body Factura compra);
}
