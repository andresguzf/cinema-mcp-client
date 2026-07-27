package com.andres.course.agy.springboot.cinemamcpclient.app.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ai.chat.client.ChatClient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class CinemaAiServiceTest {

    @Mock
    private ChatClient chatClient;

    @InjectMocks
    private CinemaAiService cinemaAiService;

    @Test
    void ask_ShouldInvokeChatClientAndReturnContent() {
        ChatClient.ChatClientRequestSpec requestSpec = mock(ChatClient.ChatClientRequestSpec.class);
        ChatClient.CallResponseSpec callSpec = mock(ChatClient.CallResponseSpec.class);

        given(chatClient.prompt()).willReturn(requestSpec);
        given(requestSpec.system(anyString())).willReturn(requestSpec);
        given(requestSpec.user(anyString())).willReturn(requestSpec);
        given(requestSpec.call()).willReturn(callSpec);
        given(callSpec.content()).willReturn("Respuesta de prueba sobre cine");

        String result = cinemaAiService.ask("¿Horarios hoy?");

        assertNotNull(result);
        assertEquals("Respuesta de prueba sobre cine", result);
    }

}
