import javax.swing.*;
import java.awt.*;

/**
 * Interfaz gráfica principal con Java Swing.
 */
public class Main extends JFrame {

    private JTextField txtValor1, txtValor2, txtResultado;
    private Calculadora calc;
    private ConversorTemperatura conversor;
    private Raizcuadrada_Exponente avanzadas;

    public Main() {
        calc = new Calculadora();
        conversor = new ConversorTemperatura();
        avanzadas = new Raizcuadrada_Exponente();

        setTitle("Calculadora Extendida y Conversor");
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel panelEntradas = new JPanel(new GridLayout(3, 2, 5, 5));
        panelEntradas.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        panelEntradas.add(new JLabel("Valor 1 (Base / °C / °F):"));
        txtValor1 = new JTextField();
        panelEntradas.add(txtValor1);

        panelEntradas.add(new JLabel("Valor 2 (Exponente / Num 2):"));
        txtValor2 = new JTextField();
        panelEntradas.add(txtValor2);

        panelEntradas.add(new JLabel("Resultado:"));
        txtResultado = new JTextField();
        txtResultado.setEditable(false);
        txtResultado.setBackground(Color.WHITE);
        panelEntradas.add(txtResultado);

        add(panelEntradas, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel(new GridLayout(4, 2, 5, 5));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton btnSumar = new JButton("+ Sumar");
        JButton btnRestar = new JButton("- Restar");
        JButton btnMultiplicar = new JButton("x Multiplicar");
        JButton btnDividir = new JButton("÷ Dividir");
        JButton btnRaiz = new JButton("√ Raíz (Valor 1)");
        JButton btnExp = new JButton("^ Exponente");
        JButton btnCaF = new JButton("°C a °F (Valor 1)");
        JButton btnFaC = new JButton("°F a °C (Valor 1)");

        panelBotones.add(btnSumar);
        panelBotones.add(btnRestar);
        panelBotones.add(btnMultiplicar);
        panelBotones.add(btnDividir);
        panelBotones.add(btnRaiz);
        panelBotones.add(btnExp);
        panelBotones.add(btnCaF);
        panelBotones.add(btnFaC);

        add(panelBotones, BorderLayout.CENTER);

        btnSumar.addActionListener(e -> procesar("+"));
        btnRestar.addActionListener(e -> procesar("-"));
        btnMultiplicar.addActionListener(e -> procesar("*"));
        btnDividir.addActionListener(e -> procesar("/"));
        btnRaiz.addActionListener(e -> procesar("raiz"));
        btnExp.addActionListener(e -> procesar("exp"));
        btnCaF.addActionListener(e -> procesar("caf"));
        btnFaC.addActionListener(e -> procesar("fac"));
    }

    private void procesar(String operacion) {
        try {
            double v1 = Double.parseDouble(txtValor1.getText());
            double v2 = 0;
            
            if (!operacion.equals("raiz") && !operacion.equals("caf") && !operacion.equals("fac")) {
                v2 = Double.parseDouble(txtValor2.getText());
            }

            double resultado = 0;

            switch (operacion) {
                case "+": resultado = calc.sumar(v1, v2); break;
                case "-": resultado = calc.restar(v1, v2); break;
                case "*": resultado = calc.multiplicar(v1, v2); break;
                case "/": resultado = calc.dividir(v1, v2); break;
                case "raiz": resultado = avanzadas.calcularRaiz(v1); break;
                case "exp": resultado = avanzadas.calcularExponente(v1, v2); break;
                case "caf": resultado = conversor.celsiusAFahrenheit(v1); break;
                case "fac": resultado = conversor.fahrenheitACelsius(v1); break;
            }

            txtResultado.setText(String.format("%.4f", resultado));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingresa valores numéricos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error Matemático", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main().setVisible(true));
    }
}
