package code;

import java.awt.BorderLayout;
import java.awt.Canvas;
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
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

public class InterfazPuntos extends JFrame {

    JPanel pp, pi, pd, pt, header;
    static JTabbedPane tb;
    static JLabel title1, title2, title3;
    static JRadioButton CA, CR, PA, PR;
    ButtonGroup ca, po;
    static JComboBox cb, escala;
    static JTable t, tR, t2, t2R;
    static DefaultTableModel tm, tmR, ts, tsR;
    static boolean l, p;
    JButton menu;
    LienzoPuntos lz;

    public InterfazPuntos() {
        pp = new JPanel();
        pi = new JPanel();
        pd = new JPanel();
        pd.setPreferredSize(new Dimension(600, 600));
        header = new JPanel();
        pt = new JPanel();
        header = new JPanel();
        header.setBackground(Color.WHITE);
        Font f = new Font("Serif", Font.BOLD, 18);
        title1 = new JLabel("Graficación Básica por Computadora");
        title1.setHorizontalAlignment(SwingConstants.CENTER);
        title1.setFont(f);
        Font f2 = new Font("Serif", Font.BOLD, 16);
        title2 = new JLabel("Figuras Geometricas Compuestas: Puntos");
        title2.setFont(f2);
        title2.setHorizontalAlignment(SwingConstants.CENTER);
        Font f3 = new Font("Serif", Font.BOLD, 14);
        title3 = new JLabel("Coordenadas Cartesianas");
        title3.setFont(f3);
        title3.setHorizontalAlignment(SwingConstants.CENTER);

        header.setLayout(new GridLayout(3, 0));
        header.add(title1);
        header.add(title2);
        header.add(title3);

        CA = new JRadioButton("Absolutas");
        CA.setSelected(true);
        CR = new JRadioButton("Relativas");
        ca = new ButtonGroup();
        ca.add(CA);
        ca.add(CR);

        PA = new JRadioButton("Absolutas");
        PA.setSelected(true);
        PR = new JRadioButton("Relativas");
        po = new ButtonGroup();
        po.add(PA);
        po.add(PR);

        menu = new JButton("Menu");
        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                InterfazPuntos.this.setVisible(false);
            }
        });

        String[] c = {"Negro", "Rojo", "Azul", "Amarillo", "Verde", "Magenta", "Rosa", "Naranja"};
        cb = new JComboBox(c);
        cb.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                evtAceptar();
            }

        });
        JPanel pCB = new JPanel();
        String[] e = {"1:20", "1:40", "1:60"};
        escala = new JComboBox(e);
        pCB.add(new JLabel("Escala:"));
        pCB.add(escala);
        pCB.add(new JLabel("Color:"));
        pCB.add(cb);
        cb.setPreferredSize(new Dimension(130, 30));

        escala.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                evtAceptar();
            }

        });

        add(pp);
        pp.setLayout(new BorderLayout());
        pp.add(header, BorderLayout.NORTH);
        pp.add(pi, BorderLayout.WEST);
        pp.add(pd, BorderLayout.CENTER);
        pt = new JPanel();

        JPanel panelRadio = new JPanel();
        panelRadio.setLayout(new BoxLayout(panelRadio, BoxLayout.Y_AXIS));
        panelRadio.add(pCB);
        //pi.add(cb);

        CA.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                //datosTabla();
                evtAceptar();
            }
        });
        CR.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                //datosTabla();
                evtAceptar();
            }
        });
        PA.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                //datosTabla();
                evtAceptar();
            }
        });
        PR.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                //datosTabla();
                evtAceptar();
            }
        });

        panelTabla();

        pi.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        pi.add(panelRadio, gbc);
        gbc.gridy = 1;
        pi.add(pt, gbc);
        datosTabla();

        pd.add(new LienzoPuntos());

        design();
    }

    public void panelTabla() {
        //JTabbedPane
        String[] s = {"Puntos", "X", "Y", "Pixel X", "Pixel Y"};
        tm = new DefaultTableModel(s, 0);
        t = new JTable(tm);
        JScrollPane scrollPane = new JScrollPane(t);
        //scrollPane.setBorder(BorderFactory.createTitledBorder("Coordenadas Cartesianas Absolutas"));

        String[] s2 = {"Puntos", "X", "Y", "dX", "dY", "Pixel dX", "Pixel dY"};
        tmR = new DefaultTableModel(s2, 0);
        tR = new JTable(tmR);
        JScrollPane sR = new JScrollPane(tR);

        String[] x = {"Puntos", "r", "0"};
        ts = new DefaultTableModel(x, 0);
        t2 = new JTable(ts);
        JScrollPane r = new JScrollPane(t2);
        //r.setBorder(BorderFactory.createTitledBorder("Coordenadas Polares Absolutas"));

        String[] x2 = {"Puntos", "dr", "d0"};
        tsR = new DefaultTableModel(x2, 0);
        t2R = new JTable(tsR);
        JScrollPane rR = new JScrollPane(t2R);
        r.setPreferredSize(new Dimension(300, 180));
        rR.setPreferredSize(new Dimension(300, 180));
        scrollPane.setPreferredSize(new Dimension(300, 180));
        sR.setPreferredSize(new Dimension(300, 180));

        JPanel pt1 = new JPanel();
        pt1.add(CA);
        pt1.add(scrollPane);
        pt1.add(CR);
        pt1.add(sR);

        JPanel pt2 = new JPanel();
        pt2.add(PA);
        pt2.add(r);
        pt2.add(PR);
        pt2.add(rR);

        pt.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        tb = new JTabbedPane();
        tb.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
                if (CA.isSelected()) {
                    CA.setSelected(false);
                }
                if (CR.isSelected()) {
                    CR.setSelected(false);
                }
                if (PA.isSelected()) {
                    PA.setSelected(false);
                }
                if (PR.isSelected()) {
                    PR.setSelected(false);
                }

                evtAceptar();
            }
        });

        tb.setPreferredSize(new Dimension(300, 500));
        tb.addTab("Cartesianas", pt1);
        tb.addTab("Polares", pt2);

        gbc.gridx = 0;
        gbc.gridy = 0;
        pt.add(tb, gbc);
        gbc.gridy = 1;
        pt.add(menu, gbc);
        
    }

    public int escala() {
        int e = 0;
        if (escala.getSelectedIndex() == 0) {
            e = 20;
        }
        if (escala.getSelectedIndex() == 1) {
            e = 40;
        }
        if (escala.getSelectedIndex() == 2) {
            e = 60;
        }

        return e;
    }

    public void frame() {
        this.setVisible(true);
        this.setBounds(150, 20, 900, 750);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setResizable(false);
    }

