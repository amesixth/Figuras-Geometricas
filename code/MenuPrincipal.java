package code;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MenuPrincipal extends JFrame {
    
    JPanel pp, header, pc;
    JLabel menu, ing, graf, title1, title2;
    
    public MenuPrincipal() {
        pp = new JPanel();
        pp.setBackground(Color.WHITE);
        header = new JPanel();
        header.setBackground(Color.WHITE);
        pc = new JPanel();
        pc.setBackground(Color.WHITE);
        
        Font t16 = new Font("Serif", 0, 16);
        Font t1 = new Font("Serif", 1, 16);
        Font t18 = new Font("Serif", 1, 18);
        
        menu = new JLabel("FIGURAS GEOMETRICAS");
        menu.setFont(t16);
        menu.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseEntered(MouseEvent e) {
                menu.setForeground(Color.PINK);
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                menu.setForeground(Color.BLACK);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                MenuFiguras w = new MenuFiguras();
                w.frame();
//                MenuPrincipal.this.setVisible(false);
            }
        });
        menu.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        menu.setHorizontalAlignment(SwingConstants.CENTER);
        ing = new JLabel("ING. EN SISTEMAS COMPUTACIONALES");
        ing.setFont(t1);
        ing.setHorizontalAlignment(SwingConstants.CENTER);
        graf = new JLabel("GRAFICACIÓN");
        graf.setHorizontalAlignment(SwingConstants.CENTER);
        graf.setFont(t1);
        title1 = new JLabel("Graficación 2D por Computadora");
        title1.setFont(t18);
        title1.setHorizontalAlignment(SwingConstants.CENTER);
        title2 = new JLabel("Graficación Básica por Computadora");
        title2.setFont(t18);
        title2.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel h = new JLabel(new ImageIcon(getClass().getResource("/images/headerF.jpg")));
        JLabel f1 = new JLabel(new ImageIcon(getClass().getResource("/images/elipses.png")));
        JLabel f2 = new JLabel(new ImageIcon(getClass().getResource("/images/figLineas.PNG")));
        JPanel he = new JPanel();
        he.setBackground(Color.WHITE);
        he.setLayout(new GridLayout(2, 0));
        he.add(h);
        he.add(header);
        header.setLayout(new GridLayout(2, 0));
        JPanel h1=new JPanel();
        h1.setLayout(new GridLayout(2, 0));
        h1.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        h1.add(ing);
        h1.add(graf);
        h1.setBackground(Color.WHITE);
        JPanel h2=new JPanel();
        h2.setBackground(Color.WHITE);
        h2.setLayout(new GridLayout(2, 0));
        h2.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        h2.add(title1);
        h2.add(title2);
        header.add(h1);
        header.add(h2);
        
        pc.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        pc.add(f1, gbc);
        gbc.gridx = 1;
        pc.add(new JLabel("  "), gbc);
        gbc.gridx = 2;
        pc.add(menu);
        gbc.gridx = 3;
        pc.add(new JLabel("  "), gbc);
        gbc.gridx = 4;
        pc.add(f2, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.CENTER;
        pc.add(new JLabel("   "), gbc);
        JLabel as = new JLabel("Asesor: Ing. José Lino Hernández Omaña");
        as.setFont(t16);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.CENTER;
        pc.add(as, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.CENTER;
        pc.add(new JLabel("   "), gbc);
        JLabel cd = new JLabel("Cd. Victoria, Tamaulipas");
        cd.setFont(t16);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        pc.add(cd, gbc);
        JLabel fe = new JLabel("         Marzo 2017");
        fe.setFont(t16);
        gbc.gridx = 4;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        pc.add(fe, gbc);
        
        add(pp);
        pp.setLayout(new BorderLayout());
        pp.add(he, BorderLayout.NORTH);
        pp.add(pc, BorderLayout.CENTER);
    }
    
    public static void main(String[] args) {
        MenuPrincipal w = new MenuPrincipal();
        w.setVisible(true);
        w.setBounds(400, 100, 560, 500);
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
