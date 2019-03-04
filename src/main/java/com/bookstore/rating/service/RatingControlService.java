package com.bookstore.rating.service;

public interface RatingControlService {

    Boolean canUserReadBook(String userControlLevel, String bookID)throws Exception;
}
