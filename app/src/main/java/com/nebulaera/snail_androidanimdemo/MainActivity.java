package com.nebulaera.snail_androidanimdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private static final String LYJ_TAG = "LYJ_MainActivity";
    @BindView(R.id.btn_test_decode_assets_resource)
    Button decodeAssetsResourceBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        InputStream open = null;
//        try {
//            AssetManager assets = getAssets();
//            open = assets.open("two.jpg");
//        } catch (IOException e) {
//            Log.e(LYJ_TAG, e.toString());
//        }
//        Bitmap bitmap = BitmapFactory.decodeStream(open);
//        ImageView imageView = new ImageView(this);
//        imageView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
//        imageView.setImageBitmap(bitmap);
//        setContentView(imageView);
    }


}
