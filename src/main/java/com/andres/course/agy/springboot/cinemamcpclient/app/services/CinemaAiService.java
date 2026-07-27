package com.andres.course.agy.springboot.cinemamcpclient.app.services;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class CinemaAiService {

    private final ChatClient chatClient;

    public CinemaAiService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public String ask(String question) {
        return this.chatClient.prompt()
                .system("""
                        Eres un asistente virtual de cine experto.
                        Utiliza siempre las herramientas MCP disponibles para consultar la cartelera de películas, los horarios de transmisión y el público recomendado o clasificación.
                        Responde siempre de forma amigable y exclusivamente en español.
                        """)
                .user(question)
                .call()
                .content();
    }

}
