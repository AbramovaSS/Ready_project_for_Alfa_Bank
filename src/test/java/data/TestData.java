package data;

import com.github.javafaker.Faker;

import java.util.Locale;


public class TestData {

    Faker faker = new Faker(new Locale("en"));

    public String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            numberPhone = faker.phoneNumber().subscriberNumber(10);

    public static final String HINT_EMPTY = "Это обязательное поле";

    public static final String HINT_INVALID = "Некорректное значение";

    public static final String EMAIL = "рус@домен.рф";

    public static final String HINT_CONFIRMATION = "Подтвердите номер телефона";

    public static final String VALUE_VACANCY = "QA";

    public static final String TAG = "Тестирование";

    public static final String PAGE_TITLE = "Полезные статьи о карьере в Альфа‑Банке";

}