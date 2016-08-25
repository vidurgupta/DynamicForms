package com.example.Form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vidur on 16/8/16.
 */
@Service
public class FormService {
    @Autowired
    FormRepository formRepository;

    @Transactional
    boolean createForm(Forms m)
    {
        if(formRepository.findByName(m.getName())==null)
        {
            System.out.print("hi");
            formRepository.save(m);
            return true;
        }
        System.out.print("bye");

        return false;

    }

    @Transactional
    List<Forms> showForm()
    {
        if(formRepository.findAll().size()>0)
            return formRepository.findAll();
      return null;
    }


}
