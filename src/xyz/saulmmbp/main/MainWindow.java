package xyz.saulmmbp.main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * Ventana principal del programa
 * @author SAUL
 *
 */
public class MainWindow extends JFrame{

    /**
     * 
     */
    private static final long serialVersionUID = 1963608110536701711L;

    private GridBagLayout esquema;
    private GridBagConstraints restricciones;
    
    private JTextField textfield;
    
    private JButton btn0;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btn4;
    private JButton btn5;
    private JButton btn6;
    private JButton btn7;
    private JButton btn8;
    private JButton btn9;
    
    private JButton btnPlus;
    private JButton btnMinus;
    private JButton btnTimes;
    private JButton btnDividedBy;
    private JButton btnEquals;
    
    private JButton btnDot;
    private JButton btnPorcent;
    
    private JButton btnC;
    private JButton btnCE;
    
    private Font font;
    
    private ActionListener digits;
    private ActionListener operations;
    
    private enum Entrada {NINGUNA, DIGITO, OPERADOR, CE };
    private Entrada ultimaEntrada;
    
    private boolean decimal;
    private char operator;
    
    private byte numOperandos;
    private double operando1;
    private double operando2;
    
    public MainWindow() {
        /* Configuraciones de ventana */
        setSize(240, 300);
        this.setResizable(false);
        setTitle("SCalculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        /* configuración de esquema */
        esquema = new GridBagLayout();
        setLayout(esquema);
        restricciones = new GridBagConstraints();
        
        /* inicialización de componentes */
        initComponents();
        
        /* Inicialización de otros elementos */
        ultimaEntrada = Entrada.NINGUNA;
        
        decimal = false;
        
        numOperandos = 0;
        operando1 = 0;
        operando2 = 0;
        
    }

    /**
     * Inicializa y configura los componentes
     */
    private void initComponents() {
        /* inicialización */
        textfield = new JTextField();
        
        btn0 = new JButton();
        btn1 = new JButton();
        btn2 = new JButton();
        btn3 = new JButton();
        btn4 = new JButton();
        btn5 = new JButton();
        btn6 = new JButton();
        btn7 = new JButton();
        btn8 = new JButton();
        btn9 = new JButton();
        
        btnPlus =  new JButton();
        btnMinus = new JButton();
        btnTimes = new JButton();
        btnDividedBy = new JButton();
        btnEquals = new JButton();
        
        btnDot = new JButton();
        btnPorcent = new JButton();
        
        btnC = new JButton();
        btnCE = new JButton();
        
        font = new Font("SansSerif", Font.BOLD, 14);
        
        digits = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                digitActionPerformed(event);
            }
        };
        
