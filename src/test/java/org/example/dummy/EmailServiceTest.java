package org.example.dummy;

public class EmailServiceTest implements EmailService {
    @Override public void sendEmail(String message) {
        throw new AssertionError("Service not used");
    }
}
