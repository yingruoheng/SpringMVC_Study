package example.controller;

import example.dao.MenuMapper;
import example.model.Menu;
import example.model.ReturnBean;
import example.service.MenuService;
import example.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@RequestMapping(value="/menu")
public class MenuController {
    private static Logger logger = LoggerFactory.getLogger(MenuMapper.class);

    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "/menuById")
    @ResponseBody
    //通过id获取菜单
    public ReturnBean getMenuById(String menuid) {
        logger.info("menuid{}", menuid);
        ReturnBean returnBean = new ReturnBean();
        Menu menu = new Menu();
        menu = menuService.getMenuById(Integer.parseInt(menuid));
        if(menu == null){
            returnBean.setRetVal(102);
            returnBean.setRetMsg("查询菜单失败");
            return returnBean;
        }
        returnBean.setRetBean(menu);
        return returnBean;
    }

    @RequestMapping(value = "/menuByName")
    @ResponseBody
    //通过name获取菜单
    public ReturnBean getMenuByName(String menuname) {
        logger.info("menuname{}", menuname);
        ReturnBean returnBean = new ReturnBean();
        Menu menu = new Menu();
        menu = menuService.getMenuByName(menuname);
        if(menu == null){
            returnBean.setRetVal(102);
            returnBean.setRetMsg("查询菜单失败");
            return returnBean;
        }
        returnBean.setRetBean(menu);
        return returnBean;
    }

    @RequestMapping(value = "/addMenu", method = RequestMethod.POST)
    @ResponseBody
    /* 新增菜单 */
    public ReturnBean addMenu(@RequestBody String param) {
        logger.info("param{}", param);
        ReturnBean returnBean = new ReturnBean();

        com.alibaba.fastjson.JSONObject object = new com.alibaba.fastjson.JSONObject();

        com.alibaba.fastjson.JSONObject jsonObject = com.alibaba.fastjson.JSONObject.parseObject(param);
        String menuname = jsonObject.getString("menuname");
        Integer price = Integer.parseInt(jsonObject.getString("price"));
        String introduction = jsonObject.getString("introduction");
        String picurl = jsonObject.getString("picurl");
        String status = jsonObject.getString("status");

        Menu menu = new Menu();
        menu.setMenuname(menuname);
        menu.setPrice(price);
        menu.setIntroduction(introduction);
        menu.setPicurl(picurl);
        menu.setStatus(status);
        int insertResult = menuService.insertMenu(menu);
        if( insertResult == 1){
            object.put("result", "添加成功");
        }else {
            object.put("result", "添加失败");
        }
        returnBean.setRetBean(object);
        return returnBean;
    }

    @RequestMapping(value = "/deleteMenu")
    @ResponseBody
    /* 删除菜单 */
    public ReturnBean deleteMenu(String menuid) {
        logger.info("menuid{}", menuid);
        ReturnBean returnBean = new ReturnBean();

        com.alibaba.fastjson.JSONObject object = new com.alibaba.fastjson.JSONObject();
        int deleteResult = menuService.deleteMenu(Integer.parseInt(menuid));
        if( deleteResult == 1){
            object.put("result", "删除成功");
        }else {
            object.put("result", "删除失败");
        }
        returnBean.setRetBean(object);
        return returnBean;
    }

    @RequestMapping(value = "/updateMenu", method = RequestMethod.POST)
    @ResponseBody
    /* 修改菜单 */
    public ReturnBean updateMenu(@RequestBody String param) {
        logger.info("param{}", param);
        ReturnBean returnBean = new ReturnBean();

        com.alibaba.fastjson.JSONObject object = new com.alibaba.fastjson.JSONObject();

        com.alibaba.fastjson.JSONObject jsonObject = com.alibaba.fastjson.JSONObject.parseObject(param);
        Integer menuid = Integer.parseInt(jsonObject.getString("menuid"));
        String menuname = jsonObject.getString("menuname");
        Integer price = Integer.parseInt(jsonObject.getString("price"));
        String introduction = jsonObject.getString("introduction");
        String picurl = jsonObject.getString("picurl");
        String status = jsonObject.getString("status");

        Menu menu = new Menu();
        menu.setMenuid(menuid);
        menu.setMenuname(menuname);
        menu.setPrice(price);
        menu.setIntroduction(introduction);
        menu.setPicurl(picurl);
        menu.setStatus(status);
        int insertResult = menuService.updateMenu(menu);
        if( insertResult == 1){
            object.put("result", "修改成功");
        }else {
            object.put("result", "修改失败");
        }
        returnBean.setRetBean(object);
        return returnBean;
    }

    @RequestMapping(value = "/menus")
    @ResponseBody
    //获取所有单
    public ReturnBean getMenus() {
        ReturnBean returnBean = new ReturnBean();
        List<Menu> menus = menuService.getMenus();
        returnBean.setRetBean(menus);
        return returnBean;
    }
}
