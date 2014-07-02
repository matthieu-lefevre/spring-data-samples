package com.mlefevre.samples.data.controller.rest;

import com.mlefevre.samples.data.entity.User;
import com.mlefevre.samples.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserRestController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<User> getAll() {

        return this.userService.getAllUsers();
    }

}
