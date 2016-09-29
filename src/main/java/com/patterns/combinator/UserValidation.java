package com.patterns.combinator;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.patterns.combinator.ValidationResult.invalid;
import static com.patterns.combinator.ValidationSupport.valid;

/**
 * Comment here about the class
 * User: Fizal
 * Date: 9/28/2016
 * Time: 8:56 PM
 */
interface UserValidation extends Function<User, ValidationResult> {
    static UserValidation nameIsNotEmpty() {
        return holds(user -> !user.name.trim().isEmpty(), "Name is empty");
    }

    static UserValidation eMailContainsAtSign() {
        return holds(user -> user.email.contains("@"), "Missing @-sign");
    }

    static UserValidation holds(Predicate<User> p, String message) {
        return user -> p.test(user) ? valid() : invalid(message);
    }

    default UserValidation and(UserValidation other) {
        return user -> {
            final ValidationResult result = this.apply(user);
            return result.isValid() ? other.apply(user) : result;
        };
    }

    static UserValidation all(final UserValidation... validations) {
        return user -> {

            final String reasons = Arrays.stream(validations)
                    .map(x -> x.apply(user))
                    .filter(x -> !x.isValid())
                    .collect(Collectors.toList())
                    .stream()
                    .map(ValidationResult::getReason)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.joining(", "));

            return reasons.length() == 0 ? valid() : new Invalid(reasons);
        };
    }
}