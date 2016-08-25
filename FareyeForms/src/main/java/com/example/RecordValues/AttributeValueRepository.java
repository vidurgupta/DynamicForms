package com.example.RecordValues;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by vidur on 16/8/16.
 */
public interface AttributeValueRepository extends JpaRepository<AttributeValue,Integer> {
List<AttributeValue> findAll();
}
