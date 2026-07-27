package com.andres.course.agy.springboot.cinemamcpclient.app.config;

import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.beans.factory.ObjectProvider;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class AIConfigTest {

    @Test
    void chatClient_ShouldRegisterToolCallbackProviderWhenAvailable() {
        AIConfig aiConfig = new AIConfig();
        ChatClient.Builder builder = mock(ChatClient.Builder.class);
        ChatClient mockChatClient = mock(ChatClient.class);
        ToolCallbackProvider callbackProvider = mock(ToolCallbackProvider.class);

        @SuppressWarnings("unchecked")
        ObjectProvider<ToolCallbackProvider> objectProvider = mock(ObjectProvider.class);

        given(builder.defaultTools(any(ToolCallbackProvider.class))).willReturn(builder);
        given(builder.build()).willReturn(mockChatClient);

        org.mockito.Mockito.doAnswer(invocation -> {
            java.util.function.Consumer<ToolCallbackProvider> consumer = invocation.getArgument(0);
            consumer.accept(callbackProvider);
            return null;
        }).when(objectProvider).ifAvailable(any());

        ChatClient chatClient = aiConfig.chatClient(builder, objectProvider);

        assertNotNull(chatClient);
        verify(builder).defaultTools(callbackProvider);
        verify(builder).build();
    }

}
