package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.Menus;
import com.appxbuild.matrimony.service.MenusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MenusRestController {

    private MenusService menusService;

    @Autowired
    public MenusRestController(MenusService theMenusService){
        menusService = theMenusService;
    }

    // expose "/menus" and return a list of menus
    @GetMapping("/menus")
    public List<Menus> findAll(){
        return menusService.findAll();
    }

    // add mapping for Get "/menus/{menuId}"
    @GetMapping("/menus/{menuId}")
    public Menus getMenu(@PathVariable int menuId){
        Menus theMenu = menusService.findById(menuId);

        if(theMenu == null){
            throw new RuntimeException("Menu is not found" + menuId);
        }
        return theMenu;
    }

    //add mapping for POST "/menus" - add new Menu
    @PostMapping("/menus")
    public Menus addMenu(@RequestBody Menus theMenus){
        theMenus.setId(0);
        LocalDateTime localDateTime = LocalDateTime.now();
        theMenus.setCreated(localDateTime);
        theMenus.setModified(null);
        Menus newMenu = menusService.save(theMenus);
        return newMenu;
    }

    //add mapping for PUT "/menus" - update Menu
    @PutMapping("/menus")
    public Menus updateMenu(@RequestBody Menus theMenus){
        LocalDateTime localDateTime = LocalDateTime.now();
        theMenus.setModified(localDateTime);
        Menus newMenu = menusService.save(theMenus);
        return newMenu;
    }

    // add mapping for DELETE "/menus/{menuId}" to delete menu
    @DeleteMapping("/menus/{menuId}")
    public String deleteMenu(@PathVariable int menuId){
        Menus theMenu = menusService.findById(menuId);
        menusService.deleteById(menuId);
        if(theMenu == null){
            throw new RuntimeException("Menu is not found" + menuId);
        }
        return "Deleted Menu id " + menuId;
    }

}
