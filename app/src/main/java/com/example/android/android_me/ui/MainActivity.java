package com.example.android.android_me.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import static android.view.View.GONE;

public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener {

    private int headIndex;
    private int stomachIndex;
    private int legsIndex;
    private boolean mTwoPaneLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.android_me_linear_layout) != null){
            mTwoPaneLayout = true;

            Button nextButton = (Button) findViewById(R.id.next_button);
            nextButton.setVisibility(GONE);

            GridView gridV = (GridView) findViewById(R.id.grid_master);
            gridV.setNumColumns(2);

            if(savedInstanceState == null) {
                BodyPartFragment headFragment = new BodyPartFragment();
                BodyPartFragment stomachFragment = new BodyPartFragment();
                BodyPartFragment legsFragment = new BodyPartFragment();

                headFragment.setImageIds(AndroidImageAssets.getHeads());
                stomachFragment.setImageIds(AndroidImageAssets.getStomach());
                legsFragment.setImageIds(AndroidImageAssets.getLegs());

                FragmentManager fragmentManager = getSupportFragmentManager();

                int headIndex = getIntent().getIntExtra("headIndexStr", 0);
                headFragment.setListIndex(headIndex);
                int stomachIndex = getIntent().getIntExtra("stomachIndexStr", 0);
                stomachFragment.setListIndex(stomachIndex);
                int legIndex = getIntent().getIntExtra("legsIndexStr", 0);
                legsFragment.setListIndex(legIndex);

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
        }else
            mTwoPaneLayout = false;

    }

    // Define the behavior for onImageSelected
    public void onImageSelected(int position) {
        // Create a Toast that displays the position that was clicked
//        Toast.makeText(this, "Position clicked = " + position, Toast.LENGTH_SHORT).show();

        int bodyPartNumber = position / 12;
        int ListIndex = position - 12 * bodyPartNumber;

        BodyPartFragment newFragment = new BodyPartFragment();

        if (mTwoPaneLayout) {
            switch (bodyPartNumber) {
                case 0:
                    newFragment.setImageIds(AndroidImageAssets.getHeads());
                    newFragment.setListIndex(ListIndex);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.head_container, newFragment)
                            .commit();
                    break;
                case 1:
                    newFragment.setImageIds(AndroidImageAssets.getStomach());
                    newFragment.setListIndex(ListIndex);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.stomach_container, newFragment)
                            .commit();
                    break;
                case 2:
                    newFragment.setImageIds(AndroidImageAssets.getLegs());
                    newFragment.setListIndex(ListIndex);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.legs_container, newFragment)
                            .commit();
                    break;
                default:
                    break;
            }

        } else {
            switch (bodyPartNumber) {
                case 0:
                    headIndex = ListIndex;
                    break;
                case 1:
                    stomachIndex = ListIndex;
                    break;
                case 2:
                    legsIndex = ListIndex;
                    break;
                default:
                    break;
            }

            Bundle bund = new Bundle();
            bund.putInt("headIndexStr", headIndex);
            bund.putInt("stomachIndexStr", stomachIndex);
            bund.putInt("legsIndexStr", legsIndex);

            final Intent intent = new Intent(this, AndroidMeActivity.class);
            intent.putExtras(bund);

            Button nextButton = (Button) findViewById(R.id.next_button);
            nextButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(intent);
                }
            });
        }
    }
}
