package main;

public class Converter {
    private static final double ABSOLUTE_ZERO = -459.67;

    public double convertFahrenheitToCelsius(double fahrenheit) {
        if(fahrenheit < ABSOLUTE_ZERO) {
            throw new IllegalArgumentException("error data");
        }
        return (fahrenheit-32)/1.8;
    }

    public boolean checkFahrenheit(double fahrenheit) {
        return fahrenheit >= ABSOLUTE_ZERO;
    }

}
