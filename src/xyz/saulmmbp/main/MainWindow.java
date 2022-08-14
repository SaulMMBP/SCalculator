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
        
        /* Configuraciones */
        textfield.setBackground(Color.YELLOW);
        textfield.setEditable(false);
        textfield.setHorizontalAlignment(JTextField.RIGHT);
        textfield.setFont(font);
        
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
        btnMinus.setText("-");
        btnTimes.setText("x");
        btnDividedBy.setText("/");
        btnEquals.setText("=");
        
        btnDot.setText(".");
        btnPorcent.setText("%");
        
        btnC.setText("C");
        btnCE.setText("CE");
        
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
    
    public void digitActionPerformed(ActionEvent event) {
        /* obtener la fuente del evento */
        JButton button = (JButton) event.getSource();
        
        /* asignar el texto al campo de texto */
        textfield.setText(textfield.getText() + button.getText());
    }
    
}
