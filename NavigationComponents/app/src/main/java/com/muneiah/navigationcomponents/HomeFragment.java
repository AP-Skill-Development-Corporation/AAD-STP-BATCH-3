package com.muneiah.navigationcomponents;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_home, container, false);
        Button button_red=v.findViewById(R.id.red_btn);
        Button button_white=v.findViewById(R.id.white_btn);
        Button button_green=v.findViewById(R.id.green_btn);
       button_red.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Navigation.findNavController(v).navigate(R.id.action_homeFragment_to_redFragment);
           }
       });

       button_white.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Navigation.findNavController(v).navigate(R.id.action_homeFragment_to_whiteFragment);
           }
       });


       button_green.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               Navigation.findNavController(v).navigate(R.id.action_homeFragment_to_greenFragment);
           }
       });

        return v;
    }
}
