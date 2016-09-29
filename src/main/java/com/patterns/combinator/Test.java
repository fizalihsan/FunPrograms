package com.patterns.combinator;

import static com.patterns.combinator.UserValidation.eMailContainsAtSign;
import static com.patterns.combinator.UserValidation.nameIsNotEmpty;

/**
 * Comment here about the class
 * User: Fizal
 * Date: 9/28/2016
 * Time: 9:04 PM
 */
public class Test {
    public static void main(String[] args) {
        User user = new User("", 30, "");

        shortCircuitValidation(user);
        allValidation(user);
    }

    private static void shortCircuitValidation(User user) {
        UserValidation validation = nameIsNotEmpty().and(eMailContainsAtSign());

        ValidationResult result = validation.apply(user);
        result.getReason().ifPresent(System.out::println);
    }

    private static void allValidation(User user) {
        UserValidation validation = UserValidation.all(nameIsNotEmpty(), eMailContainsAtSign());

        ValidationResult result = validation.apply(user);
        result.getReason().ifPresent(System.out::println);
    }
}
