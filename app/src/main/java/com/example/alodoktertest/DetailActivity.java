package com.example.alodoktertest;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.alodoktertest.data.SessionManager;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    int[] imgSlider = {};

    SessionManager session;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.carouselView)
    CarouselView carouselView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Detail Image");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        session = new SessionManager(this);
        checkCondition();

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(imgSlider[position]);
        }
    };

    public void checkCondition() {
        if (session.getTypeImage() == "Animal") {
            imgSlider = new int[] {R.drawable.img_kucing1, R.drawable.img_kucing2, R.drawable.img_kucing3};
        } else if (session.getTypeImage() == "Food") {
            imgSlider = new int[] {R.drawable.img_tahu1, R.drawable.img_tahu2, R.drawable.img_tahu3};
        } else if (session.getTypeImage() == "Electronic") {
            imgSlider = new int[] {R.drawable.img_gadget1, R.drawable.img_gadget2, R.drawable.img_gadget3};
        }
        carouselView.setPageCount(imgSlider.length);
        carouselView.setImageListener(imageListener);
    }
}
