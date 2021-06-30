package com.shagii.loginmvvm.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.shagii.loginmvvm.CourseCardViewItemsDetails;
import com.shagii.loginmvvm.R;
import com.shagii.loginmvvm.databinding.CourseListBinding;
import com.shagii.loginmvvm.model.course.Course;
import com.shagii.loginmvvm.viewmodel.ItemCourseViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseItemHolder> {
    Context mCtx;
    List<Course> mCourseList;
    public String course,desc;
    public CourseAdapter(Context mCtx) {
        this.mCtx = mCtx;
    }
    public void setCourseData(List<Course> mCourseList){
     this.mCourseList= mCourseList;
     notifyDataSetChanged();
    }
    @Override
    public CourseItemHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        CourseListBinding mBinding=  DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.course_list, parent, false);
        return new CourseItemHolder(mBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CourseItemHolder holder, int position) {
        holder.bind(mCourseList.get(position));
        holder.mBinding.cv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), CourseCardViewItemsDetails.class);
                course=mCourseList.get(position).getCourseEn().toString();
                desc=mCourseList.get(position).getDiscription().toString();
                i.putExtra("courseN", course);
                i.putExtra("desc", desc);
                v.getContext().startActivity(i);

            }
        });
    }

    @Override
    public int getItemCount() {
        return mCourseList == null ? 0 : mCourseList.size();
    }

    public class CourseItemHolder extends RecyclerView.ViewHolder{
   CourseListBinding mBinding;
     public CourseItemHolder(CourseListBinding mBinding) {
         super(mBinding.getRoot());
         this.mBinding= mBinding;
     }
     public void bind(Course course) {

         if (mBinding.getItemCourse() == null) {
             mBinding.setItemCourse(new ItemCourseViewModel(itemView.getContext(), course));

         } else {
             mBinding.getItemCourse().setCourseList(course);
         }
     }
 }
}