package com.example.android.android_me.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.android.android_me.R;

public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener {

    private int headIndex;
    private int stomachIndex;
    private int legsIndex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Define the behavior for onImageSelected
    public void onImageSelected(int position) {
        // Create a Toast that displays the position that was clicked
//        Toast.makeText(this, "Position clicked = " + position, Toast.LENGTH_SHORT).show();

        int bodyPartNumber = position/12;
        int ListIndex = position - 12*bodyPartNumber;

        switch(bodyPartNumber){
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
        bund.putInt("headIndexStr",headIndex);
        bund.putInt("stomachIndexStr",stomachIndex);
        bund.putInt("legsIndexStr",legsIndex);

        final Intent intent = new Intent(this,AndroidMeActivity.class);
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
