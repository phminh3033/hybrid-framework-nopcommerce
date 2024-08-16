import com.github.javafaker.Faker;

import java.util.Locale;

public class Topic_09_Faker {
    public static void main(String[] args) {
        Faker faker = new Faker(new Locale("vi"));
        System.out.println(faker.name().fullName());
        System.out.println(faker.address().streetAddress());
        System.out.println(faker.phoneNumber().cellPhone());
        System.out.println(faker.internet().emailAddress());
        System.out.println(faker.internet().password(6,8,true,true,true));
    }
}
