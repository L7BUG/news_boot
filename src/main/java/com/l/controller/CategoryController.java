package com.l.controller;

import com.l.json.CODE;
import com.l.json.MyJSON;
import com.l.pojo.Category;
import com.l.requestUrl.DELETE;
import com.l.requestUrl.GET;
import com.l.requestUrl.POST;
import com.l.requestUrl.PUT;
import com.l.service.CategoryService;
import com.l.utils.RespJsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping(GET.QUERY_ALL_CATEGORY)
    public MyJSON<List<Category>> selectAll() {
        MyJSON<List<Category>> resp = null;
        try {
            List<Category> categories = categoryService.selectAll();
            resp = RespJsonUtils.get(categories, true);
        } catch (Exception e) {
            resp = RespJsonUtils.get(null, false);
        } finally {
            return resp;
        }
    }

    @PostMapping(POST.ADD_CATEGORY)
    public MyJSON<Void> insertOne(@RequestBody Category category) {
        MyJSON<Void> resp = null;
        try {
            categoryService.insertOne(category);
            resp = RespJsonUtils.get(CODE.OK, "添加成功", null);
        } catch (Exception e) {
            resp = RespJsonUtils.get(null, false);
        } finally {
            return resp;
        }
    }

    @DeleteMapping(DELETE.DELETE_CATEGORY + "/{id}")
    public MyJSON<Void> deleteOde(@PathVariable int id) {
        MyJSON<Void> resp = null;
        try {
            categoryService.deleteByPrimaryKey(id);
            resp = RespJsonUtils.get(CODE.OK, "删除成功", null);
        } catch (Exception e) {
            resp = RespJsonUtils.get(CODE.ERROR, "因为约束关系无法删除:" +
                    "有新闻引用该约束", null);
        } finally {
            return resp;
        }
    }

    @PutMapping(PUT.UPDATE_CATEGORY)
    public MyJSON<Void> updateCategory(@RequestBody Category category) {
        MyJSON<Void> resp = null;
        try {
            categoryService.updateByPrimaryKey(category);
            resp = RespJsonUtils.get(CODE.OK, "修改成功", null);
        } catch (Exception e) {
            resp = RespJsonUtils.get(CODE.ERROR, "修改失败", null);
        } finally {
            return resp;
        }
    }
}
