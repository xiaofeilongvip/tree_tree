package com.by.controller;

import com.by.entity.TUser;
import com.by.service.TUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TUser)表控制层
 *
 * @author makejava
 * @since 2019-12-12 20:48:49
 */
@Controller
@RequestMapping("vue")
public class TUserController {
    /**
     * 服务对象
     */
    @Resource
    private TUserService tUserService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("selectOne")
    public TUser selectOne(Integer id) {

        return this.tUserService.queryById(id);
    }
    @ResponseBody
    @RequestMapping("update")
    public String update(TUser tUser){
        tUserService.update(tUser);
        return "success";
    }

    @RequestMapping("list")
    public String list(){
        return "list1";
    }

    @ResponseBody
    @RequestMapping("findAll")
    public List<TUser> findAll(){
        List<TUser> tUsers = tUserService.queryAllByLimit(0, 1000);
        return tUsers;
    }
    @ResponseBody
    @RequestMapping("delete")
    public String delete(Integer id){
        tUserService.deleteById(id);
        return "success";
    }
    @ResponseBody
    @RequestMapping("add")
    public String delete(TUser tUser){
        tUserService.insert(tUser);
        return "success";
    }


}