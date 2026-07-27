package com.andres.course.agy.springboot.cinemamcpclient.app;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {
    "spring.ai.mcp.client.enabled=false"
})
class ApplicationTests {

	@Test
	void contextLoads() {
	}

}
