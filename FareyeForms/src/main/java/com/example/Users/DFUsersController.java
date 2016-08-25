package com.example.Users;

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
 * Created by vidur on 16/8/16.
 */
@RestController
public class DFUsersController {

    @Autowired
    DFUsersService DFUsersService;

    @RequestMapping(value = "/getuser", method = RequestMethod.GET)
    ResponseEntity<?> givedetail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        DFUsers s = DFUsersService.giveuser(currentPrincipalName);

        ResponseEntity<?> responseEntity = new ResponseEntity<>(s, HttpStatus.OK);

        return responseEntity;


    }

    @RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
    ResponseEntity<?> giveUsers() {
        return new ResponseEntity<>(DFUsersService.giveAll(), HttpStatus.OK);
    }

    @RequestMapping(value="/createUser",method = RequestMethod.POST)
    ResponseEntity<?> createUser(@RequestBody DFUsers g){
        System.out.print("hi"+ DFUsersService.giveuser(g.getUsername()));
        if(DFUsersService.giveuser(g.getUsername())==null)
        {
            DFUsersService.insert(g);
            return new ResponseEntity<>(g,HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);

    }
}
