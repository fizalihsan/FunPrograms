package com.patterns.combinator;

import java.util.Optional;

/**
 * Comment here about the class
 * User: Fizal
 * Date: 9/28/2016
 * Time: 9:00 PM
 */
public class ValidationSupport {
    private static final ValidationResult valid = new ValidationResult() {
        public boolean isValid() {
            return true;
        }

        public Optional<String> getReason() {
            return Optional.empty();
        }
    };

    static ValidationResult valid() {
        // since all valid results are indistinguishable,
        // the same instance can be reused to reduce garbage
        return valid;
    }
}