        operations = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                operationsActionPerformed(event);
            }
        };
        
        /* Configuraciones */
        textfield.setBackground(Color.YELLOW);
        textfield.setEditable(false);
        textfield.setHorizontalAlignment(JTextField.RIGHT);
        textfield.setFont(font);
        textfield.setText("0.");
        
        btn0.setText("0");
        btn0.addActionListener(digits);
        
        btn1.setText("1");
        btn1.addActionListener(digits);

        btn2.setText("2");
        btn2.addActionListener(digits);

        btn3.setText("3");
        btn3.addActionListener(digits);

        btn4.setText("4");
        btn4.addActionListener(digits);

        btn5.setText("5");
        btn5.addActionListener(digits);

        btn6.setText("6");
        btn6.addActionListener(digits);

        btn7.setText("7");
        btn7.addActionListener(digits);

        btn8.setText("8");
        btn8.addActionListener(digits);

        btn9.setText("9");
        btn9.addActionListener(digits);
        
        btnPlus.setText("+");
        btnPlus.addActionListener(operations);
        
        btnMinus.setText("-");
        btnMinus.addActionListener(operations);
        
        btnTimes.setText("x");
        btnTimes.addActionListener(operations);
        
        btnDividedBy.setText("/");
        btnDividedBy.addActionListener(operations);
        
        btnEquals.setText("=");
        btnEquals.addActionListener(operations);
        
        
        btnDot.setText(".");
        btnDot.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                decimalActionPerformed(event);
            }
        });
        
        btnPorcent.setText("%");
        btnPorcent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                porcentActionPerformed(event);
            }
        });
        
        
        btnC.setText("C");
        btnC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                cActionPerformed(event);
            }
        });
        
        btnCE.setText("CE");
        btnCE.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                ceActionPerformed(event);
            }
        });
        
        /* Posicionamiento en ventana */
        restricciones.weightx = 1000; // Se redimensiona en x
        restricciones.weighty = 1; // Se redimensiona en y
        restricciones.fill = GridBagConstraints.BOTH;
        addComponent(textfield, 0, 0, 5, 1);

        addComponent(btn0, 4, 0, 2, 1);
        addComponent(btn1, 3, 0, 1, 1);
        addComponent(btn2, 3, 1, 1, 1);
        addComponent(btn3, 3, 2, 1, 1);
        addComponent(btn4, 2, 0, 1, 1);
        addComponent(btn5, 2, 1, 1, 1);
        addComponent(btn6, 2, 2, 1, 1);
        addComponent(btn7, 1, 0, 1, 1);
        addComponent(btn8, 1, 1, 1, 1);
        addComponent(btn9, 1, 2, 1, 1);
        
        addComponent(btnPlus, 3, 4, 1, 1);
        addComponent(btnMinus, 2, 4, 1, 1);
        addComponent(btnTimes, 3, 3, 1, 1);
        addComponent(btnDividedBy, 2, 3, 1, 1);
        addComponent(btnEquals, 4, 3, 1, 1);
        
        addComponent(btnDot, 4, 2, 1, 1);
        addComponent(btnPorcent, 4, 4, 1, 1);
        
        addComponent(btnC, 1, 3, 1, 1);
        addComponent(btnCE, 1, 4, 1, 1);
        
    }

    /**
     * Método para establecer restricciones
     * @param componente
     * @param fila
     * @param columna
     * @param ancho
     * @param alto
     */
    public void addComponent(Component componente, int fila, int columna, int ancho, int alto) {
        /* Define las restricciones para el componente */
        /* Posición */
        restricciones.gridx = columna;
        restricciones.gridy = fila;
        
        /* Tamaño */
        restricciones.gridwidth = ancho;
        restricciones.gridheight = alto;
        
        /* Asigna las restricciones y agrega el componente a la ventana */
        esquema.setConstraints(componente, restricciones);
        add(componente);
    }
    
    /**
     * Método para escribir en pantalla los números 
     * @param event
     */
    public void digitActionPerformed(ActionEvent event) {
        /* obtener la fuente del evento */
        JButton button = (JButton) event.getSource();
        String text = button.getText();
        
        /* si la última entrada es diferente de un dígito y se ingresa un 0, no escribir nada */
        /* si la última entrada es diferente de un dígito, se setea el area a una cadena vacía y permite ingresar números */
        if (ultimaEntrada != Entrada.DIGITO) {
            if (text.compareTo("0") == 0) return;
            textfield.setText("");
            ultimaEntrada = Entrada.DIGITO;
            decimal = false;
        }
        
        /* asignar el texto al campo de texto */
        textfield.setText(textfield.getText() + text);
    }
    
    /**
     * Método que ingresa un punto decimal si no hay dígitos o también si los hay y establece que hay punto decimal,
     * también evita que se introduzcan más de un punto decimal
     * @param event
     */
    public void decimalActionPerformed(ActionEvent event) {
        if (ultimaEntrada != Entrada.DIGITO) { // Entra el punto si no hay dígitos
            textfield.setText("0.");
            ultimaEntrada = Entrada.DIGITO;
        } else if (!decimal) { // Entra el punto si hay dígitos, solo se permite un punto
            textfield.setText(textfield.getText() + ".");
        }
        decimal = true; // establece si hay punto decimal en la entrada
    }
    
    /**
     * Método que responde a los eventos de operación
     * @param event
     */
    public void operationsActionPerformed(ActionEvent event) {
        JButton button = (JButton) event.getSource();
        String text = button.getText();
        
        /* Caso cuando el primer operando es negativo, es decir, lo antecede un "-" */
        if ((numOperandos == 0) && (text.compareTo("-") == 0)) {
            ultimaEntrada = Entrada.DIGITO;
        }
        
        /* cuenta el número de operandos guardados */
        if (ultimaEntrada == Entrada.DIGITO) {
            numOperandos++;
        }
        
        /* almacena los operandos y realiza las operaciones */
        if (numOperandos == 1) {
            operando1 = Double.parseDouble(textfield.getText());
        } else if (numOperandos == 2) {
            operando2 = Double.parseDouble(textfield.getText());
            
            /* operaciones acumulativas y resultado se guarda en operador 1 */
            switch (operator) {
                case '+': 
                    operando1 += operando2;
                    break;
                case '-':
                    operando1 -= operando2;
                    break;
                case 'x':
                    operando1 *= operando2;
                    break;
                case '/':
                    operando1 /= operando2;
                    break;
                case '=':
                    operando1 = operando2;
                    break;
            }
            
            /* se muestra el resultado almacenado en operador1 */
            textfield.setText(Double.toString(operando1));
            
            /* se setea el numero de operadores a uno por si se requiere volver a utilizar */
            numOperandos = 1;
        }
        
        /* se resetea el operador */
        operator = text.charAt(0);
        
        /* se setea la última entrada como operador */
        ultimaEntrada = Entrada.OPERADOR;
    }
    
    /**
     * Método que responde a operaciones con porcentajes
     * @param event
     */
    public void porcentActionPerformed(ActionEvent event) {
        double resultado;
        if (ultimaEntrada == Entrada.DIGITO) {
            resultado = (operando1 * Double.parseDouble(textfield.getText())) / 100; // Obtiene el porcentaje especificado del operando 1 
            
            textfield.setText(Double.toString(resultado)); // muestra resultado en pantalla
            
            btnEquals.doClick(); // simula el botón '=' para obtener el resultado de la operación el porcentaje
            
            btnPorcent.requestFocus(); // Enfoca el botón de porcentaje
        }
    }
    
    /**
     * Método que reinicia todas las variables de la calculadora.
     * @param event
     */
    public void cActionPerformed(ActionEvent event) {
        textfield.setText("0.");
        ultimaEntrada = Entrada.NINGUNA;
        decimal = false;
        numOperandos = 0;
        operando1 = 0;
        operando2 = 0;
    }
    
    /**
     * Método que reinicia las variables que implican el último dígito introducido
     * @param event
     */
    public void ceActionPerformed(ActionEvent event) {
        textfield.setText("0.");
        ultimaEntrada = Entrada.CE;
        decimal = false;
    }
}
