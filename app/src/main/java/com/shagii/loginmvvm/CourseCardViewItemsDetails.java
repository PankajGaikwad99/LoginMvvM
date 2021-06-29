package com.shagii.loginmvvm;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.shagii.loginmvvm.databinding.ActivityCourseCardViewItemsDetailsBinding;

public class CourseCardViewItemsDetails extends AppCompatActivity {
    //TextView title;
    ActivityCourseCardViewItemsDetailsBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_card_view_items_details);
        //title=findViewById(R.id.txtTitle);
        Intent i=getIntent();
        String a= i.getStringExtra("Title");
        mBinding.txtTitle.setText(a);
        //title.setText(a);
    }
}