package com.patterns.combinator;

import java.util.Optional;

/**
 * Comment here about the class
 * User: Fizal
 * Date: 9/28/2016
 * Time: 8:58 PM
 */
class Invalid implements ValidationResult {

    private final String reason;

    Invalid(String reason) {
        this.reason = reason;
    }

    public boolean isValid() {
        return false;
    }

    public Optional<String> getReason() {
        return Optional.of(reason);
    }

    // equals and hashCode on field reason
}
