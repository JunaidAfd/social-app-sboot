package com.social.app.socialapp.service;

import com.social.app.socialapp.models.Reels;
import com.social.app.socialapp.models.User;

import java.util.List;

public interface ReelsService {
    public Reels createReel(Reels reel, User user);
    public List<Reels> findAllReels();
    public List<Reels> findUsersReel(Integer userId) throws Exception;
}
