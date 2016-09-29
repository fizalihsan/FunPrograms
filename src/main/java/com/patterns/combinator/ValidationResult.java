package com.patterns.combinator;

import java.util.Optional;

/**
 * Comment here about the class
 * User: Fizal
 * Date: 9/28/2016
 * Time: 8:57 PM
 */
interface ValidationResult {
    static ValidationResult valid() {
        return ValidationSupport.valid();
    }

    static ValidationResult invalid(String reason) {
        return new Invalid(reason);
    }

    boolean isValid();

    Optional<String> getReason();
}