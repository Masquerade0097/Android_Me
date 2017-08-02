/*
* Copyright (C) 2017 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*  	http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

// This activity will display a custom Android image composed of three body parts: head, body, and legs
public class AndroidMeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);

        if(savedInstanceState == null) {
            BodyPartFragment headFragment = new BodyPartFragment();
            BodyPartFragment stomachFragment = new BodyPartFragment();
            BodyPartFragment legsFragment = new BodyPartFragment();

            headFragment.setImageIds(AndroidImageAssets.getHeads());
            stomachFragment.setImageIds(AndroidImageAssets.getStomach());
            legsFragment.setImageIds(AndroidImageAssets.getLegs());

            headFragment.setListIndex(0);
            stomachFragment.setListIndex(0);
            legsFragment.setListIndex(0);

//  To make fragment transactions in your activity (such as add, remove, or replace a
// fragment), you must use APIs from FragmentTransaction. You can get an instance of
// FragmentTransaction from your Activity like this:
            FragmentManager fragmentManager = getSupportFragmentManager();
//        The first argument passed to add() is the ViewGroup in which the fragment
// should be placed, specified by resource ID, and the second parameter is the fragment
// to add

            fragmentManager.beginTransaction()
                    .add(R.id.head_container, headFragment)
                    .commit();

            fragmentManager.beginTransaction()
                    .add(R.id.stomach_container, stomachFragment)
                    .commit();

            fragmentManager.beginTransaction()
                    .add(R.id.legs_container, legsFragment)
                    .commit();
        }
    }
}
