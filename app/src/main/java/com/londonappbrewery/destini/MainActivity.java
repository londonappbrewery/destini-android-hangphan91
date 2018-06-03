package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
private TextView mTextStory;
private Button mAnswer1;
private Button mAnswer2;
private int mStoryIndex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState!=null){
            mStoryIndex=savedInstanceState.getInt("IndexStory");
        }else{
           mStoryIndex=1;
        }
        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mTextStory = (TextView) findViewById(R.id.storyTextView);
        mAnswer1= (Button) findViewById(R.id.buttonTop);
        mAnswer2= (Button) findViewById(R.id.buttonBottom);


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mAnswer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Destiny","Answer1 Clicked!!");
                mTextStory.setText(R.string.T3_Story);
                mAnswer1.setText(R.string.T3_Ans1);
                mAnswer2.setText(R.string.T3_Ans2);
                mStoryIndex=3;
                update();
            }
        });



        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mAnswer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Destiny", "Answer 2 clicked!");
                mTextStory.setText(R.string.T2_Story);
                mAnswer1.setText(R.string.T2_Ans1);
                mAnswer2.setText(R.string.T2_Ans2);
                mStoryIndex=2;
                update();
            }
        });


    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("IndexStory", mStoryIndex);
    }
    public void update(){
        if(mStoryIndex==2){
            mAnswer1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mTextStory.setText(R.string.T3_Story);
                    mAnswer1.setText(R.string.T3_Ans1);
                    mAnswer2.setText(R.string.T3_Ans2);
                    mStoryIndex=3;
                    update();
                }
            });
            mAnswer2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mTextStory.setText(R.string.T4_End);
                    mAnswer1.setVisibility(View.GONE);
                    mAnswer2.setVisibility(View.GONE);
                }
            });
        }
        if(mStoryIndex==3){
            mAnswer1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mTextStory.setText(R.string.T6_End);
                    mAnswer1.setVisibility(View.GONE);
                    mAnswer2.setVisibility(View.GONE);
                }
            });
            mAnswer2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mTextStory.setText(R.string.T5_End);
                    mAnswer1.setVisibility(View.GONE);
                    mAnswer2.setVisibility(View.GONE);
                }
            });
        }
    }
}
