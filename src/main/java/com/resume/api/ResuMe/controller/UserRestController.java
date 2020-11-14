package com.resume.api.ResuMe.controller;

import com.resume.api.ResuMe.entity.User;
import com.resume.api.ResuMe.service.IUserService;
import com.resume.api.ResuMe.web.responses.Users.UserResponse;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api")
public class UserRestController {

    @Autowired
    private IUserService userService;

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Long id){
        return userService.findById(id);
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestParam("user") User user){
        return userService.save(user);
    }

    @PutMapping("/users/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public User updateUser(@PathVariable Long id, @RequestBody User user){
        User currUser = userService.findById(id);
        currUser.setName(user.getName());
        currUser.setSurname(user.getSurname());
        return userService.save(currUser);
    }

    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }

    @PostMapping("/users/login")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<UserResponse> login(@RequestParam("user") String username, @RequestParam("password") String pwd) {
        User current = userService.findByEmail(username);
        System.out.println("login");
        if(current == null){
            System.out.println("Invalid Credentials");
            return null;
        }
        if(!current.getPassword().equals(pwd)){
            System.out.println("Incorrect Password");
            return null;
        }
        String token = getJWTToken(username);
        current.setToken(token);

        return new ResponseEntity<UserResponse>(new UserResponse(current,HttpStatus.OK.value(),"Success"),HttpStatus.OK);
    }

    private String getJWTToken(String username) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("softtekJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }
}
