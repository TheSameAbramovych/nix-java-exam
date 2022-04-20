package ua.com.alevel.nixjavaexam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.com.alevel.nixjavaexam.controller.request.AuthRequest;
import ua.com.alevel.nixjavaexam.controller.request.RegistrationRequest;
import ua.com.alevel.nixjavaexam.controller.response.TokenResponseDto;
import ua.com.alevel.nixjavaexam.entity.Student;
import ua.com.alevel.nixjavaexam.entity.User;
import ua.com.alevel.nixjavaexam.security.JwtProvider;
import ua.com.alevel.nixjavaexam.service.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api")
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping("/register")
    public User registerUser(@RequestBody RegistrationRequest registrationRequest) {
        if (userService.loginIsUnique(registrationRequest.getLogin())){
//            TODO
            throw new RuntimeException("Login is used somebody");
        }
        Student user = new Student();
        user.setPassword(registrationRequest.getPassword());
        user.setLogin(registrationRequest.getLogin());
        user.setFirstName(registrationRequest.getFirstName());
        user.setLastName(registrationRequest.getLastName());
        user.setBirthDate(registrationRequest.getBirthDate());
        user.setEmail(registrationRequest.getEmail());
        userService.saveUser(user);
        return user;
    }

    @PostMapping("/token")
    public ResponseEntity<TokenResponseDto> auth(@RequestBody AuthRequest request, HttpServletResponse response) {
        User user = userService.findByLoginAndPassword(request.getLogin(), request.getPassword());
        String token = jwtProvider.generateToken(user.getLogin());

        Cookie cookie = new Cookie("token",token);
        cookie.setMaxAge(15 * 24 * 60 * 60);
        cookie.setSecure(true);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        response.addCookie(cookie);

        return new ResponseEntity<>(new TokenResponseDto(token), HttpStatus.OK);
    }
}
