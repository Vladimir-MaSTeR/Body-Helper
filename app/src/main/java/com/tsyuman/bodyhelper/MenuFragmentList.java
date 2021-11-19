package com.tsyuman.bodyhelper;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;

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
            Toast.makeText(
                    getActivity(),
                    menuItem.getTitle(),
                    Toast.LENGTH_SHORT)
                    .show();

            return false;
        });

        fontStileMenu(vNavigation);

        return view;
    }

    /**
     * Метод применения applyFontToMenuItem к тексту меню
     *
     * @param navigationView navigationView
     */
    private void fontStileMenu(NavigationView navigationView) {
        Menu menu = navigationView.getMenu();

        for (int i = 0; i < menu.size(); i++) {
            MenuItem menuItem = menu.getItem(i);

            //for applying a font to subMenu ...
            SubMenu subMenu = menuItem.getSubMenu();

            if (subMenu != null && subMenu.size() > 0) {
                for (int j = 0; j < subMenu.size(); j++) {
                    MenuItem subMenuItem = subMenu.getItem(j);
                    applyFontToMenuItem(subMenuItem);
                }
            }

            //the method we have create in activity
            applyFontToMenuItem(menuItem);
        }
    }

    /**
     * Изменение шрифта текста
     *
     * @param menuItem menuItem
     */
    private void applyFontToMenuItem(MenuItem menuItem) {
        if (getActivity() != null) {
            Typeface font = Typeface.createFromAsset(
                    getActivity().getAssets(),
                    getString(R.string.menu_stile));

            SpannableString mNewTitle = new SpannableString(menuItem.getTitle());
            mNewTitle.setSpan(
                    new CustomTypeFaceSpan("", font),
                    0,
                    mNewTitle.length(),
                    Spannable.SPAN_INCLUSIVE_INCLUSIVE);

            menuItem.setTitle(mNewTitle);
        }
    }

}
