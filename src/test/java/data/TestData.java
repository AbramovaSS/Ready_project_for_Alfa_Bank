package data;

import com.github.javafaker.Faker;

import java.util.Locale;


public class TestData {

    Faker faker = new Faker(new Locale("en"));

    public String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            numberPhone = faker.phoneNumber().subscriberNumber(10);
}