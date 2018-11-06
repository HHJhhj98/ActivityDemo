package com.huhuijia.activitydemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class IconActivity extends AppCompatActivity {
    private TextView mUserTV;
    private GridView mGridView;
    public int[] imageId = new int[]{R.mipmap.ic_launcher, R.mipmap.ic_launcher_round, R.mipmap.yjtp};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icon);
        initView();
        getData();
    }

    private void getData() {
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        mUserTV.setText("亲爱的【" + username + "】用户,请选择头像！");

    }

    private void initView() {
        mUserTV = (TextView) findViewById(R.id.userTV);
        mGridView = (GridView) findViewById(R.id.gridView);
        BaseAdapter baseAdapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return imageId.length;
            }

            @Override
            public Object getItem(int position) {
                return position;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ImageView mProfileImage;
                if (convertView == null) {
                    mProfileImage = new ImageView(IconActivity.this);
                    mProfileImage.setAdjustViewBounds(true);
                    mProfileImage.setMaxHeight(158);
                    mProfileImage.setMaxWidth(150);

                    mProfileImage.setPadding(5, 5, 5, 5);
                } else {
                    mProfileImage = (ImageView) convertView;
                }
                mProfileImage.setImageResource(imageId[position]);
                return mProfileImage;
            }
        };
        mGridView.setAdapter(baseAdapter);
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = getIntent();
                Bundle bundle = new Bundle();
                bundle.putInt("imageId", imageId[position]);
                intent.putExtras(bundle);
                setResult(1001, intent);
                finish();
            }
        });
    }

}
