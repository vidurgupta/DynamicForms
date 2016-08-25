package com.example.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vidur on 19/8/16.
 */
@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    @Transactional
     Transaction insertTransaction(Transaction transaction)
    {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        transaction.setUsername(userName);
        transactionRepository.save(transaction);
        return transaction;

    }

    @Transactional
    public List<Transaction> viewTransaction(String name)
    {
        if(transactionRepository.findByUsername(name).size()>0)
            return transactionRepository.findByUsername(name);

        return null;
    }

    @Transactional
    List showRecord(List<Transaction> transactions,String name)
    {


        List a=new ArrayList<>();
        for (int i = 0; i < transactions.size(); i++) {
            System.out.println(i);
            if(transactionRepository.findByIdAndFormname(transactions.get(i).getId(),name).size()>0)
                a.addAll(transactionRepository.findByIdAndFormname(transactions.get(i).getId(),name));
        }

        System.out.println(a.size());
        return a;
    }
}
