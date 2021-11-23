package code;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class LienzoArco extends Canvas {

    int ejeX, ejeY;
    JTextField[] tf = InterfazArco.tf;
    JComboBox cb = InterfazArco.colores, relleno = InterfazArco.relleno;//,metodo = InterfazArco.metodo ;//, escala;
    DefaultTableModel dtm = InterfazArco.dtm;
    boolean y = InterfazArco.y;

    public LienzoArco() {
        this.setSize(600, 600);
        this.setBackground(Color.WHITE);
        ejeX = getSize().width;
        ejeY = getSize().height;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        graficaC(g);

        int xo = 0;
        int x1 = 0;
        int angIni = 45;
        int angFin = 90;
        int r = 5 * 2;

        if (!y) {
            tf[0].setText("0");
            tf[1].setText("0");
            tf[2].setText("45");
            tf[3].setText("90");
            tf[4].setText("5");
        }
        if (y) {
            xo = Integer.parseInt(tf[0].getText()) * 20;
            x1 = Integer.parseInt(tf[1].getText()) * 20;
            angIni = Integer.parseInt(tf[2].getText());
            angFin = Integer.parseInt(tf[3].getText());
            r = Integer.parseInt(tf[4].getText()) * 2;

//            if (metodo.getSelectedIndex() == 1) {
//                xo = Integer.parseInt(tf[0].getText()) * 20;
//                x1 = Integer.parseInt(tf[1].getText()) * 20;
//                r = Integer.parseInt(tf[2].getText()) * 2;
//                int yo = (int) Math.sqrt(Math.pow(xo/20, 2) - Math.pow(r/2, 2))*20;
//                int y1 = (int) Math.sqrt(Math.pow(x1/20, 2) - Math.pow(r/2, 2))*20;
//                
//                angIni = (int) Math.toDegrees(Math.atan((yo / xo)));
//                angFin = (int) Math.toDegrees(Math.atan((y1 / x1)));
//            }
        }

        chooseColor(g);
        g.setFont(new Font("Serif", Font.BOLD, 16));
        g.drawString("r=" + r / 2, ejeX / 2 - r * 20 / 2 - 50, ejeY / 2 - r * 20 / 2 - 1);
        g.drawString("θ inicial: " + angIni + "°", ejeX / 2 - r * 20 / 2 - 50, ejeY / 2 - r * 20 / 2 + 15);
        g.drawString("θ final: " + angFin + "°", ejeX / 2 - r * 20 / 2 - 50, ejeY / 2 - r * 20 / 2 + 30);
        if (relleno.getSelectedIndex() == 0) {
            g.drawArc(ejeX / 2 - r * 20 / 2 + xo - 1, ejeY / 2 - r * 20 / 2 - x1 - 1, r * 20, r * 20, angIni, angFin - angIni);
        } else {
            g.fillArc(ejeX / 2 - r * 20 / 2 + xo - 1, ejeY / 2 - r * 20 / 2 - x1 - 1, r * 20, r * 20, angIni, angFin - angIni);
        }
    }

    public void graficaC(Graphics g) {
        g.setColor(Color.BLACK);
        //Plano
        g.drawLine(ejeX / 2, 0, ejeX / 2, ejeY);
        g.drawLine(0, ejeY / 2, ejeX, ejeY / 2);
        //Cuadricula
        for (int i = ejeX; i > -ejeX; i -= 20) {
            g.setColor(Color.black);
            g.setFont(new Font("Serif", Font.PLAIN, 10));
            g.drawLine(i, ejeY / 2 - 5, i, ejeY / 2 + 5);
            if (i - ejeX / 2 != 0) {
                g.drawString((i - ejeX / 2) / 20 + "", i, ejeY / 2 - 5);
            }
            g.drawLine(ejeX / 2 - 5, i, ejeX / 2 + 5, i);
            g.drawString(((i - ejeX / 2) * -1) / 20 + "", ejeX / 2 + 5, i);
            Graphics2D gd2 = (Graphics2D) g;
            gd2.setColor(Color.LIGHT_GRAY);
            gd2.drawLine(0, i + 1, ejeX, i + 1);
            gd2.drawLine(i + 1, 0, i + 1, ejeY);
        }
        g.setColor(Color.BLACK);
        g.setFont(new Font("Serif", Font.BOLD, 14));
        g.drawString("X", ejeX - 30, ejeY / 2 + 20);
        g.drawString("-X", 20, ejeY / 2 + 20);
        g.drawString("Y", ejeX / 2 - 20, 30);
        g.drawString("-Y", ejeX / 2 - 20, ejeY - 20);
        g.setFont(new Font("Serif", Font.PLAIN, 10));
    }

    public void chooseColor(Graphics g) {

        if (cb.getSelectedIndex() == 0) {
            g.setColor(Color.BLACK);
        }
        if (cb.getSelectedIndex() == 1) {
            g.setColor(Color.RED);
        }
        if (cb.getSelectedIndex() == 2) {
            g.setColor(Color.BLUE);
        }
        if (cb.getSelectedIndex() == 3) {
            g.setColor(Color.YELLOW);
        }
        if (cb.getSelectedIndex() == 4) {
            g.setColor(Color.GREEN);
        }
        if (cb.getSelectedIndex() == 5) {
            g.setColor(Color.MAGENTA);
        }
        if (cb.getSelectedIndex() == 6) {
            g.setColor(Color.PINK);
        }
        if (cb.getSelectedIndex() == 7) {
            g.setColor(Color.ORANGE);
        }
    }
}
