package com.bookstore.rating.controller;

import com.bookstore.rating.service.RatingControlServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class RatingControlLevelControllerTest {

    private static final String bookId = "1234";
    private static final String userControlLevel = "8";

    @Mock
    private RatingControlServiceImpl ratingControlService;

    @InjectMocks
    private RatingControlLevelController ratingControlLevelController;



    @Test
    public void shouldInvokeRatingControlServiceImplcanUserReadBookMethod()throws Exception{

        verify(ratingControlService).canUserReadBook(userControlLevel, bookId);
    }


}
