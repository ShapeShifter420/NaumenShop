package org.TeamDream.NaumenShop.services;

import org.TeamDream.NaumenShop.DB.DataBase;
import org.TeamDream.NaumenShop.DB.models.Role;
import org.TeamDream.NaumenShop.DB.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService {

//    @Autowired
//    UserRepository userRepository;
//    @Autowired
//    RoleRepository roleRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = DataBase.findByUserName(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }

    public boolean saveUser(User user) {
        User userFromDB = DataBase.findByUserName(user.getUsername());

        if (userFromDB != null) {
            return false;
        }

        if (user.getUsername().equals("admin")) user.setRoles(Collections.singleton(new Role(2L, "ROLE_ADMIN")));
        else user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        DataBase.registerUser(user);
        return true;
    }
}
