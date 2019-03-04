package com.bookstore.rating.controller;


import com.bookstore.rating.RatingApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest(classes = RatingApplication.class)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class RatingControlLevelControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturn404_whenCustomerLevelAndBookIDIsNotProvided()throws Exception{

        mockMvc.perform(MockMvcRequestBuilders
                .get("/getdecision/")
        .accept("application/json")).
                andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void shouldReturnBadRequest_whenInvalidCustomerLevelAndValidBookIDIsProvided()throws Exception{

        mockMvc.perform(MockMvcRequestBuilders
                .get("/getdecision/A/1234")
                .accept("application/json")).
                andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void shouldReturnBadRequest_whenValidCustomerLevelAndInvalidBookIDIsProvided()throws Exception{

        mockMvc.perform(MockMvcRequestBuilders
                .get("/getdecision/8/1234@")
                .accept("application/json")).
                andExpect(MockMvcResultMatchers.status().isBadRequest());
    }


    @Test
    public void shouldReturnDecision_whenCustomerLevelAndBookIDIsProvided()throws Exception{

        mockMvc.perform(MockMvcRequestBuilders
                .get("/getdecision/8/1234")
                .accept("application/json")).
                andExpect(MockMvcResultMatchers.status().isOk());
    }



}
