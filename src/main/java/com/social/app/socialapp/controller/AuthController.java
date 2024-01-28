package com.social.app.socialapp.controller;

import com.social.app.socialapp.config.JwtProvider;
import com.social.app.socialapp.models.User;
import com.social.app.socialapp.repository.UserRepository;
import com.social.app.socialapp.response.AuthResponse;
import com.social.app.socialapp.service.CustomUserDetailsService;
import com.social.app.socialapp.service.UserService;
import com.social.app.socialapp.request.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @PostMapping("/signup")
    public AuthResponse createUser(@RequestBody User user) throws Exception {

        User isExist= userRepository.findByEmail(user.getEmail());
        if(isExist !=null){
            throw new Exception("email already used by another account.");
        }

        User newUser=new User();

        newUser.setEmail(user.getEmail());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));

        User savedUser=userRepository.save(newUser);

        Authentication authentication=new UsernamePasswordAuthenticationToken(savedUser.getEmail(),savedUser.getPassword());
        String token = JwtProvider.generateToken(authentication);

        AuthResponse response=new AuthResponse(token,"Register Success");

        return response;
    }

    @PostMapping("/signin")
    public AuthResponse signin(@RequestBody LoginRequest loginRequest){
        Authentication authentication = authenticate(loginRequest.getEmail(),loginRequest.getPassword());

        String token = JwtProvider.generateToken(authentication);

        AuthResponse response=new AuthResponse(token,"Login Success");
        return response;
    }

    private Authentication authenticate(String email, String password) {
        UserDetails userDetails=customUserDetailsService.loadUserByUsername(email);
        if(userDetails == null)
            throw new BadCredentialsException("Invalid Username");
        if(!passwordEncoder.matches(password,userDetails.getPassword()))
            throw new BadCredentialsException("Invalid Password");

        return new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
    }

}
