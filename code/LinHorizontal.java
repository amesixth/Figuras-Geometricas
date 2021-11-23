package code;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class LinHorizontal extends Canvas {

    int ejeX, ejeY, gy = 0;
    float gx = 0;
    int minX, minY, maxX, maxY;
    JTextField[] tf = InterfazLinHor.tf;
    DefaultTableModel dtm = InterfazLinHor.dtm;
    JComboBox cb = InterfazLinHor.colores;
    boolean y = InterfazLinHor.y;

    public LinHorizontal() {
        this.setSize(600, 600);
        ejeX = this.getHeight();
        ejeY = this.getWidth();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.setBackground(Color.WHITE);
        graficaC(g);
        chooseColor(g);
        minY = maxY = (ejeY / 2) - 40;
        minX = ejeX / 2 + 40;
        maxX = ejeX / 2 + 120;
        gy = 2;
        gx = 2;
        if (y) {
            minX = ejeX / 2 + Integer.parseInt(tf[0].getText()) * 20;
            minY = (ejeY / 2) - Integer.parseInt(tf[1].getText()) * 20;
            maxX = ejeX / 2 + Integer.parseInt(tf[2].getText()) * 20;
            maxY = (ejeY / 2) - Integer.parseInt(tf[3].getText()) * 20;
        }
        if (!y) {
            tf[0].setText("2");
            tf[1].setText("2");
            tf[2].setText("6");
            tf[3].setText("2");
        }

        if (dtm.getRowCount() > 0) {
            for (int i = 0; i < dtm.getRowCount();) {
                dtm.removeRow(i);
            }
        }
        chooseColor(g);
        gy = Integer.parseInt(tf[1].getText());
        gx = Integer.parseInt(tf[0].getText());
        for (int i = minX, j = 1; i <= maxX; i += 10, j++) {
            g.fillOval(i, minY, 6, 6);
            String[] s = {"P" + j, gx + "", gy + ""};
            dtm.addRow(s);
            gx += 0.5;
        }
        
        int mX=Integer.parseInt(tf[0].getText());
        int mY=Integer.parseInt(tf[1].getText());
        int maX=Integer.parseInt(tf[2].getText());
        int maY=Integer.parseInt(tf[3].getText());
        g.setFont(new Font("Serif", Font.PLAIN, 12));
        g.drawString("Pi ("+mX+", "+mY+")", minX+5, minY-5);
        g.drawLine(minX, minY + 2, maxX, maxY + 2);
        g.drawString("Pf ("+maX+", "+maY+")", maxX+5, maxY-5);
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
