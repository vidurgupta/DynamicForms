package com.example.Form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by vidur on 17/8/16.
 */
@RestController
public class FormController {
    @Autowired
    FormService formService;

    @RequestMapping(value="/createForm",method= RequestMethod.POST)
    ResponseEntity<?> createForms(@RequestBody Forms form)
    {
        if(formService.createForm(form)==true)

        return new ResponseEntity<>(form, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

    }
    @RequestMapping(value="/getForm",method= RequestMethod.GET)
    ResponseEntity<?> showform()
    {
        if(formService.showForm()!=null)
        return new ResponseEntity<>(formService.showForm(), HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

    }



}
