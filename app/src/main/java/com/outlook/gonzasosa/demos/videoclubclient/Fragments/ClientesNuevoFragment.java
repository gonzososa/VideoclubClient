package com.outlook.gonzasosa.demos.videoclubclient.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.outlook.gonzasosa.demos.videoclubclient.Models.Cliente;
import com.outlook.gonzasosa.demos.videoclubclient.R;
import com.outlook.gonzasosa.demos.videoclubclient.REST.VideoclubClient;

import java.util.Calendar;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ClientesNuevoFragment extends Fragment {
    @Bind (R.id.edtNombre)    EditText edtNombre;
    @Bind (R.id.edtDireccion) EditText edtDireccion;
    @Bind (R.id.edtTelefono)  EditText edtTelefono;
    @Bind (R.id.dtVigencia)   DatePicker dtVigencia;
    @Bind (R.id.btnSave)      Button btnSave;

    public ClientesNuevoFragment() {}

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate (R.layout.clientes_nuevo_fragment, container, false);
        ButterKnife.bind (this, view);

        return view;
    }

    @Override
    public void onActivityCreated (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        final EditText edtNombre      = (EditText) getActivity().findViewById (R.id.edtNombre);
//        final EditText edtDireccion   = (EditText) getActivity().findViewById (R.id.edtDireccion);
//        final EditText edtTelefono    = (EditText) getActivity().findViewById (R.id.edtTelefono);
//        final DatePicker dtVigencia   = (DatePicker) getActivity().findViewById (R.id.dtVigencia);

//        Button btnSave = (Button) getActivity().findViewById (R.id.btnSave);
        if (edtNombre == null || edtDireccion == null || edtTelefono == null || dtVigencia == null) {
            Toast.makeText (getActivity(), "Campos nulos", Toast.LENGTH_LONG).show ();
        }

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cliente cliente = new Cliente ();
                cliente.setNombre       (edtNombre.getText().toString());
                cliente.setDireccion    (edtDireccion.getText().toString());
                cliente.setTelefono     (edtTelefono.getText().toString());
                cliente.setVigencia     (getDateFromPicker (dtVigencia));

                VideoclubClient.get().saveCiente (cliente, new Callback<Cliente> () {
                    @Override
                    public void success(Cliente cliente, Response response) {
                        Toast.makeText (getActivity(), "Datos del cliente almacenados", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Toast.makeText (getActivity(), error.getMessage (), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }

    private Date getDateFromPicker (DatePicker dp) {
        int d = dp.getDayOfMonth ();
        int m = dp.getMonth();
        int y = dp.getYear();

        Calendar calendar = Calendar.getInstance ();
        calendar.set(y, m, d);

        return calendar.getTime ();
    }

}
