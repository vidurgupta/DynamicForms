package com.example.Attribute;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by vidur on 16/8/16.
 */
public interface AttributeRepository extends JpaRepository<Attribute,Integer> {
   List<Attribute> findById(int id);
   Attribute findByLabelAndFormname(String label,String formname);
   List<Attribute> findByFormname(String formname);
}
