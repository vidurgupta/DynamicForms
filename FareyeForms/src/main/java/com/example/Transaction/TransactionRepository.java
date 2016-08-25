package com.example.Transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by vidur on 19/8/16.
 */
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
    List<Transaction> findByUsername(String username);
    List<Transaction> findAll();
    List<Transaction> findByIdAndFormname(int id,String formname);
    @Query(value = "select label,attributevalue from attribute,attribute_value where attribute.id=attribute_value.attribute_id and attribute_value.transaction_id=?1 and formname=?2 ",nativeQuery = true)
    List findRecords(int TransactionId,String name);
}
