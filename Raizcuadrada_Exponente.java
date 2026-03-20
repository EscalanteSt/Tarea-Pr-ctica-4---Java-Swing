/**
 * Starlyn Escalante 2025-1089
 * Maneja el cálculo de la raíz cuadrada y el exponente.
 */
public class Raizcuadrada_Exponente {

    public double calcularRaiz(double numero) throws IllegalArgumentException {
        if (numero < 0) {
            throw new IllegalArgumentException("Error: Raíz de número negativo.");
        }
        return Math.sqrt(numero);
    }

    public double calcularExponente(double base, double exponente) {
        return Math.pow(base, exponente);
    }
}
