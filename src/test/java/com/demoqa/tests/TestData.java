package com.demoqa.tests;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.OptionalInt;
import java.util.Random;

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
            userSubject1 = "Maths",
            userSubject2 = "English",
            userSubject3 = "Computer Science",
            expectedSubjects =  format("%s, %s, %s", userSubject1, userSubject2, userSubject3),
            hobbies1 = "Sports",
            hobbies2 = "Reading",
            uploadFile = "Picture test_file.png",
            currentAddress = "Kaluga",
            state  = "NCR",
            city = "Noida";


    public static   String generateRandomMonth() {
        Random random = new Random();
        OptionalInt randomNumberMonth = random.ints(1, 12).findFirst();
        return Month.of(randomNumberMonth.getAsInt()).getDisplayName(TextStyle.FULL, Locale.US);

    }

}
