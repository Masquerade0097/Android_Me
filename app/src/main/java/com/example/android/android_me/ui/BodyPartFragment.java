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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by priyanshu on 1/8/17.
 */

public class BodyPartFragment extends Fragment {

    private static final String TAG = "BodyPartActivity";
    private List<Integer> mImageIds;
    private int mListIndex;
    private static String IMAGE_ID_LIST = "imageIds";
    private static String LIST_INDEX = "listIndex";


    public BodyPartFragment(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //SavedInstanceState use - Let we change head item index by clicking to 5 and legs to 4
        //but when we rotate screen these indices gets changed to default ie. 0 and 0. So we
        // want to save the instance of our activity such that when the activity is recreated
        // then it reloades the previous instance that's why we use bundle

        if(savedInstanceState != null){
            mImageIds = savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST);
            mListIndex = savedInstanceState.getInt(LIST_INDEX);
        }


        //inflate the layout
        View rootView = inflater.inflate(R.layout.fragment_body_part,container,false);

        //imageview in the fragment
        final ImageView body_part_image = (ImageView) rootView.findViewById(R.id.body_part_image_view);

        if(mImageIds != null){
            body_part_image.setImageResource(mImageIds.get(mListIndex));
            body_part_image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(mListIndex < mImageIds.size()-1){
                        mListIndex++ ;
                    }else{
                        mListIndex = 0;
                    }
                    body_part_image.setImageResource(mImageIds.get(mListIndex));
                }
            });
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

    @Override
    public void onSaveInstanceState(Bundle currentState) {
        currentState.putIntegerArrayList(IMAGE_ID_LIST, (ArrayList<Integer>) mImageIds);
        currentState.putInt(LIST_INDEX,  mListIndex);

    }
}
