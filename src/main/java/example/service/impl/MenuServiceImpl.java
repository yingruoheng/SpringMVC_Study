package example.service.impl;

import example.dao.MenuMapper;
import example.model.Menu;
import example.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public Menu getMenuById(Integer menuid) { return  menuMapper.getMenuById(menuid); }

    @Override
    public Menu getMenuByName(String menuname) { return  menuMapper.getMenuByName(menuname); }

    @Override
    public int insertMenu(Menu menu) { return  menuMapper.insertMenu(menu); }

    @Override
    public int deleteMenu (Integer menuid) { return  menuMapper.deleteMenu(menuid); }

    @Override
    public int updateMenu(Menu menu) { return  menuMapper.updateMenu(menu); }

    public List<Menu> getMenus() { return menuMapper.getMenus(); }
}