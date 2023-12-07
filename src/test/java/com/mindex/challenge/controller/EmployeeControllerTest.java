package com.mindex.challenge.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = CompensationController.class)
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void getReports() throws Exception {
        mockMvc.perform(post("/employee").contentType("application/json").content(
                """
                {
                  "employeeId": "007",
                  "firstName": "Jacob",
                  "lastName": "Sakelarios",
                  "position": "Intern",
                  "department": "Insurance"
                }
                """))
                .andExpect(content().json("""
                                                            {
                                                              "firstName": "Jacob",
                                                              "lastName": "Sakelarios",
                                                              "position": "Intern",
                                                              "department": "Insurance"
                                                            }
                                                            """));
    }
}