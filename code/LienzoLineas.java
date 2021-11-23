package code;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

public class LienzoLineas extends Canvas {

    JTable t = InterfazLineas.t, t2 = InterfazLineas.t2, tR = InterfazLineas.tR;
    JLabel pyl = InterfazLineas.title2, cyp = InterfazLineas.title3;
    JComboBox cb = InterfazLineas.cb;
    JTabbedPane tb = InterfazLineas.tb;
    JRadioButton CA = InterfazLineas.CA, CR = InterfazLineas.CR, PA = InterfazLineas.PA, PR = InterfazLineas.PR;
    int ejeX;
    int ejeY;

    public LienzoLineas() {
        this.setSize(600, 600);
        this.setBackground(Color.WHITE);
        ejeX = getSize().width;
        ejeY = getSize().height;
    }

    @Override
    public void paint(Graphics g) {

        super.paint(g);

        if (tb.getSelectedIndex() == 0) {
            cyp.setText("Coordenadas Cartesianas");
            graficaC(g);

        } else if (tb.getSelectedIndex() == 1) {
            cyp.setText("Coordenadas Polares");
            graficaP(g);
        }
        /*
        this.x = (alto / 2) + x;
        this.y = (ancho / 2) + (-1 * y);
         */

        //Absolutas
        if (CA.isSelected() || PA.isSelected()) {
            for (int i = 0; i < t.getRowCount() - 1; i++) {
                int x1 = (ejeY / 2) + Integer.parseInt((String) t.getValueAt(i, 3));
                int y1 = (ejeX / 2) + (-1 * Integer.parseInt((String) t.getValueAt(i, 4)));
                int x2 = (ejeY / 2) + Integer.parseInt((String) t.getValueAt(i + 1, 3));
                int y2 = (ejeX / 2) + (-1 * Integer.parseInt((String) t.getValueAt(i + 1, 4)));

                chooseColor(g);
                g.drawLine(x1, y1, x2, y2);
            }

            //Dibujar figura
            for (int i = 0; i < t.getRowCount(); i++) {
                int x = (ejeY / 2) + Integer.parseInt((String) t.getValueAt(i, 3));
                int y = (ejeX / 2) + (-1 * Integer.parseInt((String) t.getValueAt(i, 4)));

                chooseColor(g);
                g.fillOval(x - 2, y - 2, 7, 7);
                if (i == 11) {
                    g.drawString("P" + (i + 1), x - 20, y);
                } else if (i > 9 || i == 6) {
                    g.drawString("P" + (i + 1), x - 15, y + 15);
                } else {
                    g.drawString("P" + (i + 1), x, y);
                }
            }

            if (tb.getSelectedIndex() == 0) {
                cyp.setText("Coordenadas Cartesianas Absolutas");
                graficaC(g);
                for (int i = 0; i < t.getRowCount(); i++) {
                    int x = (ejeY / 2) + Integer.parseInt((String) t.getValueAt(i, 3));
                    int y = (ejeX / 2) + (-1 * Integer.parseInt((String) t.getValueAt(i, 4)));
                    float dash[] = {10};
                    Graphics2D gd2 = (Graphics2D) g;
                    gd2.setColor(Color.GRAY);
                    gd2.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 5.0f, dash, 0.0f));
                    gd2.drawLine(ejeX / 2, y + 2, x + 2, y + 2);
                    gd2.drawLine(x + 2, ejeY / 2, x + 2, y + 2);
                }
            } else if (tb.getSelectedIndex() == 1) {
                cyp.setText("Coordenadas Polares Absolutas");
                graficaP(g);
                for (int i = 0; i < t.getRowCount(); i++) {
                    int x1 = (ejeY / 2) + Integer.parseInt((String) t.getValueAt(i, 3));
                    int y1 = (ejeX / 2) + (-1 * Integer.parseInt((String) t.getValueAt(i, 4)));

                    float dash[] = {10};
                    Graphics2D gd2 = (Graphics2D) g;
                    gd2.setColor(Color.GRAY);
                    gd2.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 5.0f, dash, 0.0f));
                    gd2.drawLine(ejeX / 2, ejeY / 2, x1 + 2, y1 + 2);
                }
            }
            //Relativas
        } else if (CR.isSelected() || PR.isSelected()) {
            for (int i = 0; i < t.getRowCount() - 1; i++) {
                int x1 = (ejeY / 2) + Integer.parseInt((String) t.getValueAt(i, 3));
                int y1 = (ejeX / 2) + (-1 * Integer.parseInt((String) t.getValueAt(i, 4)));
                int x2 = (ejeY / 2) + Integer.parseInt((String) t.getValueAt(i + 1, 3));
                int y2 = (ejeX / 2) + (-1 * Integer.parseInt((String) t.getValueAt(i + 1, 4)));

                chooseColor(g);
                g.drawLine(x1, y1, x2, y2);
            }
            //Dibujar figura
            for (int i = 0; i < t.getRowCount(); i++) {
                int x = (ejeY / 2) + Integer.parseInt((String) t.getValueAt(i, 3));
                int y = (ejeX / 2) + (-1 * Integer.parseInt((String) t.getValueAt(i, 4)));

                chooseColor(g);
                g.fillOval(x - 2, y - 2, 7, 7);
                if (i == 11) {
                    g.drawString("P" + (i + 1), x - 20, y);
                } else if (i > 9 || i == 6) {
                    g.drawString("P" + (i + 1), x - 15, y + 15);
                } else {
                    g.drawString("P" + (i + 1), x, y);
                }
            }

            if (tb.getSelectedIndex() == 0) {
                cyp.setText("Coordenadas Cartesianas Relativas");
                graficaC(g);
                for (int i = 0; i < t.getRowCount() - 1; i++) {
                    int x1 = (ejeY / 2) + Integer.parseInt((String) t.getValueAt(i, 3));
                    int y1 = (ejeX / 2) + (-1 * Integer.parseInt((String) t.getValueAt(i, 4)));
                    int x2 = (ejeY / 2) + Integer.parseInt((String) t.getValueAt(i + 1, 3));
                    int y2 = (ejeX / 2) + (-1 * Integer.parseInt((String) t.getValueAt(i + 1, 4)));

                    float dash[] = {10};
                    Graphics2D gd2 = (Graphics2D) g;
                    gd2.setColor(Color.GRAY);
                    gd2.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 5.0f, dash, 0.0f));
                    gd2.drawLine(x1, y1, x2, y2);
                }

                int xo = (ejeY / 2) + Integer.parseInt((String) t.getValueAt(0, 3));
                int yo = (ejeX / 2) + (-1 * Integer.parseInt((String) t.getValueAt(0, 4)));
                float dash[] = {10};
                Graphics2D gd2 = (Graphics2D) g;
                gd2.setColor(Color.GRAY);
                gd2.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 5.0f, dash, 0.0f));
                gd2.drawLine(ejeX / 2, yo + 2, xo + 2, yo + 2);
                gd2.drawLine(xo + 2, ejeY / 2, xo + 2, yo + 2);

            } else if (tb.getSelectedIndex() == 1) {
                cyp.setText("Coordenadas Polares Relativas");
                graficaP(g);
                for (int i = 0; i < t.getRowCount() - 1; i++) {
                    int x1 = (ejeY / 2) + Integer.parseInt((String) t.getValueAt(i, 3));
                    int y1 = (ejeX / 2) + (-1 * Integer.parseInt((String) t.getValueAt(i, 4)));
                    int x2 = (ejeY / 2) + Integer.parseInt((String) t.getValueAt(i + 1, 3));
                    int y2 = (ejeX / 2) + (-1 * Integer.parseInt((String) t.getValueAt(i + 1, 4)));

                    float dash[] = {10};
                    Graphics2D gd2 = (Graphics2D) g;
                    gd2.setColor(Color.GRAY);
                    gd2.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 5.0f, dash, 0.0f));
                    if (i == 0) {
                        g.drawLine(ejeX / 2, ejeY / 2, x1, y1);
                    }
                    gd2.drawLine(x1, y1, x2, y2);
                }
            }
        }
    }

    public void graficaC(Graphics g) {
        g.setColor(Color.BLACK);
        //Plano
        g.drawLine(ejeX / 2, 0, ejeX / 2, ejeY);
        g.drawLine(0, ejeY / 2, ejeX, ejeY / 2);
//        Cuadricula
        for (int i = ejeX; i > -ejeX; i -= 20) {
            g.setColor(Color.black);
            g.setFont(new Font("Serif", Font.PLAIN, 10));
            g.drawLine(i, ejeY / 2 - 5, i, ejeY / 2 + 5);
            if (i - ejeX / 2 != 0) {
                g.drawString((i - ejeX / 2) + "", i, ejeY / 2 - 5);
            }
            g.drawLine(ejeX / 2 - 5, i, ejeX / 2 + 5, i);
            g.drawString(((i - ejeX / 2) * -1) + "", ejeX / 2 + 5, i);
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

    public void graficaP(Graphics g) {
        cyp.setText("Coordenadas Polares");
        g.setColor(Color.BLACK);
        g.fillOval(ejeX / 2 - 2, ejeY / 2 - 2, 5, 5);
        g.drawString("Origen", ejeX / 2, ejeY / 2 + 17);

        g.setColor(Color.LIGHT_GRAY);
        g.setFont(new Font("Serif", Font.PLAIN, 10));
        for (int i = 800; i > 0; i -= 20) {
            g.drawOval(ejeX / 2 - i / 2, ejeY / 2 - i / 2, i, i);
            g.drawString(i + "", ejeX / 2 - i / 2, ejeY / 2 - i / 2);
        }
        g.setColor(Color.BLACK);
        g.drawLine(ejeX / 2, 0, ejeX / 2, ejeY);
        g.drawLine(0, ejeY / 2, ejeX, ejeY / 2);
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
