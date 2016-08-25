package com.example.RecordValues;

import com.example.Form.Forms;
import com.example.Transaction.Transaction;
import com.example.Transaction.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by vidur on 17/8/16.
 */
@RestController
public class AttributeValueController {
    @Autowired
    AttributeValueService attributeValueService;
   /* @RequestMapping(value="/insertRecord",method= RequestMethod.POST)
    ResponseEntity<?> insertValues(@RequestBody List<AttributeValue> attributeValues)
    {
            attributeValueService.createRecord(attributeValues);
            return new ResponseEntity<>(attributeValueService.createRecord(attributeValues), HttpStatus.OK);
    }*/




}
