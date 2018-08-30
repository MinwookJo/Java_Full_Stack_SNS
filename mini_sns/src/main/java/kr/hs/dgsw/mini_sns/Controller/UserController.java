package kr.hs.dgsw.mini_sns.Controller;

import kr.hs.dgsw.mini_sns.Model.UserDomain;
import kr.hs.dgsw.mini_sns.Service.SnsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    SnsService userService;

    @GetMapping("/{idx}")
    public ResponseFormat viewUser(@PathVariable("idx")int idx){
        return userService.viewUser(idx);
    }

    @PostMapping
    public ResponseFormat insert(@RequestBody UserDomain userDomain){
        return userService.insertUser(userDomain);
    }

    @PostMapping("/login")
    public ResponseFormat login (@RequestBody UserDomain userDomain){ return userService.login(userDomain); }

}
