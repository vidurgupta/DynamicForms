package com.example.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by vidur on 16/8/16.
 */
@Repository
public interface DFUsersRepository extends JpaRepository<DFUsers,String>{
    List<DFUsers> findAll();
    DFUsers findByUsername(String username);

}
