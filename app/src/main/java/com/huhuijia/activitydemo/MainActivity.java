package com.huhuijia.activitydemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mUserET;
    private ImageView mProfileImage;
    private Button mBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mUserET = (EditText) findViewById(R.id.userET);
        mProfileImage = (ImageView) findViewById(R.id.profile_image);
        mBtn = (Button) findViewById(R.id.btn);
mProfileImage.setOnClickListener(this);
        mBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.profile_image:
                String username = mUserET.getText().toString().trim();
                if (!username.isEmpty()) {
                    Intent intent = new Intent(MainActivity.this,IconActivity.class);
                    intent.putExtra("username", username);
                    startActivityForResult(intent, 1001);
                }
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1001&&resultCode==1001){
            Bundle bundle=data.getExtras();
            int imageId=bundle.getInt("imageId");
            mProfileImage.setImageResource(imageId);
        }
    }
}
