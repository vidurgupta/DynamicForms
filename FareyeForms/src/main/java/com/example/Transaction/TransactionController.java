package com.example.Transaction;

import com.example.Form.Forms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by vidur on 19/8/16.
 */
@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;
    @RequestMapping(value="/insertTransaction",method = RequestMethod.POST)
    ResponseEntity<?> createFence(@RequestBody Transaction transaction)
    {

        return new ResponseEntity<>(transactionService.insertTransaction(transaction), HttpStatus.OK);

    }



    @RequestMapping(value="/displayRecord",method= RequestMethod.POST)
    ResponseEntity<?> displayValues(@RequestBody Forms forms)
    {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        System.out.println(forms.getName());

        return new ResponseEntity<>(transactionService.showRecord(transactionService.viewTransaction(userName),forms.getName()), HttpStatus.OK);

    }
}
