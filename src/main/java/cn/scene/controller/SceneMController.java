package cn.scene.controller;

import cn.scene.model.Scene;
import cn.scene.model.User;
import cn.scene.service.SceneMService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 场景管理:上架，编辑，设置，删除
 */
@Controller
@RequestMapping("/s/manage")
public class SceneMController {

    @Autowired
    private SceneMService sceneMService;

    //上架
    @RequestMapping("/shelve")
    public @ResponseBody Boolean shelve(HttpServletRequest request){
        Boolean result = false;
        User user = (User)request.getSession().getAttribute("user");
        result = sceneMService.shelve(user.getId());
        return result;
    }

    //设置
    @RequestMapping("/setting")
    public @ResponseBody Scene setting(HttpServletRequest request){
        User user = (User)request.getSession().getAttribute("user");
        Scene scene = sceneMService.setting(user.getId());
        return scene;
    }

    //完成设置
    @RequestMapping("/issue")
    public @ResponseBody Boolean issue(HttpServletRequest request,Scene scene){
        if(scene!=null){
            int temp = sceneMService.issue(scene);
            if(temp>0){
                return true;
            }
        }
        return false;
    }

    //模板删除
    @RequestMapping("/del")
    public @ResponseBody Boolean delete(HttpServletRequest request){
        Boolean result = false;
        User user = (User)request.getSession().getAttribute("user");
        result = sceneMService.delete(user.getId());
        return result;
    }

    //我的小店
    @RequestMapping("/store")
    public @ResponseBody List<Scene> store(HttpServletRequest request){
        User user = (User)request.getSession().getAttribute("user");
        List<Scene> list = list = sceneMService.sceneList(user.getId());
        return list;
    }

}
