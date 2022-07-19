package ru.ufa;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

public class MainTest {
    private static long suiteStartTime;
    private long testStartTime;

    @BeforeAll
    public static void initSuite() {
        System.out.println("Running All Tests");
        suiteStartTime = System.nanoTime();
    }

    @AfterAll
    public static void completeSuite() {
        System.out.println("All Tests completed in time: " + (System.nanoTime() - suiteStartTime));
    }

    @BeforeEach
    public void initTest() {
        System.out.println("Starting new test");
        testStartTime = System.nanoTime();
    }

    @AfterEach
    public void finalizeTest() {
        System.out.println("Test complete in time: " + (System.nanoTime() - testStartTime));
    }

    @org.junit.jupiter.api.Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @ParameterizedTest
    @MethodSource("methodSource")
    public void checkInputTest(String a, boolean expectedResult) {
        boolean result = Main.checkInput(a);
        Assertions.assertEquals(expectedResult, result);
    }

    public static Stream<Arguments> methodSource() {
        return Stream.of(
                Arguments.of("2 11", true),
                Arguments.of("Bella", false),
                Arguments.of("Bella", false),
                Arguments.of("0 12", true),
                Arguments.of("Birka Kirka", true)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"БиЗнЕс", "102/", "14,", "1 6"})
    public void getIntValueTest(String argument) {
        assertTrue(Main.getIntValue(argument) == -1);
    }
}