package com.guoxiaoxing.volley;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.guoxiaoxing.image.ImageRequestActivity;
import com.guoxiaoxing.json.JsonRequestActivity;
import com.guoxiaoxing.string.StringRequestActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.btn_string)
    Button mBtnString;
    @BindView(R.id.btn_json)
    Button mBtnJson;
    @BindView(R.id.btn_image)
    Button mBtnImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mBtnString.setOnClickListener(this);
        mBtnJson.setOnClickListener(this);
        mBtnImage.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_string:
                Intent stringIntent = new Intent(MainActivity.this, StringRequestActivity.class);
                startActivity(stringIntent);
                break;
            case R.id.btn_json:
                Intent jsonIntent = new Intent(MainActivity.this, JsonRequestActivity.class);
                startActivity(jsonIntent);
                break;
            case R.id.btn_image:
                Intent imageIntent = new Intent(MainActivity.this, ImageRequestActivity.class);
                startActivity(imageIntent);
                break;
        }
    }
}
