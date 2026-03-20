/**
 * Starlyn Escalante 2025-1089
 * Maneja las conversiones entre grados Celsius y Fahrenheit.
 */
public class ConversorTemperatura {

    public double fahrenheitACelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5.0 / 9.0;
    }

    public double celsiusAFahrenheit(double celsius) {
        return (celsius * 9.0 / 5.0) + 32;
    }
}
