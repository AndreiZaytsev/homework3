package com.demoqa.tests;

import static java.lang.String.format;

public class TestData {

    static String firstName = "Andrey",
            lastName = "Zaytsev",
            expectedFullName =  format("%s %s", firstName, lastName),
            day = "01",
            month = "October",
            year = "2000",
            expectedDateOfBirth =  format("%s %s,%s", day, month, year),
            email = "test@example.com",
            gender = "Male",
            number = "9100000000",
            userSubject1 = "Math",
            userSubject2 = "English",
            userSubject3 = "Computer Science",
            expectedSubjects =  format("%s, %s, %s", userSubject1, userSubject2, userSubject3),
            hobbies1 = "Sports",
            hobbies2 = "Reading",
            uploadFile = "src/test/resources/test_file.png",
            currentAddress = "Kaluga",
            state  = "NCR",
            city = "Noida";
}
