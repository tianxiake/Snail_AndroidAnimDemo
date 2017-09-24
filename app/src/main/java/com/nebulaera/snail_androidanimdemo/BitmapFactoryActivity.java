package com.nebulaera.snail_androidanimdemo;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BitmapFactoryActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String LYJ_TAG = "LYJ_BitmapFactory";
    @BindView(R.id.btn_bitmap_factory_decode_assets_by_inputStream)
    Button inputStreamBtn;
    @BindView(R.id.btn_bitmap_factory_decode_assets_by_file_descriptor)
    Button fileDescriptorBtn;
    @BindView(R.id.imageView)
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap);
        ButterKnife.bind(this);
        inputStreamBtn.setOnClickListener(this);
        fileDescriptorBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_bitmap_factory_decode_assets_by_file_descriptor:
                Log.d(LYJ_TAG, "file descriptor");
                decodeByFileDescriptor();
                break;
            case R.id.btn_bitmap_factory_decode_assets_by_inputStream:
                Log.d(LYJ_TAG, "inputStream");
                decodeByInputStream();
                break;
        }
    }

    private void decodeByFileDescriptor() {
        AssetManager assets = getAssets();
        try {
            //这种方式无法进行decode
            AssetFileDescriptor assetFileDescriptor = assets.openFd("two.jpg");
            Bitmap bitmap = BitmapFactory.decodeFileDescriptor(assetFileDescriptor.getFileDescriptor());
            if (bitmap == null) {
                Toast.makeText(this, "Don't support", Toast.LENGTH_LONG).show();
            }
            imageView.setImageBitmap(bitmap);
        } catch (Exception e) {
            Log.e(LYJ_TAG, e.toString());
        }
    }

    private void decodeByInputStream() {
        InputStream open = null;
        try {
            //流可以decode
            AssetManager assets = getAssets();
            open = assets.open("two.jpg");
        } catch (IOException e) {
            Log.e(LYJ_TAG, e.toString());
        }
        Bitmap bitmap = BitmapFactory.decodeStream(open);
        imageView.setImageBitmap(bitmap);
    }
}
