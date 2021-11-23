package code;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComboBox;
import javax.swing.JTextField;
//import javax.swing.table.DefaultTableModel;

public class LienzoElipse extends Canvas {

    int ejeX, ejeY;
    JTextField[] tf = InterfazElipse.tf;
    JComboBox metodo = InterfazElipse.metodo, cb = InterfazElipse.colores, relleno = InterfazElipse.relleno;//, escala;
//    DefaultTableModel dtm = InterfazElipse.dtm;
    boolean y = InterfazElipse.y;

    public LienzoElipse() {
        this.setSize(680, 680);
        this.setBackground(Color.WHITE);
        ejeX = getSize().width;
        ejeY = getSize().height;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        graficaC(g);
        int xo = 0;
        int yo = 0;
        int a = 3;
        int b = 6;
        int ang = 0;
        int r = 0;
        int px = 0;
        int py = 0;

        if (y) {
            xo = Integer.parseInt(tf[0].getText()) * 20;
            yo = Integer.parseInt(tf[1].getText()) * 20;
            a = Integer.parseInt(tf[2].getText()) * 2;
            b = Integer.parseInt(tf[3].getText()) * 2;
            if (!tf[4].getText().equals("")) {
                ang = Integer.parseInt(tf[4].getText());
            }
            if (metodo.getSelectedIndex() == 1) {
                r = (int) Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
                px = (int) (r / 2 * Math.toDegrees(Math.cos(Math.toRadians(ang)))) / 2;
                py = (int) (r / 2 * Math.toDegrees(Math.sin(Math.toRadians(ang)))) / 2;
            }
        } else {
            tf[0].setText("0");
            tf[1].setText("0");
            tf[2].setText("3");
            tf[3].setText("6");
        }
        g.setColor(Color.BLACK);
        g.setFont(new Font("Serif", Font.BOLD, 16));
        g.drawString("(h, k)=(" + xo / 20 + ", " + yo / 20 + ")", ejeX / 2 + a * 20 / 2 - a * 20 - 50, ejeY / 2 - b * 20 / 2);
        g.drawString("a=" + a / 2, ejeX / 2 + a * 20 / 2 - a * 20 - 50, ejeY / 2 - b * 20 / 2 + 15);
        g.drawString("b=" + b / 2, ejeX / 2 + a * 20 / 2 - a * 20 - 50, ejeY / 2 - b * 20 / 2 + 30);
        if (!tf[4].getText().equals("")) {
            g.drawString("θ: " + ang + "°", ejeX / 2 + a * 20 / 2 - a * 20 - 50, ejeY / 2 - b * 20 / 2 + 45);
        }
        chooseColor(g);
        if (relleno.getSelectedIndex() == 0) {
            g.drawOval(ejeX / 2 + a * 20 / 2 - a * 20 + xo, ejeY / 2 - b * 20 / 2 - yo, a * 20, b * 20);
        } else {
            g.fillOval(ejeX / 2 + a * 20 / 2 - a * 20 + xo, ejeY / 2 - b * 20 / 2 - yo, a * 20, b * 20);
        }
        g.setColor(Color.BLACK);
        g.fillOval(ejeX / 2 + xo - 2, ejeY / 2 - yo - 2, 6, 6);
        if (metodo.getSelectedIndex() == 1) {
            g.drawLine(ejeX / 2 + xo, ejeY / 2 - yo, ejeX / 2 + px, ejeY / 2 - py);
            g.drawString("Ang. = " + ang + "°", ejeX / 2 + px, ejeY / 2 - py);
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
