package com.outlook.gonzasosa.demos.videoclubclient.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.outlook.gonzasosa.demos.videoclubclient.Models.Titulo;
import com.outlook.gonzasosa.demos.videoclubclient.R;
import com.outlook.gonzasosa.demos.videoclubclient.REST.VideoclubClient;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class FragmentTitulos extends Fragment {
    public FragmentTitulos() {}

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate (R.layout.titulos_fragment, container, false);
    }

    @Override
    public void onActivityCreated (Bundle savedInstanceState) {
        super.onActivityCreated (savedInstanceState);

        final ListView listTitulos = (ListView) getActivity().findViewById (R.id.listTitulos);

        VideoclubClient.get().getTitulos (new Callback<List<Titulo>> () {
            @Override
            public void success (List<Titulo> titulos, Response response) {
                if (titulos != null) {
                    listTitulos.setAdapter (
                            new TitulosAdapter (getActivity().getBaseContext(), (ArrayList<Titulo>) titulos));
                }
            }

            @Override
            public void failure (RetrofitError error) {
                Toast.makeText(getActivity(), error.getMessage (), Toast.LENGTH_LONG).show ();
            }
        });
    }

    class TitulosAdapter extends ArrayAdapter<Titulo> {
        public TitulosAdapter (Context context, ArrayList<Titulo> titulos) {
            super (context, 0, titulos);
        }

        @Override
        public View getView (int position, View convertView, ViewGroup parent) {
            Titulo titulo = getItem (position);
            ViewHolder viewHolder;

            if (convertView == null) {
                viewHolder = new ViewHolder ();
                LayoutInflater inflater = LayoutInflater.from (getActivity().getBaseContext ());
                convertView = inflater.inflate (R.layout.item_titulo, parent, false);

                viewHolder.Titulo = titulo;
                viewHolder.TextView = (TextView) convertView.findViewById (R.id.tvItemTitulo);

                convertView.setTag (viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag ();
            }

            viewHolder.Titulo = titulo;
            viewHolder.TextView.setText (titulo.getTitulo ());

            return convertView;
        }
    }

    class ViewHolder {
        public Titulo Titulo;
        public TextView TextView;
    }
}
