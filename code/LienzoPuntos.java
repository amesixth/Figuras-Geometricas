package code;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

public class LienzoPuntos extends Canvas { //implements MouseMotionListener {

    JTable t = InterfazPuntos.t, tR = InterfazPuntos.tR;
    JLabel pyl = InterfazPuntos.title2, cyp = InterfazPuntos.title3;
    boolean p = InterfazPuntos.p;
    boolean l = InterfazPuntos.l;
    JComboBox cb = InterfazPuntos.cb, escala = InterfazPuntos.escala;
    JRadioButton CA = InterfazPuntos.CA, CR = InterfazPuntos.CR, PA = InterfazPuntos.PA, PR = InterfazPuntos.PR;
    JTabbedPane tb = InterfazPuntos.tb;
    int ejeX;
    int ejeY;
    private boolean arrastrando = false;
    private int xAnteriorRaton;
    private int yAnteriorRaton;

    public LienzoPuntos() {
        this.setSize(600, 600);
        this.setBackground(Color.WHITE);
        ejeX = getSize().width;
        ejeY = getSize().height;
        //addMouseMotionListener(this);
    }

    @Override
    public void paint(Graphics g) {

        super.paint(g);
        escala();
        cyp.setText("Coordenadas Cartesianas");

        /*
        this.x = (alto / 2) + x;
        this.y = (ancho / 2) + (-1 * y);
         */
        //Dibujar líneas
        if (tb.getSelectedIndex() == 0) {
            graficaC(g);
            if (CA.isSelected() || CR.isSelected()) {

                //Dibujar figura
                for (int i = 0; i < t.getRowCount(); i++) {
                    int x = (ejeY / 2) + Integer.parseInt((String) t.getValueAt(i, 3));
                    int y = (ejeX / 2) + (-1 * Integer.parseInt((String) t.getValueAt(i, 4)));

                    chooseColor(g);
                    g.fillOval(x - 2, y - 2, 7, 7);
                    g.drawString("P" + (i + 1), x, y);
                }
            }
            if (CA.isSelected()) {
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
            } else if (CR.isSelected()) {
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
            }
        } else if (tb.getSelectedIndex() == 1) {
            graficaP(g);
            if (PA.isSelected() || PR.isSelected()) {

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
            }
            if (PA.isSelected()) {
                cyp.setText("Coordenadas Polares Absolutas");
                for (int i = 0; i < t.getRowCount(); i++) {
                    int x1 = (ejeY / 2) + Integer.parseInt((String) t.getValueAt(i, 3));
                    int y1 = (ejeX / 2) + (-1 * Integer.parseInt((String) t.getValueAt(i, 4)));

                    float dash[] = {10};
                    Graphics2D gd2 = (Graphics2D) g;
                    gd2.setColor(Color.GRAY);
                    gd2.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 5.0f, dash, 0.0f));
                    gd2.drawLine(ejeX / 2, ejeY / 2, x1 + 2, y1 + 2);
                }
            } else if (PR.isSelected()) {
                cyp.setText("Coordenadas Polares Relativas");
                for (int i = 0; i < t.getRowCount() - 1; i++) {
                    int x1 = (ejeY / 2) + Integer.parseInt((String) t.getValueAt(i, 3))-escala();
                    int y1 = (ejeX / 2) + (-1 * Integer.parseInt((String) t.getValueAt(i, 4)))-escala();
                    int x2 = (ejeY / 2) + Integer.parseInt((String) t.getValueAt(i + 1, 3))-escala();
                    int y2 = (ejeX / 2) + (-1 * Integer.parseInt((String) t.getValueAt(i + 1, 4)))-escala();

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
        if (escala() == 20) {
            g.drawLine(ejeX / 2 + escala() - 20, 0, ejeX / 2 + escala() - 20, ejeY + escala() - 20); //Vertical
            g.drawLine(0, ejeY / 2 + escala() - 20, ejeX + escala() - 20, ejeY / 2 + escala() - 20); //Horizontal
        } else {
            g.drawLine(ejeX / 2 - escala(), 0, ejeX / 2 - escala(), ejeY + escala()); //Vertical
            g.drawLine(0, ejeY / 2 - escala(), ejeX - escala(), ejeY / 2 + escala()); //Horizontal
        }
//        Cuadricula
        for (int i = ejeX; i > -ejeX; i -= escala()) {
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
        for (int i = 800; i > 0; i -= escala()) {
            g.drawOval(ejeX / 2 - i / 2, ejeY / 2 - i / 2, i, i);
            g.drawString(i + "", ejeX / 2 - i / 2, ejeY / 2 - i / 2);
        }
        g.setColor(Color.BLACK);
        g.drawLine(ejeX / 2, 0, ejeX / 2, ejeY);
        g.drawLine(0, ejeY / 2, ejeX, ejeY / 2);
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

//    @Override
//    public void mouseDragged(MouseEvent e) {
//        if (!arrastrando) {
//            xAnteriorRaton = e.getX();
//            yAnteriorRaton = e.getY();
//            arrastrando = true;
//        } else {
//            int actualX = e.getX();
//            int actualY = e.getX();
//            int moveX = actualX - xAnteriorRaton;
//            int moveY = actualY + yAnteriorRaton;
//            ejeX = ejeX - moveX;
//            ejeY = ejeY - moveY;
//
//            xAnteriorRaton = e.getX();
//            yAnteriorRaton = e.getY();
//
//            repaint();
//        }
//    }
//
//    @Override
//    public void mouseMoved(MouseEvent me) {
//        arrastrando = false;
//    }
}