//    public static void main(String[] args) {
//        InterfazPuntos w = new InterfazPuntos();
//        w.setVisible(true);
//        w.setBounds(150, 20, 900, 740);
//        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        w.setResizable(false);
//    }

    public void design() {
        UIManager.LookAndFeelInfo apariencias[] = UIManager.getInstalledLookAndFeels();
        try {
            UIManager.setLookAndFeel(apariencias[1].getClassName());
            SwingUtilities.updateComponentTreeUI(this);

        } catch (Exception excepcion) {
            excepcion.printStackTrace();
        }
    }

    public void evtAceptar() {
        pd.removeAll();
        datosTabla();
        pd.add(new LienzoPuntos());
        p = l = false;
    }


    public void datosTabla() {

        if (tm.getRowCount() > 0) {
            for (int i = 0; i < tm.getRowCount();) {
                tm.removeRow(i);
            }
        }

        String[] s = {"P1", (1 * 2) + "", (1 * 2) + "", "", ""};
        tm.addRow(s);
        String[] s2 = {"P2", (2 * 2) + "", (1 * 2) + "", "", ""};
        tm.addRow(s2);
        String[] s3 = {"P3", (3 * 2) + "", (1 * 2) + "", "", ""};
        tm.addRow(s3);
        String[] s4 = {"P4", (4 * 2) + "", (1 * 2) + "", "", ""};
        tm.addRow(s4);
        String[] s5 = {"P5", (5 * 2) + "", (1 * 2) + "", "", ""};
        tm.addRow(s5);
        String[] s6 = {"P6", (4 * 2) + "", (2 * 2) + "", "", ""};
        tm.addRow(s6);
        String[] s7 = {"P7", (3 * 2) + "", (2 * 2) + "", "", ""};
        tm.addRow(s7);
        String[] s8 = {"P8", (2 * 2) + "", (2 * 2) + "", "", ""};
        tm.addRow(s8);
        String[] s9 = {"P9", (3 * 2) + "", (3 * 2) + "", "", ""};
        tm.addRow(s9);

        for (int i = 0; i < tm.getRowCount(); i++) {
            int x = 30 + Integer.parseInt((String) tm.getValueAt(i, 1)) * escala();
            int y = 30 + Integer.parseInt((String) tm.getValueAt(i, 2)) * escala();
            tm.setValueAt(x + "", i, 3);
            tm.setValueAt(y + "", i, 4);
        }
        //Polares
        if (ts.getRowCount() > 0) {
            for (int i = 0; i < ts.getRowCount();) {
                ts.removeRow(i);
            }
        }
        for (int i = 0; i < tm.getRowCount(); i++) {
            float x = Integer.parseInt((String) tm.getValueAt(i, 1));
            float y = Integer.parseInt((String) tm.getValueAt(i, 2));
            String[] d = {"P" + (i + 1), (float) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)) * 20 + "", (float) Math.toDegrees(Math.atan((y / x))) + ""};
            ts.addRow(d);
        }
        datosRelativos();
    }

    public void datosRelativos() {
        //Cartesianas
        if (tmR.getRowCount() > 0) {
            for (int i = 0; i < tmR.getRowCount();) {
                tmR.removeRow(i);
            }
        }

        int a = Integer.parseInt((String) tm.getValueAt(0, 1));
        int b = Integer.parseInt((String) tm.getValueAt(0, 2));
        int c = Integer.parseInt((String) tm.getValueAt(0, 3));
        int d = Integer.parseInt((String) tm.getValueAt(0, 4));
        String[] z = {"P1", a + "", b + "", a + "", b + "", c + "", d + ""};
        tmR.addRow(z);

        for (int i = 1; i < tm.getRowCount(); i++) {
            int x1 = Integer.parseInt((String) tm.getValueAt(i - 1, 1));
            int x2 = Integer.parseInt((String) tm.getValueAt(i, 1));
            int y1 = Integer.parseInt((String) tm.getValueAt(i - 1, 2));
            int y2 = Integer.parseInt((String) tm.getValueAt(i, 2));
            int px1 = Integer.parseInt((String) tm.getValueAt(i - 1, 3));
            int px2 = Integer.parseInt((String) tm.getValueAt(i, 3));
            int py1 = Integer.parseInt((String) tm.getValueAt(i - 1, 4));
            int py2 = Integer.parseInt((String) tm.getValueAt(i, 4));
            String[] rc = {"P" + (i + 1), x2 + "", y2 + "", (x2 - x1) + "", (y2 - y1) + "", (px2 - px1) + "", (py2 - py1) + ""};
            tmR.addRow(rc);
        }
        //Polares
        if (tsR.getRowCount() > 0) {
            for (int i = 0; i < tsR.getRowCount();) {
                tsR.removeRow(i);
            }
        }
        for (int i = 0; i < tmR.getRowCount(); i++) {
            float x = Integer.parseInt((String) tmR.getValueAt(i, 3));
            float y = Integer.parseInt((String) tmR.getValueAt(i, 4));
            String[] m = {"P" + (i + 1), (float) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)) * 20 + "", (float) Math.toDegrees(Math.atan((y / x))) + "°"};
            tsR.addRow(m);
        }
    }
}
