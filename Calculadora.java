/**
 * Starlyn Escalante 20251-1089
 * Maneja las operaciones aritméticas básicas y validación de división.
 */
public class Calculadora {

    public double sumar(double a, double b) {
        return a + b;
    }

    public double restar(double a, double b) {
        return a - b;
    }

    public double multiplicar(double a, double b) {
        return a * b;
    }

    /**
     * Divide y evalúa con un IF que el divisor no sea cero.
     */
    public double dividir(double a, double b) throws IllegalArgumentException {
        if (b == 0) {
            throw new IllegalArgumentException("Error: No se puede dividir entre cero.");
        }
        return a / b;
    }
}
