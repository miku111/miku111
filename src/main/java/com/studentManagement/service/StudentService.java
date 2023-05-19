package com.studentManagement.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.studentManagement.mapper.StudentMapper;
import com.studentManagement.pojo.StudentEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;
    public List<StudentEntity> selectAll(){
return  studentMapper.selectAll();
    }
    public PageInfo<StudentEntity> selectByPage(Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);

        List<StudentEntity> scoreList = studentMapper.selectByPage();

        // 将查询结果封装成 PageInfo 对象并返回
        PageInfo<StudentEntity> pageInfo = new PageInfo<>(scoreList);
        return pageInfo;
    }
public List<Integer> selectAllId(@Nullable Integer pageNum,@Nullable Integer pageSize){
        if(pageNum==null&&pageSize==null){
            return studentMapper.selectAllId();
        }else{

            PageHelper.startPage(pageNum, pageSize);
            List<Integer> allId= studentMapper.selectAllId();
            return  allId;
        }
}
    public  StudentEntity  selectOne(Integer id){
return studentMapper.selectOne(id);
    }

    public boolean deleteOne(Integer id){
        System.out.println(id);
        return  studentMapper.deleteOne(id);
    }

    public boolean updateOne(StudentEntity student){
return studentMapper.updateOne(student);
    }

    public boolean createOne(StudentEntity student){
return studentMapper.createOne(student);
    }

    public PageInfo<StudentEntity> selectByAgeLessThan(Integer pageNum, Integer pageSize,Integer age){

            PageHelper.startPage(pageNum, pageSize);

            List<StudentEntity> scoreList = studentMapper.selectByAgeLessThan(age);

            // 将查询结果封装成 PageInfo 对象并返回
            PageInfo<StudentEntity> pageInfo = new PageInfo<>(scoreList);
            return pageInfo;


    }
    public PageInfo<StudentEntity> selectByAgeLessOrEqual(Integer pageNum, Integer pageSize,Integer age){

        PageHelper.startPage(pageNum, pageSize);

        List<StudentEntity> scoreList = studentMapper.selectByAgeLessThan(age+1);

        // 将查询结果封装成 PageInfo 对象并返回
        PageInfo<StudentEntity> pageInfo = new PageInfo<>(scoreList);
        return pageInfo;


    }
    public PageInfo<StudentEntity> selectByAgeLargeThan(Integer pageNum, Integer pageSize,Integer age){

        PageHelper.startPage(pageNum, pageSize);

        List<StudentEntity> scoreList = studentMapper.selectByAgeLargeThan(age);

        // 将查询结果封装成 PageInfo 对象并返回
        PageInfo<StudentEntity> pageInfo = new PageInfo<>(scoreList);
        return pageInfo;


    }
    public PageInfo<StudentEntity> selectByAgeLargeOrEqual(Integer pageNum, Integer pageSize,Integer age){

        PageHelper.startPage(pageNum, pageSize);

        List<StudentEntity> scoreList = studentMapper.selectByAgeLargeThan(age-1);

        // 将查询结果封装成 PageInfo 对象并返回
        PageInfo<StudentEntity> pageInfo = new PageInfo<>(scoreList);
        return pageInfo;


    }
    public PageInfo<StudentEntity> selectByAgeBetween(Integer pageNum, Integer pageSize,Integer minAge,Integer maxAge){

        PageHelper.startPage(pageNum, pageSize);

        List<StudentEntity> scoreList = studentMapper.selectByAgeBetween(minAge,maxAge);

        // 将查询结果封装成 PageInfo 对象并返回
        PageInfo<StudentEntity> pageInfo = new PageInfo<>(scoreList);
        return pageInfo;


    }

}
