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

public class InterfazLinDia extends JFrame {

    JPanel pp, header, pi, pd, pt;
    JLabel minX, minY, maxX, maxY, color;
    static JTextField[] tf = new JTextField[4];
    static JComboBox colores;
    JButton graficar, menu;
    JTable t;
    static DefaultTableModel dtm;
    JScrollPane sP;
    static boolean y = false;
    JLabel title1, title2;

    public InterfazLinDia() {
        super("Línea Horizontal");
        pp = new JPanel();
        pi = new JPanel();
        pd = new JPanel();
        pt = new JPanel();
        header = new JPanel();
        header.setBackground(Color.WHITE);
        Font f = new Font("Serif", Font.BOLD, 18);
        title1 = new JLabel("Graficación Básica por Computadora");
        title1.setHorizontalAlignment(SwingConstants.CENTER);
        title1.setFont(f);
        Font f2 = new Font("Serif", Font.BOLD, 16);
        title2 = new JLabel("Figuras Geometricas Simples: Línea Diagonal");
        title2.setFont(f2);
        title2.setHorizontalAlignment(SwingConstants.CENTER);
        header.setLayout(new GridLayout(2, 0));
        header.add(title1);
        header.add(title2);

        minX = new JLabel("Min X");
        minY = new JLabel("Min Y");
        maxX = new JLabel("Max X");
        maxY = new JLabel("Max Y");
        color = new JLabel("Color");

        for (int i = 0; i < tf.length; i++) {
            tf[i] = new JTextField(5);
        }

        String[] c = {"Negro", "Rojo", "Azul", "Amarillo", "Verde", "Magenta", "Rosa", "Naranja"};
        colores = new JComboBox(c);

        graficar = new JButton("Graficar");
        graficar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pd.removeAll();
                y = true;
                pd.add(new LinDiagonal());
                y = false;
            }
        });
        menu = new JButton("Menu");
        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                InterfazLinDia.this.setVisible(false);
            }
        });

        String dt[] = {"Punto", "X", "Y"};
        dtm = new DefaultTableModel(dt, 0);
        t = new JTable(dtm);
        sP = new JScrollPane(t);
        sP.setPreferredSize(new Dimension(200, 160));

        add(pp);
        pp.setLayout(new BorderLayout());
        pp.add(header, BorderLayout.NORTH);
        pp.add(pi, BorderLayout.WEST);
        pp.add(pd, BorderLayout.CENTER);

        panelIzq();
        pd.add(new LinDiagonal());

        design();
    }

    public void panelIzq() {
        pi.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        pi.add(minX, gbc);
        gbc.gridx = 1;
        pi.add(minY, gbc);
        gbc.gridx = 2;
        pi.add(maxX, gbc);
        gbc.gridx = 3;
        pi.add(maxY, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        pi.add(tf[0], gbc);
        gbc.gridx = 1;
        pi.add(tf[1], gbc);
        gbc.gridx = 2;
        pi.add(tf[2], gbc);
        gbc.gridx = 3;
        pi.add(tf[3], gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        pi.add(color, gbc);
        gbc.gridy = 3;
        pi.add(colores, gbc);
        gbc.gridy = 6;
        pi.add(graficar, gbc);
        gbc.gridx = 3;
        gbc.gridy = 6;
        pi.add(menu, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.BOTH;
        pi.add(sP, gbc);
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
//        InterfazLinDia w = new InterfazLinDia();
//        w.setVisible(true);
//        w.setBounds(200, 20, 940, 660);
//        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////        w.setResizable(false);
//    }

}
