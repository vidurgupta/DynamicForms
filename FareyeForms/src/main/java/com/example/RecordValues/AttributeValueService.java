package com.example.RecordValues;

import com.example.Transaction.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vidur on 16/8/16.
 */
@Service
public class AttributeValueService {
    @Autowired
    AttributeValueRepository attributeValueRepository;

    @Transactional
    boolean createRecord(List<AttributeValue> attributeValue)
    {
        for (int i = 0; i < attributeValue.size(); i++) {
            System.out.println(attributeValue.get(i));
            attributeValueRepository.save(attributeValue.get(i));
        }
        return true;

    }


}
