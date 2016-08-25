package com.example.Attribute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vidur on 16/8/16.
 */
@Service
public class AttributeService {
    @Autowired
    AttributeRepository attributeRepository;

    @Transactional
    boolean create(List<Attribute> attributes)
    {

        for (int i = 0; i < attributes.size(); i++) {
            System.out.println(attributes.get(i));
            if(attributeRepository.findByLabelAndFormname(attributes.get(i).getlabel(),attributes.get(i).getformname())!=null)
                return false;
            attributeRepository.save(attributes.get(i));

        }
        return true;

    }
    @Transactional
    List<Attribute> giveAttributes(Attribute attribute)
    {
        if(attributeRepository.findByFormname(attribute.getformname()).size()>0)
       return attributeRepository.findByFormname(attribute.getformname());

        return null;
    }
}
