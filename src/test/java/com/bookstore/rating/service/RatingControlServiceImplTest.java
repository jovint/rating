package com.bookstore.rating.service;


import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(MockitoJUnitRunner.class)
public class RatingControlServiceImplTest {

    @Mock
    private RestTemplate restTemplate;

    private RatingControlServiceImpl ratingControlService;


}
