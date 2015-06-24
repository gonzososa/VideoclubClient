package com.outlook.gonzasosa.demos.videoclubclient.Interfaces;

import com.outlook.gonzasosa.demos.videoclubclient.Models.Cliente;
import com.outlook.gonzasosa.demos.videoclubclient.Models.Renta;
import com.outlook.gonzasosa.demos.videoclubclient.Models.Titulo;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;

public interface VideoClubService {
    @GET("/clientes")
    void getClientes (Callback<List<Cliente>> cb);

    @GET ("/clientes/{id}")
    void getCliente (@Path ("id") int id, Callback<Cliente> cb);

    @POST ("/clientes")
    void saveCiente (@Body Cliente cliente, Callback<Cliente> cb);

    @PUT ("/clientes/{id}")
    void updateCliente (@Path ("id") int id, @Body Cliente cliente, Callback cb);

    @DELETE ("/clientes/{id}")
    void deleteCliente (@Path ("id") int id, Callback cb);

    @GET ("/titulos")
    void getTitulos (Callback<List<Titulo>> cb);

    @GET ("/titulos/{id}")
    void getTitulo (@Path ("id") int id, Callback<Cliente> cb);

    @POST ("/titulos")
    void saveTitulo (@Body Cliente cliente, Callback<Cliente> cb);

    @PUT ("/titulos/{id}")
    void updateTitulo (@Path ("id") int id, @Body Cliente cliente, Callback cb);

    @DELETE ("/titulos/{id}")
    void deleteTitulo (@Path ("id") int id, Callback cb);

    @GET ("/rentas")
    List<Cliente> getRentas (Callback cb);

    @GET ("/rentas/{id}")
    void getRenta (@Path ("id")  int id, Callback<Cliente> cb);

    @POST ("/rentas")
    void saveRenta (@Body Renta renta, Callback cb);

    @PUT ("/rentas/{id}")
    void updateRenta (@Path ("id") int id, @Body Cliente cliente, Callback cb);

    @DELETE ("/clientes/{id}")
    void deleteRenta (@Path("id") int id, Callback cb);
}