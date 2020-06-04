package com.rakitov.spring_crud.controller;

import com.rakitov.spring_crud.model.Role;
import com.rakitov.spring_crud.model.User;
import com.rakitov.spring_crud.service.RoleService;
import com.rakitov.spring_crud.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping(value = "/admin")
@AllArgsConstructor
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;

    @ModelAttribute("role")
    public List<Role> initialiseRole() { return roleService.getAllRole(); }

    @GetMapping
    public String getAllUser(ModelMap modelMap) {
        modelMap.addAttribute("allUsers", userService.getAllUser());
        return "admin";
    }

    @GetMapping(value = "/add")
    public String createAddPage(ModelMap modelMap) {
        modelMap.addAttribute("user", new User());
        modelMap.addAttribute("roles", roleService.getAllRole());
        return "add";
    }

    @PostMapping(value = "/add")
    public String addUser(User user, String[] role) {
        userService.createUser(user, role);
        return "redirect:/admin";
    }

    @GetMapping(value = "/update/{id}")
    public String createUpdatePage(@PathVariable Long id, ModelMap modelMap) {
        modelMap.addAttribute("user", userService.findUserById(id));
        modelMap.addAttribute("roles", roleService.getAllRole());
        return "update";
    }

    @PostMapping(value = "/update")
    public String updateUser(User user, String[] role) {
        userService.updateUser(user, role);
        return "redirect:/admin";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.removeUser(id);
        return "redirect:/admin";
    }
}
