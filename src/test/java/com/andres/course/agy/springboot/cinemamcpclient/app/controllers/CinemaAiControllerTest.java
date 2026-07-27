package com.andres.course.agy.springboot.cinemamcpclient.app.controllers;

import com.andres.course.agy.springboot.cinemamcpclient.app.services.CinemaAiService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CinemaAiController.class)
class CinemaAiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private CinemaAiService cinemaAiService;

    @Test
    void ask_ShouldReturnResponseFromService() throws Exception {
        String question = "¿Qué películas hay hoy?";
        String expectedAnswer = "Las películas de hoy son: Matrix y Avatar.";

        given(cinemaAiService.ask(question)).willReturn(expectedAnswer);

        mockMvc.perform(get("/api/cinema/ask").param("q", question))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedAnswer));
    }

}
