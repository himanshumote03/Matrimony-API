package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.MenusUsers;
import com.appxbuild.matrimony.service.MenusUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MenusUsersRestController {

    private MenusUsersService menusUsersService;

    @Autowired
    public MenusUsersRestController(MenusUsersService theMenusUsersService){
        menusUsersService = theMenusUsersService;
    }

    // expose "/menusUsers" and return a list of menus
    @GetMapping("/menusUsers")
    public List<MenusUsers> findAll(){
        return menusUsersService.findAll();
    }

    // add mapping for Get "/menusUsers/{menus_userId}"
    @GetMapping("/menusUsers/{menusUserId}")
    public MenusUsers getMenuUser(@PathVariable int menusUserId){
        MenusUsers theMenusUser = menusUsersService.findById(menusUserId);

        if(theMenusUser == null){
            throw new RuntimeException("Menu User is not found" + menusUserId);
        }
        return theMenusUser;
    }

    //add mapping for POST "/menusUsers" - add new Menu User
    @PostMapping("/menusUsers")
    public MenusUsers addMenuUser(@RequestBody MenusUsers theMenusUsers){
        theMenusUsers.setId(0);
        LocalDateTime localDateTime = LocalDateTime.now();
        theMenusUsers.setCreated(localDateTime);
        theMenusUsers.setModified(null);
        MenusUsers newMenuUser = menusUsersService.save(theMenusUsers);
        return newMenuUser;
    }

    //add mapping for PUT "/menusUsers" - update Menu User
    @PutMapping("/menusUsers")
    public MenusUsers updateMenuUser(@RequestBody MenusUsers theMenusUsers){
        LocalDateTime localDateTime = LocalDateTime.now();
        theMenusUsers.setModified(localDateTime);
        MenusUsers newMenuUser = menusUsersService.save(theMenusUsers);
        return newMenuUser;
    }

    // add mapping for DELETE "/menusUsers/{menusUserId}" to delete Menu User
    @DeleteMapping("/menusUsers/{menusUserId}")
    public String deleteMenuUser(@PathVariable int menusUserId){
        MenusUsers theMenusUser = menusUsersService.findById(menusUserId);
        menusUsersService.deleteById(menusUserId);
        if(theMenusUser == null){
            throw new RuntimeException("Menu User is not found" + menusUserId);
        }
        return "Deleted Menu User id " + menusUserId;
    }

}
