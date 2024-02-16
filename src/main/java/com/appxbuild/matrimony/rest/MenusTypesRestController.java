package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.MenusTypes;
import com.appxbuild.matrimony.service.MenusTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MenusTypesRestController {

    private MenusTypesService menusTypesService;

    @Autowired
    public MenusTypesRestController(MenusTypesService theMenusTypesService){
        menusTypesService = theMenusTypesService;
    }

    // expose "/menusTypes" and return a list of Menus Types
    @GetMapping("/menusTypes")
    public List<MenusTypes> findAll(){
        return menusTypesService.findAll();
    }

    // add mapping for Get "/menusTypes/{menusTypeId}"
    @GetMapping("/menusTypes/{menusTypeId}")
    public MenusTypes getMenuType(@PathVariable int menusTypeId){
        MenusTypes theMenuType = menusTypesService.findById(menusTypeId);

        if(theMenuType == null){
            throw new RuntimeException("Menu Type is not found" + menusTypeId);
        }
        return theMenuType;
    }

    //add mapping for POST "/menusTypes" - add new Menu Type
    @PostMapping("/menusTypes")
    public MenusTypes addMenuType(@RequestBody MenusTypes theMenusTypes){
        theMenusTypes.setId(0);
        LocalDateTime localDateTime = LocalDateTime.now();
        theMenusTypes.setCreated(localDateTime);
        theMenusTypes.setModified(null);
        MenusTypes newMenuTypes = menusTypesService.save(theMenusTypes);
        return newMenuTypes;
    }

    //add mapping for PUT "/menusTypes" - update Menu Type
    @PutMapping("/menusTypes")
    public MenusTypes updateMenuType(@RequestBody MenusTypes theMenusTypes){
        LocalDateTime localDateTime = LocalDateTime.now();
        theMenusTypes.setModified(localDateTime);
        MenusTypes newMenuTypes = menusTypesService.save(theMenusTypes);
        return newMenuTypes;
    }

    // add mapping for DELETE "/menusTypes/{menusTypeId}" to delete menu type
    @DeleteMapping("/menusTypes/{menusTypeId}")
    public String deleteMenuType(@PathVariable int menusTypeId){
        MenusTypes theMenuType = menusTypesService.findById(menusTypeId);
        menusTypesService.deleteById(menusTypeId);
        if(theMenuType == null){
            throw new RuntimeException("Menu Type is not found" + menusTypeId);
        }
        return "Deleted Menu Type id " + menusTypeId;
    }

}
