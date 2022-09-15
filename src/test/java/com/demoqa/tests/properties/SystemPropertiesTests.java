package com.demoqa.tests.properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {

    @Test
    @Tag("properties")
    void simplePropertyTest() {
        String browserName = System.getProperty("browser_name", "firefox");
        String browserVersion = System.getProperty("browser", "101");
        String browserSize = System.getProperty("browser", "1920x1080");

        System.out.println(browserName);
        System.out.println(browserVersion);
        System.out.println(browserSize);
    }
}
