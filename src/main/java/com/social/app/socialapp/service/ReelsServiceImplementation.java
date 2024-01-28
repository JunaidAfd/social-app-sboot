package com.social.app.socialapp.service;

import com.social.app.socialapp.models.Reels;
import com.social.app.socialapp.models.User;
import com.social.app.socialapp.repository.ReelsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReelsServiceImplementation implements ReelsService{
    @Autowired
    private ReelsRepository reelsRepository;
    @Autowired
    private UserService userService;

    @Override
    public Reels createReel(Reels reel, User user) {
        Reels createReel=new Reels();

        createReel.setTitle(reel.getTitle());
        createReel.setUser(reel.getUser());
        createReel.setVideo(reel.getVideo());

        return reelsRepository.save(createReel);
    }

    @Override
    public List<Reels> findAllReels() {
        return reelsRepository.findAll();
    }

    @Override
    public List<Reels> findUsersReel(Integer userId) throws Exception {
        userService.findUserById(userId);
        return reelsRepository.findByUserId(userId);
    }
}
