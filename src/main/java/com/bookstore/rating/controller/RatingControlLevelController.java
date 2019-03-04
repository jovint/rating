package com.bookstore.rating.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RatingControlLevelController {

    @GetMapping("/getdecision/{userControlLevel}/{bookID}")
    public ResponseEntity<Boolean> getAccessDecision(
            @PathVariable String userControlLevel, @PathVariable String bookID)throws Exception{

        if( !validateUserControlLevel(userControlLevel) ||
         !validateBookID(bookID))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);


        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    public Boolean validateUserControlLevel(String userControlLevel){

        return userControlLevel.matches(".*\\d+.*");

    }

    public Boolean validateBookID(String bookID){

        return bookID.matches("[a-zA-Z0-9]*");

    }
}
