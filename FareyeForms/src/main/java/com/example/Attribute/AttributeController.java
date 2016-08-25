package com.example.Attribute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by vidur on 17/8/16.
 */
@RestController
public class AttributeController {
    @Autowired
    AttributeService attributeService;

    @RequestMapping(value="/addAttribute",method = RequestMethod.POST)
    ResponseEntity<?> createFence(@RequestBody List<Attribute> attributes)
    {
        if (attributeService.create(attributes) && attributes.size()>0)

            return new ResponseEntity<>(null, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

    }

    @RequestMapping(value="/getFormAttribute",method = RequestMethod.POST)
    ResponseEntity<?> getFence(@RequestBody Attribute attribute)
    {
        if(attributeService.giveAttributes(attribute)!=null)
            return new ResponseEntity<>(attributeService.giveAttributes(attribute), HttpStatus.OK);

        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

    }

}
