package com.example.subeksha.myapplication.presenter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.subeksha.myapplication.R;

/**
 * Created by Subeksha on 2/27/17.
 */

public class TrekPresenterImpl extends AppCompatActivity implements TrekPresenter {
    ImageView imageView;
    ImageView imageView2;
    TextView textView;
    //TrekDetailsImpl trekDetails;
    //TrekView trekView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trek_layout);
        imageView = (ImageView) findViewById(R.id.d_store_image);
        textView = (TextView) findViewById(R.id.s_name);
        imageView.setImageResource(getIntent().getIntExtra("img_id",00));
        //imageView2.setImageResource(getIntent().getIntExtra("img2_id",00));
        textView.setText("Store: "+getIntent().getStringExtra("trial") );
    }


}
