package code;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class InterfazArco extends JFrame {

    JPanel pp, pd, pi, header, pM, pX;
    static JComboBox metodo, colores, relleno;//, escala;
    static JTextField[] tf = new JTextField[5];
    JTable t;
    static DefaultTableModel dtm;
    JScrollPane sP;
    JLabel xo, yo, r, ang, color, cR, radio, title1, title2;
    JButton graficar, menu;
    static boolean y;

    public InterfazArco() {
        pp = new JPanel();
        pd = new JPanel();
        pi = new JPanel();
        pM = new JPanel();
        pX = new JPanel();
        header = new JPanel();
        header.setBackground(Color.WHITE);
        Font f = new Font("Serif", Font.BOLD, 18);
        title1 = new JLabel("Graficación Básica por Computadora");
        title1.setHorizontalAlignment(SwingConstants.CENTER);
        title1.setFont(f);
        Font f2 = new Font("Serif", Font.BOLD, 16);
        title2 = new JLabel("Figuras Geometricas Simples: Arco");
        title2.setFont(f2);
        title2.setHorizontalAlignment(SwingConstants.CENTER);
        header.setLayout(new GridLayout(2, 0));
        header.add(title1);
        header.add(title2);

//        String[] m = {"Poligonal", "Trigonométrico"};
//        metodo = new JComboBox(m);
//        metodo.setPreferredSize(new Dimension(120, 30));
//        metodo.addItemListener(new ItemListener() {
//            @Override
//            public void itemStateChanged(ItemEvent ie) {
//                if (metodo.getSelectedIndex() == 1) {
//                    r.setText("r");
//                    xo.setText("X1");
//                    yo.setText("X2");
//                    ang.setVisible(false);
//                    radio.setVisible(false);
//                    tf[3].setVisible(false);
//                    tf[4].setVisible(false);
//                } else {
//                    r.setText("θ inicial");
//                    xo.setText("Xo");
//                    yo.setText("Yo");
//                    ang.setVisible(true);
//                    radio.setVisible(true);
//                    tf[3].setVisible(true);
//                    tf[4].setVisible(true);
//                }
//            }
//        });
        JPanel pCB = new JPanel();
        pCB.add(new JLabel("Método Polinomial"));
        //pCB.add(metodo);
        String[] c = {"Negro", "Rojo", "Azul", "Amarillo", "Verde", "Magenta", "Rosa", "Naranja"};
        colores = new JComboBox(c);
        String[] re = {"Vacio", "Color"};
        relleno = new JComboBox(re);

        for (int i = 0; i < tf.length; i++) {
            tf[i] = new JTextField(5);
        }

        xo = new JLabel("Xo");
        yo = new JLabel("Yo");
        r = new JLabel("θ inicial");
        ang = new JLabel("θ final");
        radio = new JLabel("Radio");
        color = new JLabel("Color");
        cR = new JLabel("Relleno");

        graficar = new JButton("Graficar");
        graficar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                evtAceptar();
            }
        });
        menu = new JButton("Menu");
        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                InterfazArco.this.setVisible(false);
            }
        });

        String[] tm = {"Punto", "X", "Y"};
        dtm = new DefaultTableModel(tm, 8);
        t = new JTable(dtm);
        sP = new JScrollPane(t);
        sP.setPreferredSize(new Dimension(200, 160));

        add(pp);
        pp.setLayout(new BorderLayout());
        pp.add(header, BorderLayout.NORTH);
        pp.add(pi, BorderLayout.WEST);
        pp.add(pd, BorderLayout.CENTER);

        pi.setLayout(new BoxLayout(pi, BoxLayout.Y_AXIS));
        pi.add(pCB);
        pi.add(pM);
        pi.add(pX);

        pd.add(new LienzoArco());

        panelParametros();
        panelX();

        design();
    }

    public void panelParametros() {
        pM.setBorder(BorderFactory.createTitledBorder("Parametros"));

        JPanel pM1 = new JPanel();
        pM1.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        pM1.add(xo, gbc);
        gbc.gridx = 1;
        pM1.add(yo, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        pM1.add(tf[0], gbc);
        gbc.gridx = 1;
        pM1.add(tf[1], gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        pM1.add(radio, gbc);
        gbc.gridy = 4;
        pM1.add(tf[4], gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        pM1.add(r, gbc);
        gbc.gridx = 3;
        pM1.add(ang, gbc);
        gbc.gridx = 2;
        gbc.gridy = 1;
        pM1.add(tf[2], gbc);
        gbc.gridx = 3;
        pM1.add(tf[3], gbc);
        pM.add(pM1);
//        pM.add(pM2);
    }

    public void panelX() {
        pX.setBorder(BorderFactory.createTitledBorder(""));
        pX.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        pX.add(color, gbc);
        gbc.gridx = 1;
        pX.add(cR, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        pX.add(colores, gbc);
        gbc.gridx = 1;
        pX.add(relleno, gbc);
        gbc.gridx = 9;
        gbc.gridy = 18;
        pX.add(menu, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
//        pX.add(sP, gbc);
        gbc.gridx = 0;
        gbc.gridy = 18;
        pX.add(graficar, gbc);
    }

    public void evtAceptar() {
        pd.removeAll();
        y = true;
        pd.add(new LienzoArco());
        y = false;
    }

    public void design() {
        UIManager.LookAndFeelInfo apariencias[] = UIManager.getInstalledLookAndFeels();
        try {
            UIManager.setLookAndFeel(apariencias[1].getClassName());
            SwingUtilities.updateComponentTreeUI(this);

        } catch (Exception excepcion) {
            excepcion.printStackTrace();
        }
    }

    public void frame() {
        this.setVisible(true);
        this.setBounds(200, 20, 940, 660);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setResizable(false);
    }

//    public static void main(String[] args) {
//        InterfazArco w = new InterfazArco();
//        w.setVisible(true);
//        w.setBounds(200, 20, 940, 660);
//        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////        w.setResizable(false);
//    }

}
