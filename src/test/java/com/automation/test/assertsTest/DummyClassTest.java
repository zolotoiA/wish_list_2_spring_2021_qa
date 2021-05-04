package com.automation.test.assertsTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class DummyClassTest {
    @DisplayName("Check that asserts are working")
    @Test
    void checkAsserts() {
        int expectedResult = -1;
        int actualResult = DummyClass.doDummyJob(0, -1);
        assertThat("Hello world", actualResult, is(expectedResult));
    }
}