package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

/**
 * Created by priyanshu on 1/8/17.
 */

public class BodyPartFragment extends Fragment {

    public BodyPartFragment(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //inflate the layout
        View rootView = inflater.inflate(R.layout.fragment_body_part,container,false);

        //imageview in the fragment
        ImageView body_part_image = (ImageView) rootView.findViewById(R.id.body_part_image_view);

        body_part_image.setImageResource(AndroidImageAssets.getHeads().get(0));

        return rootView;
    }
}
