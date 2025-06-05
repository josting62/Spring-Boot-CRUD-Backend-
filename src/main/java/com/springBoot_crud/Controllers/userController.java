package com.springBoot_crud.Controllers;

import com.springBoot_crud.Models.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.GetExchange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class userController {

    //List example users
    private List<User> users = new ArrayList<>(Arrays.asList(
       new User(1, "Jostin Gomez", "jostingomez03@gmail.com", "Av 8E #2-31/35 Quinta Oriental", "3008929774"),
       new User(2, "Maria Ortiz", "majo_ortiz@gmail.com", "Cll 2 #3-28/30 Trigal", "3008929775")
    ));

    //Show All users
    @GetMapping
    public List<User> getUsers() {
        return users;
    }
    //Create a new User
    @PostMapping
    public User addUser(@RequestBody User user) {
        users.add(user);
        return user;
    }
    //Total update user´s dates
    public User updateUser(@RequestBody User user) {
        for (User u : users) {
            if (u.getId() == user.getId()) {
                u.setName(user.getName());
                u.setEmail(user.getEmail());
                u.setAddress(user.getAddress());
                u.setPhone(user.getPhone());
                return u;
            }
        }
        return null;
    }

    //Partial update user´s dates
    @PatchMapping
    public User patchUser(@RequestBody User user) {
        for (User u : users) {
            if (u.getId() == user.getId()) {
                if(user.getName() != null){
                    u.setName(user.getName());
                }
                if(user.getEmail() != null){
                    u.setEmail(user.getEmail());
                }
                if(user.getPhone() != null){
                    u.setPhone(user.getPhone());
                }
                return u;
            }
        }
        return user;
    }
    //Delete User
    public User deleteUser(@PathVariable int id) {
        for (User u : users) {
            if (u.getId() == id) {
                users.remove(u);
                return u;
            }
        }
        return null;
    }

}
