package com.example;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.PrintWriter;
import java.io.StringWriter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.Test;

class HelloServletTest {

    @Test
    void doGetReturnsExpectedHtmlResponse() throws Exception {
        // Arrange
        HelloServlet servlet = new HelloServlet();

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);

        when(response.getWriter()).thenReturn(printWriter);

        // Act
        servlet.doGet(request, response);
        printWriter.flush();

        String html = stringWriter.toString();

        // Assert
        verify(response).setContentType("text/html;charset=UTF-8");

        assertTrue(
            html.contains("Java CI/CD Pipeline v4 is Working!"),
            "Response should contain the expected application heading"
        );

        assertTrue(
            html.contains("Deployed using Jenkins, Maven, Docker and AWS."),
            "Response should contain the deployment description"
        );
    }
}
