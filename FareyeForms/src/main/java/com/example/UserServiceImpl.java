package com.example;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.Users.DFUsers;
import com.example.Users.DFUsersRepository;

import java.util.Collection;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserDetailsService {


    @Autowired
   DFUsersRepository DFUsersRepository;

    @Override
    @Transactional

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {


        System.out.print("hi");
        DFUsers users = DFUsersRepository.findByUsername(username);
        if (users == null) {
            throw new UsernameNotFoundException("HiMVC Security:: Error in retrieving user(username=" + username + ")");
        }


        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                users.getUsername(),
                users.getPassword(),//here you can put a clear text password
                true,
                true,
                true,
                true,


                loadUserAuthorities(users.getType())

        );

        return userDetails;
    }

    public Collection<? extends GrantedAuthority> loadUserAuthorities(String role) {
        List<SimpleGrantedAuthority> auths = new java.util.ArrayList<SimpleGrantedAuthority>();
        auths.add(new SimpleGrantedAuthority(role));
        return auths;
    }}


