package com.tsyuman.bodyhelper;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;

import butterknife.BindView;

public class MenuFragmentList extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        NavigationView vNavigation = view.findViewById(R.id.vNavigation);
        vNavigation.setNavigationItemSelectedListener(menuItem -> {
                    Toast.makeText(getActivity(),
                            menuItem.getTitle(),
                            Toast.LENGTH_SHORT).show();

                    return false;
                });

        return view;
    }

}
