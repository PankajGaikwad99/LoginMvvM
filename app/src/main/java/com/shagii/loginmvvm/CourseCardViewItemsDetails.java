package com.shagii.loginmvvm;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.shagii.loginmvvm.databinding.ActivityCourseCardViewItemsDetailsBinding;

public class CourseCardViewItemsDetails extends AppCompatActivity {
    TextView title,desc;
    ActivityCourseCardViewItemsDetailsBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_card_view_items_details);
        //title=findViewById(R.id.txtTitle);
        Intent i=getIntent();
        String a= i.getStringExtra("courseN");
        String b=i.getStringExtra("desc");
       title=findViewById(R.id.txtTitle);
       desc=findViewById(R.id.txtDesc);
       title.setText(a);
       desc.setText(b);
        //title.setText(a);
    }
}