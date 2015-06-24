package com.outlook.gonzasosa.demos.videoclubclient.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.outlook.gonzasosa.demos.videoclubclient.R;

public class FragmentRentas extends Fragment {
    public FragmentRentas() {}

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate (R.layout.rentas_fragment, container, false);
    }

}
