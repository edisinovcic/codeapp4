package com.eestec.codeapp.user;

import com.eestec.codeapp.base.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public RestResponse findAll() {
        return new RestResponse(true).setData(userService.fetchAll());
    }

    @GetMapping
    public RestResponse findOne(@RequestParam(value = "id") Long id) {
        return new RestResponse(true).setData(userService.fetchOne(id));
    }

    @PostMapping
    public RestResponse save(@RequestBody @Valid UserDto userDto) {
        return new RestResponse(true).setData(userService.save(userDto));
    }

    @DeleteMapping
    public RestResponse delete(@RequestParam Long userId) {
        userService.delete(userId);
        return new RestResponse(true);
    }


}
