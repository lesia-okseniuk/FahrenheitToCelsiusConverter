package main;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    private void run() {
        Scanner in = new Scanner(System.in);
        double fahrenheit = in.nextDouble();

        Converter converter = new Converter();
        double celsius = converter.convertFahrenheitToCelsius(fahrenheit);
        System.out.println(celsius);
    }
}
