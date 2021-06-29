package com.shagii.loginmvvm;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.shagii.loginmvvm.adapter.CourseAdapter;
import com.shagii.loginmvvm.databinding.ActivityCourseBinding;
import com.shagii.loginmvvm.model.course.Course;
import com.shagii.loginmvvm.model.course.CourseResponseModel;
import com.shagii.loginmvvm.utility.AppPreferences;
import com.shagii.loginmvvm.viewmodel.CourseViewModel;

import java.util.ArrayList;
import java.util.List;

public class CourseActivity extends AppCompatActivity {
    public RecyclerView recyclerView;
    public CourseViewModel courseViewModel;
    public String token;
    public int SUCCESS = 200;

    ActivityCourseBinding mBinding;
    public  List<Course> courseList =new ArrayList<>();
    CourseAdapter courseAdapter;
    private LinearLayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_course);
        mBinding= DataBindingUtil.setContentView(this,R.layout.activity_course);
        courseViewModel= ViewModelProviders.of(this).get(CourseViewModel.class);
        mBinding.setCourse(courseViewModel);

        token = AppPreferences.getToken(CourseActivity.this);
        courseViewModel.onCoursesList(0,0,token);
        setObserver();
        initView();


    }

    private void initView() {
        mLayoutManager = (new LinearLayoutManager(getApplicationContext()));
        mBinding.rvCourses.setLayoutManager(mLayoutManager);
        mBinding.rvCourses.setNestedScrollingEnabled(false);
        mBinding.rvCourses.setItemAnimator(null);
        courseAdapter=new CourseAdapter(getApplicationContext());
    }


    private void setObserver(){
     courseViewModel.getAllCourseResponseData().observe(this, new Observer<CourseResponseModel>() {
         @Override
         public void onChanged(CourseResponseModel courseResponseModel) {
          if (courseResponseModel.getStatus().equals(SUCCESS)){
              Toast.makeText(CourseActivity.this,"Connected ", Toast.LENGTH_LONG).show();

              onCoursesSuccess(courseResponseModel);
          }else {
              Toast.makeText(CourseActivity.this,"Failed to Establish Connection ", Toast.LENGTH_LONG).show();
          }
         }
     });
   }

   private void onCoursesSuccess( CourseResponseModel courseResponseModel){
       List<Course> courseList;
       if (courseResponseModel.getCourseData().getCount()!=0){
         courseList = courseResponseModel.getCourseData().getCourseList();
         courseAdapter.setCourseData(courseResponseModel.getCourseData().getCourseList());
         mBinding.rvCourses.setAdapter(courseAdapter);
         for (Course c : courseList){
          System.out.println("Id-> "+c.getId()+", Name-> "+c.getCourseEn()+ ", Desc-> "+c.getDiscription()+", price-> "+c.getPrice());
         }
       }
   }
}