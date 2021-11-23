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

public class InterfazElipse extends JFrame {

    JPanel pp, pd, pi, header, pM, pX;
    static JComboBox metodo, colores, relleno;//, escala;
    static JTextField[] tf = new JTextField[5];
    JTable t;
    static DefaultTableModel dtm;
    JScrollPane sP;
    JLabel xo, yo, a, b,ang, color, cR;
    JButton graficar, menu;
    static boolean y;
    JLabel title1, title2;

    public InterfazElipse() {
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
        title2 = new JLabel("Figuras Geometricas Simples: Elipse");
        title2.setFont(f2);
        title2.setHorizontalAlignment(SwingConstants.CENTER);
//        Font f3 = new Font("Serif", Font.BOLD, 14);
//        title3 = new JLabel("Circulo");
//        title3.setFont(f3);
//        title3.setHorizontalAlignment(SwingConstants.CENTER);
        header.setLayout(new GridLayout(2, 0));
        header.add(title1);
        header.add(title2);

        String[] m = {"Poligonal", "Trigonométrico"};
        metodo = new JComboBox(m);
        metodo.setPreferredSize(new Dimension(120, 30));
        metodo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                if (metodo.getSelectedIndex() == 1) {
                    ang.setVisible(true);
                    tf[4].setVisible(true);
//                    String[] n={"Punto","r","0"};
//                    dtm.setColumnIdentifiers(n);
                }
                else{
                    ang.setVisible(false);
                    tf[4].setVisible(false);
//                    String[] n={"Punto","X","Y"};
//                    dtm.setColumnIdentifiers(n);
                }
            }
        });
        JPanel pCB = new JPanel();
        pCB.add(new JLabel("Método:"));
        pCB.add(metodo);
        String[] c = {"Negro", "Rojo", "Azul", "Amarillo", "Verde", "Magenta", "Rosa", "Naranja"};
        colores = new JComboBox(c);
        String[] re = {"Vacio", "Color"};
        relleno = new JComboBox(re);

        for (int i = 0; i < tf.length; i++) {
            tf[i] = new JTextField(5);
        }

        xo = new JLabel("h");
        yo = new JLabel("k");
        a = new JLabel("a");
        b = new JLabel("b");
        color = new JLabel("Color");
        cR = new JLabel("Relleno");
        ang=new JLabel("Ang.");

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
                InterfazElipse.this.setVisible(false);
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

        pd.add(new LienzoElipse());

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

        gbc.gridx = 2;
        gbc.gridy = 0;
        pM1.add(a, gbc);
        gbc.gridx = 3;
        pM1.add(b, gbc);
        gbc.gridx = 2;
        gbc.gridy = 1;
        pM1.add(tf[2], gbc);
        gbc.gridx = 3;
        pM1.add(tf[3], gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        pM1.add(ang, gbc);
        ang.setVisible(false);
        gbc.gridy = 3;
        pM1.add(tf[4], gbc);
        tf[4].setVisible(false);
        pM.add(pM1);
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
        pd.add(new LienzoElipse());
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
        this.setBounds(200, 0, 970, 730);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setResizable(false);
    }

//    public static void main(String[] args) {
//        InterfazElipse w = new InterfazElipse();
//        w.setVisible(true);
//        w.setBounds(200, 0, 970, 730);
//        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////        w.setResizable(false);
//    }

}
