package example.dao;

import example.model.Menu;

import java.util.List;

public interface MenuMapper {
    public Menu getMenuById(Integer menuid);

    public Menu getMenuByName(String menuname);

    public int insertMenu(Menu menu);

    public int deleteMenu(Integer menuid);

    public int updateMenu(Menu menu);

    public List<Menu> getMenus();
}
