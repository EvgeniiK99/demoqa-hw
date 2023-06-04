package com.demoqa.tests;

import com.demoqa.pages.TextBoxPage;
import org.junit.jupiter.api.Test;

public class TextBoxTest extends TestBase{
        TextBoxPage textBoxPage = new TextBoxPage();
        String fullName = "Evgenii Klimashin",
                userEmail = "evgeniik@gmail.com",
                currentAddress = "94 Smith Ln Bunnell, Florida(FL), 32110",
                permanentAddress = "Canada 123";
    @Test
    void textBoxtest() {
        textBoxPage
                .openPage()
                .setFullName(fullName)
                .setEmail(userEmail)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .submit()
                .checkResult(fullName, userEmail, currentAddress, permanentAddress);

    }
}
