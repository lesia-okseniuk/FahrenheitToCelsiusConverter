package main;

import org.assertj.core.data.Percentage;
import org.testng.annotations.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;

public class ConverterTest {

    public final static double EPS = 0.001;

    Converter converter;

    @BeforeClass
    public void beforeClass() {
        converter = new Converter();
    }

    @AfterClass
    public void afterClass() {
        converter = null;
    }

    @DataProvider(name = "fahrenheit_12")
    public static Object[][] createData() {
        return new Object[][]{
                {-459, -272.77777777777777},
                {-300, -184.44444444444443},
                {-1, -18.333333333333332},
                {0, -17.77777777777778},
                {1, -17.22222222222222},
                {20, -6.666666666666666},
                {32, 0},
                {50, 10},
                {104, 40},
                {200.5, 93.61111111111111},
                {1000, 537.7777777777777},
                {100000, 55537.777777777774}
        };
    }

    @Test
    public void testConvertFahrenheitToCelsius() {
        double actual = converter.convertFahrenheitToCelsius(50.0);
        double expected = 10.0;
        assertEquals(actual, expected, EPS, "Test failed as...");
    }

    @Test
    public void testCheckFahrenheitFalse() {
        assertThat(converter.checkFahrenheit(-470))
                .as("test false failed as...")
                .isFalse();
    }

    @Test(enabled = true, expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "error data")
    public void testConverterFahrenheitToCelsiusException() {
        converter.convertFahrenheitToCelsius(-470);
    }

    @Test
    public void testConvertFahrenheitToCelsiusExceptionMessage() {
        double fahrenheit = -470.0;
        try {
            converter.convertFahrenheitToCelsius(fahrenheit);
            fail("Test for fahrenheit " + fahrenheit + "should have thrown a IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "error data");
        }
    }

    @Test(timeOut = 1000)
    public void testTime() {
        for (int t = -469; t < 1000000; t++) {
            converter.convertFahrenheitToCelsius(t);
    }}

    @Test(dataProvider = "fahrenheit_12")
    public void fahrenheit_12 (double fahrenheit, double expectedCelsius) {
        double actual = converter.convertFahrenheitToCelsius(fahrenheit);
        assertEquals(actual, expectedCelsius, EPS);
    }

    @Test
    public void testConvertFahrenheitToCelsiusVersion2() {
        assertThat(converter.convertFahrenheitToCelsius(50.0))
                .isCloseTo(10.0, Percentage.withPercentage(0.1));
    }
}