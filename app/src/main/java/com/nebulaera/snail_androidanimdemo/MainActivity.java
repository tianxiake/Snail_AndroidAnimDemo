package com.nebulaera.snail_androidanimdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String LYJ_TAG = "LYJ_MainActivity";
    @BindView(R.id.btn_test_decode_assets_resource)
    Button decodeAssetsResourceBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        decodeAssetsResourceBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_test_decode_assets_resource:
                startInsideActivity(BitmapFactoryActivity.class);
                break;
            case 2:
                break;
            default:
                break;
        }
    }

    private void startInsideActivity(Class<? extends Activity> activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }
}
