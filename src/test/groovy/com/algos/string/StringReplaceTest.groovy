package com.algos.string
/**
 * Comment here about the class
 * User: Fizal
 * Date: 7/11/2016
 * Time: 6:01 PM
 */
class StringReplaceTest /*extends Specification*/ {
    def "replaceAll - Replace 'a' with 'x' in 'abc'"() {
        when: def result = StringReplace.replaceAll("abc", 'a' as char, "x")
        then: result == "xbc"
    }

    def "replaceAll - Replace 'a' with 'x' in 'aaa'"() {
        when: def result = StringReplace.replaceAll("aaa", 'a' as char, "x")
        then: result == "xxx"
    }

    def "replaceAll - Replace 'a' with 'ab' in 'abc'"() {
        when: def result = StringReplace.replaceAll("abc", 'a' as char, "ab")
        then: result == "abbc"
    }

    def "replaceAll - Replace ' ' with '%20' in 'Hello World'"() {
        when: def result = StringReplace.replaceAll("Hello World", ' ' as char, "%20")
        then: result == "Hello%20World"
    }
}
