package com.example.Form;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by vidur on 16/8/16.
 */
@Repository
public interface FormRepository extends JpaRepository<Forms,String> {
    Forms findByName(String name);
    List<Forms> findAll();
}
