package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;

import java.util.List;

/**
 * Created by priyanshu on 1/8/17.
 */

public class BodyPartFragment extends Fragment {

    private static final String TAG = "BodyPartActivity";
    private List<Integer> mImageIds;
    private int mListIndex;


    public BodyPartFragment(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //inflate the layout
        View rootView = inflater.inflate(R.layout.fragment_body_part,container,false);

        //imageview in the fragment
        ImageView body_part_image = (ImageView) rootView.findViewById(R.id.body_part_image_view);

        if(mImageIds != null){
            body_part_image.setImageResource(mImageIds.get(mListIndex));
        }else{
            Log.v(TAG,"This fragment has null list of list of image id's");
        }

        return rootView;
    }

    public void setImageIds(List<Integer> imageIds){
        mImageIds = imageIds;
    }

    public void setListIndex(int index){
        mListIndex = index;
    }
}
