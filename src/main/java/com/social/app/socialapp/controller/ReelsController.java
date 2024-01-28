package com.social.app.socialapp.controller;

import com.social.app.socialapp.models.Reels;
import com.social.app.socialapp.models.User;
import com.social.app.socialapp.service.ReelsService;
import com.social.app.socialapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReelsController {
    @Autowired
    private ReelsService reelsService;
    @Autowired
    private UserService userService;

    @PostMapping("/api/reels")
    public Reels createReels(@RequestBody Reels reels, @RequestHeader("Authorization") String jwt){
        User reqUser=userService.findUserByJwt(jwt);
        Reels createdReels=reelsService.createReel(reels,reqUser);

        return createdReels;
    }

    @GetMapping("/api/reels")
    public List<Reels> findAllReels(){
         List<Reels> reels=reelsService.findAllReels();

        return reels;
    }

    @GetMapping("/api/reels/user/{userId}")
    public List<Reels> findUsersReels(@PathVariable Integer userId) throws Exception {
        List<Reels> reels=reelsService.findUsersReel(userId);

        return reels;
    }

}
