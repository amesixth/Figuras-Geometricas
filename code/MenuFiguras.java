package code;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class MenuFiguras extends JFrame {

    JPanel pp, ps, pc, pS, pC, header;
    JLabel simp, comp, hor, ver, dia, cir, arc, elipse, puntos, pyl, cre;

    public MenuFiguras() {
        pp = new JPanel();
        pp.setBackground(Color.WHITE);
        ps = new JPanel();
        ps.setBackground(Color.WHITE);
        pc = new JPanel();
        pc.setBackground(Color.WHITE);
        pS = new JPanel();
        pS.setBackground(Color.WHITE);
        pC = new JPanel();
        pC.setBackground(Color.WHITE);

        Font t20 = new Font("Serif", 1, 20);
        Font t14 = new Font("Serif", 0, 16);

        header = new JPanel();
        header.setBackground(Color.WHITE);
        header.setLayout(new GridBagLayout());

        JLabel title1 = new JLabel("Graficación 2D por Computadora");
        title1.setFont(t20);
        title1.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel title2 = new JLabel("Graficación Básica por Computadora");
        title2.setFont(t20);
        title2.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel java = new JLabel(new ImageIcon(getClass().getResource("/images/conicas.png")));
        JLabel nB = new JLabel(new ImageIcon(getClass().getResource("/images/figPuntos.PNG")));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        header.add(new JLabel(new ImageIcon(getClass().getResource("/images/w.png"))), gbc);
        gbc.gridy = 4;
        header.add(java, gbc);
        gbc.gridx = 1;
        header.add(new JLabel(new ImageIcon(getClass().getResource("/images/w.png"))), gbc);
        gbc.gridx = 2;
        header.add(nB, gbc);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 5;
        header.add(title1, gbc);
        gbc.gridy = 1;
        header.add(title2, gbc);

        simp = new JLabel("1.-Simples");
        simp.setFont(t20);
        comp = new JLabel("2.-Compuestas");
        comp.setFont(t20);
        hor = new JLabel("-Línea Horizontal");
        hor.setFont(t14);
        hor.addMouseListener(new evtFocus());
        ver = new JLabel("-Línea Vertical");
        ver.setFont(t14);
        ver.addMouseListener(new evtFocus());
        dia = new JLabel("-Línea Diagonal");
        dia.setFont(t14);
        dia.addMouseListener(new evtFocus());
        cir = new JLabel("-Circulo");
        cir.setFont(t14);
        cir.addMouseListener(new evtFocus());
        arc = new JLabel("-Arco");
        arc.setFont(t14);
        arc.addMouseListener(new evtFocus());
        elipse = new JLabel("-Elipse");
        elipse.setFont(t14);
        elipse.addMouseListener(new evtFocus());
        puntos = new JLabel("-Puntos");
        puntos.setFont(t14);
        puntos.addMouseListener(new evtFocus());
        pyl = new JLabel("-Polilíneas");
        pyl.setFont(t14);
        pyl.addMouseListener(new evtFocus());
        cre = new JLabel("Creditos");
        cre.setFont(t14);
        cre.setIcon(new ImageIcon(getClass().getResource("/images/i.png")));
        cre.addMouseListener(new evtFocus());

        JPanel pc2 = new JPanel();
        add(pp);
        pp.setLayout(new BorderLayout());
        pp.add(header, BorderLayout.NORTH);
        pp.add(new JLabel("    "), BorderLayout.WEST);
        pp.add(pc2, BorderLayout.CENTER);
        pp.add(new JLabel("    "), BorderLayout.EAST);

        pc2.setLayout(new BoxLayout(pc2, BoxLayout.Y_AXIS));
        pc.setLayout(new GridLayout(0, 2));
        pS.setLayout(new BoxLayout(pS, BoxLayout.Y_AXIS));
        pC.setLayout(new BoxLayout(pC, BoxLayout.Y_AXIS));

        JPanel pB = new JPanel();
        pB.setBackground(Color.WHITE);
        JLabel menu = new JLabel("MENU");
        menu.setFont(t20);
        menu.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel fig = new JLabel("FIGURAS  GEOMETRICAS");
        fig.setFont(t20);
        fig.setHorizontalAlignment(SwingConstants.CENTER);
        menu.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        pB.add(menu);
        pB.add(fig);
        pB.setLayout(new GridLayout(2, 0));
        pc2.add(pB);
        pc2.add(pc);
        pc2.setBackground(Color.WHITE);

        pc.add(pS);
        pc.add(pC);
        pS.add(simp);
        pS.add(hor);
        pS.add(ver);
        pS.add(dia);
        pS.add(cir);
        pS.add(arc);
        pS.add(elipse);
        pS.add(new JLabel(" "));
        pS.add(cre);
        pC.add(comp);
        pC.add(puntos);
        pC.add(pyl);
//        design();
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

//    public static void main(String[] args) {
//        MenuFiguras w = new MenuFiguras();
//        w.setVisible(true);
//        w.setBounds(400, 100, 560, 500);
//        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    }

    public void frame() {
        this.setVisible(true);
        this.setBounds(400, 100, 560, 500);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    public class evtFocus extends MouseAdapter {

        @Override
        public void mouseEntered(MouseEvent fe) {
            JLabel l = (JLabel) fe.getSource();
            l.setForeground(Color.PINK);
        }

        @Override
        public void mouseExited(MouseEvent fe) {
            JLabel l = (JLabel) fe.getSource();
            l.setForeground(Color.BLACK);
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == hor) {
                InterfazLinHor w = new InterfazLinHor();
                w.frame();
            }
            if (e.getSource() == ver) {
                InterfazLinVer w = new InterfazLinVer();
                w.frame();
            }
            if (e.getSource() == dia) {
                InterfazLinDia w = new InterfazLinDia();
                w.frame();
            }
            if (e.getSource() == puntos) {
                InterfazPuntos w = new InterfazPuntos();
                w.frame();
            }
            if (e.getSource() == pyl) {
                InterfazLineas w = new InterfazLineas();
                w.frame();
            }
            if (e.getSource() == cir) {
                InterfazCirculo w = new InterfazCirculo();
                w.frame();
            }
            if (e.getSource() == cre) {
                Creditos w = new Creditos();
                w.frame();
            }
            if (e.getSource() == arc) {
                InterfazArco w = new InterfazArco();
                w.frame();
            }
            if (e.getSource() == elipse) {
                InterfazElipse w = new InterfazElipse();
                w.frame();
            }

        }
    }

    public class Creditos extends JFrame {

        JPanel pp, pc, panelImg;
        JLabel title, java, net, integrantes, name, copy, text;

        public Creditos() {
            pp = new JPanel();
            pp.setBackground(Color.WHITE);
            pc = new JPanel();
            pc.setBackground(Color.WHITE);
            panelImg = new JPanel();
            panelImg.setBackground(Color.WHITE);

            Font t16 = new Font("Serif", 0, 16);
            Font t18 = new Font("Serif", 1, 18);

            title = new JLabel("Software Utilizado para Crear Figuras Geométricas");
            title.setFont(t18);
            title.setHorizontalAlignment(SwingConstants.CENTER);
            java = new JLabel(new ImageIcon(getClass().getResource("/images/java.jpg")));
            net = new JLabel(new ImageIcon(getClass().getResource("/images/netbeans-logo.png")));
            integrantes = new JLabel("INTEGRANTES DEL EQUIPO:");
            integrantes.setFont(t18);
            integrantes.setHorizontalAlignment(SwingConstants.CENTER);
            name = new JLabel("Karla Jacquelin Guzmán Sánchez - 14380582");
            name.setFont(t16);
            name.setHorizontalAlignment(SwingConstants.CENTER);
            copy = new JLabel("Copyright:");
            copy.setHorizontalAlignment(SwingConstants.CENTER);
            copy.setFont(t18);
            text = new JLabel("<html><body>Este software es una obra intelectual desarrollada por alumnos de la carrera "
                    + "de Ing. en Sistemas Computacionales del Instituto Tecnológico de Ciudad Victoria. "
                    + "Prohibida su reproducción total o parcial sin consentimiento de los autores. Los "
                    + "autores de este tipo de producto no se hacen responsables por el uso indebido de "
                    + "esta información. Prohibida su comercialización, ya que es un software de propósito educativo.</body></html>");
            text.setFont(t16);
            text.setPreferredSize(new Dimension(500,150));
//            text.setHorizontalAlignment(SwingConstants.TRAILING);
            
            JPanel img=new JPanel();
            img.setLayout(new GridLayout(0,2));
            img.setBackground(Color.WHITE);
            img.add(java);
            img.add(net);
            add(pp);
            pp.setLayout(new BorderLayout());
            pp.add(pc, BorderLayout.CENTER);
            pp.add(panelImg, BorderLayout.SOUTH);
            pc.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx=0;
            gbc.gridy=0;
            gbc.gridwidth = 8;
            gbc.fill=GridBagConstraints.BOTH;
            pc.add(title, gbc);
            gbc.gridy=1;
            pc.add(img, gbc);
            gbc.gridx=0;
            gbc.gridy=2;
            pc.add(integrantes, gbc);
            gbc.gridy=3;
            pc.add(name, gbc);
            gbc.gridy=5;
            pc.add(copy, gbc);
            gbc.gridy=6;
            gbc.gridwidth = 8;
            gbc.fill=GridBagConstraints.HORIZONTAL;
            pc.add(text, gbc);

            panelImg.setLayout(new GridLayout(0,5));
            panelImg.add(new JLabel(new ImageIcon(getClass().getResource("/images/mx.jpg"))));
            panelImg.add(new JLabel(new ImageIcon(getClass().getResource("/images/itcv.jpg"))));
            panelImg.add(new JLabel(new ImageIcon(getClass().getResource("/images/hm.jpeg"))));
            panelImg.add(new JLabel(new ImageIcon(getClass().getResource("/images/tecn.jpg"))));
            panelImg.add(new JLabel(new ImageIcon(getClass().getResource("/images/tam.jpg"))));

            
        }

        public void frame() {
            this.setVisible(true);
            this.setBounds(400, 100, 560, 500);
            this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        }
    }
}
