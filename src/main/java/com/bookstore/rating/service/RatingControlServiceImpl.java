package com.bookstore.rating.service;


import org.springframework.stereotype.Service;

@Service
public class RatingControlServiceImpl  implements RatingControlService{

    @Override
    public Boolean canUserReadBook(String userControlLevel, String bookID) throws Exception {
        return null;
    }
}
