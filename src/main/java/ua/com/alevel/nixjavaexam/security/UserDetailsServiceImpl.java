package ua.com.alevel.nixjavaexam.security;

import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ua.com.alevel.nixjavaexam.entity.User;
import ua.com.alevel.nixjavaexam.service.UserService;

import java.util.List;

@Component
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserService userService;

    @Override
    public AuthUser loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByLogin(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        return new AuthUser(
                user.getLogin(), user.getPassword(), List.of(new SimpleGrantedAuthority(user.getRole().getName()))
        );
    }
}
