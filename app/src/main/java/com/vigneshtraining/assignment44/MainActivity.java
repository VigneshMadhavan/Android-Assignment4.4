package com.vigneshtraining.assignment44;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Integer[] imagArr={R.drawable.version_1,R.drawable.version_2,R.drawable.version_3,R.drawable.version_4,R.drawable.version_5,R.drawable.version_6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView=(GridView) findViewById(R.id.grid);

        ArrayList<GridData> dataArrayList=new ArrayList<GridData>();
        Log.e("Main","imagArr.length::"+imagArr.length);

        for (int i=0;i<imagArr.length;i++){

            GridData data= new GridData();
            data.setImage(imagArr[i]);
            data.setTitle("Title "+(i+1));
            dataArrayList.add(data);

        }

       GridItem adapter=new GridItem(dataArrayList,MainActivity.this);
        gridView.setAdapter(adapter);
    }
}
