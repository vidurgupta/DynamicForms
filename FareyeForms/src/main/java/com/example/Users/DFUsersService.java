package com.example.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vidur on 16/8/16.
 */
@Service
public class DFUsersService {

    @Autowired
    DFUsersRepository DFUsersRepository;

    @Transactional
    DFUsers giveuser(String username)
    {
        if(DFUsersRepository.findByUsername(username)!=null)
            return DFUsersRepository.findByUsername(username);
        else
             return null;
    }
    @Transactional
    List<DFUsers> giveAll()
    {
        return DFUsersRepository.findAll();
    }

    public void insert(DFUsers g) {
        DFUsersRepository.save(g);
    }
}
