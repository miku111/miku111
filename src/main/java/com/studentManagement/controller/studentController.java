package com.studentManagement.controller;

import com.github.pagehelper.PageInfo;
import com.studentManagement.pojo.StudentEntity;
import com.studentManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class studentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public PageInfo getAll(@RequestParam(defaultValue = "1") Integer pageNum,
                           @RequestParam(defaultValue = "5") Integer pageSize,
                           @RequestParam(required = false) Integer minAge, @RequestParam(required = false)  Integer maxAge){

        PageInfo<StudentEntity> pageInfo = null;
        if(minAge==null&&maxAge==null){
            pageInfo=studentService.selectByPage(pageNum, pageSize);
            return pageInfo;
        }else if(minAge==null&&maxAge!=null){
            pageInfo=studentService.selectByAgeLessOrEqual(pageNum,pageSize, maxAge);
            return pageInfo;
        }else if(minAge!=null&&maxAge==null){
            pageInfo=studentService.selectByAgeLargeOrEqual(pageNum,pageSize, minAge);
            return pageInfo;
        }else{
            pageInfo=studentService.selectByAgeBetween(pageNum,pageSize, minAge,maxAge);
            return pageInfo;
        }




        // 将查询结果传递给前端


    }

    @GetMapping("/{id}")
    public StudentEntity getOne(@PathVariable Integer id) {
        return studentService.selectOne(id);
    }

    @DeleteMapping("/{id}")
    public String deleteOne(@PathVariable Integer id) {


        return "删除成功" + id + studentService.deleteOne(id);

    }

    @PostMapping
    public boolean createOne(@RequestBody StudentEntity student) {
        System.out.println(student);
        return studentService.createOne(student);
    }

    @PutMapping
    public String updateOne(@RequestBody StudentEntity student) {
        System.out.println(student);
        return "更新成功" + studentService.updateOne(student);

        //return
    }
}
