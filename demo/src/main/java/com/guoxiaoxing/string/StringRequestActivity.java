package com.guoxiaoxing.string;

import android.content.Context;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.guoxiaoxing.VolleyApplication;
import com.guoxiaoxing.volley.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StringRequestActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.tv_request_data)
    TextView mTvRequestData;
    @BindView(R.id.btn_string_request)
    Button mBtnStringRequest;
    @BindView(R.id.activity_string_request)
    ConstraintLayout mActivityStringRequest;

    private Context mConext;
    private String mRequestUrl = "http://www.baidu.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_string_request);
        ButterKnife.bind(this);
        mConext = StringRequestActivity.this;
        mBtnStringRequest.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_string_request:
                getStringRequest();
                break;
        }
    }

    private void getStringRequest() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, mRequestUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                mTvRequestData.setText(response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(mConext, "请求错误:" + error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        VolleyApplication.getRequestQueue().add(stringRequest);
    }
}
