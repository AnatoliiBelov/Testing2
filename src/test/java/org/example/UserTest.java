package org.example;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    public final String CORRECT_USER_LOGIN = "Anatoly";
    public final String CORRECT_USER_EMAIL = "anatoly@mail.com";
    private final String INCORRECT_EMAIL = "anatolymailcom";
    private final String INCORRECT_EMAIL_WITHOUT_DOG = "anatolymail.com";
    public final String INCORRECT_EMAIL_WITHOUT_POINT= "anatoly@mailcom";




    @Test
    public void checkUserConstructor() {
        User user5 = new User(CORRECT_USER_LOGIN, CORRECT_USER_EMAIL);
        assertEquals(CORRECT_USER_LOGIN, user5.getUserLogin());
        assertEquals(CORRECT_USER_EMAIL, user5.getUserEmail());
    }
    @ParameterizedTest
    @CsvSource(value ="Ekaterina, Ekaterina@mail.ru",ignoreLeadingAndTrailingWhitespace = true )
    public void checkUserConstructorWithParametrized(String userLogin, String userEmail){
        User user5 = new User(userLogin, userEmail);
        assertEquals(userLogin, user5.getUserLogin());
        assertEquals(userEmail, user5.getUserEmail());
    }
    @Test
    public void checkUserConstructorWithoutParametrized() {
        assertThrows(RuntimeException.class, User::new);

    }
    @Test
    public void shouldCorrectEmail() {

        assertThrows(RuntimeException.class,()->new User(CORRECT_USER_LOGIN, INCORRECT_EMAIL));

    }
    @Test
    public void shouldEmailWithPoint() {

        assertThrows(RuntimeException.class,()->new User(CORRECT_USER_LOGIN, INCORRECT_EMAIL_WITHOUT_POINT));

    }
    @Test
    public void shouldEmailWithDog() {

        assertThrows(RuntimeException.class,()->new User(CORRECT_USER_LOGIN, INCORRECT_EMAIL_WITHOUT_DOG));

    }
    @Test
    public void shouldEmailNotEqualsLogin() {

        assertThrows(RuntimeException.class,()->new User(CORRECT_USER_LOGIN, CORRECT_USER_LOGIN));

    }

}