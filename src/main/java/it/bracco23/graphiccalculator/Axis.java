package it.bracco23.graphiccalculator;


import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * AWT panel that draw a cartesian
 *
 * @author Emiddio
 */
public class Axis extends JPanel {

    private double x[];
    private double y[];
    private double xmin, xmax;
    private double ymin, ymax;

    public Axis() {
        xmin = -10;
        xmax = 10;
        ymin = -10;
        ymax = 10;
        x = null;
        y = null;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawLine(getScreenX(0), this.getHeight(), getScreenX(0), 0);
        g2D.drawLine(0, getScreenY(0), this.getWidth(), getScreenY(0));
        if (x != null && y != null && x.length == y.length) {
            for (int i = 0; i < x.length - 1; i++) {
                if (!Double.isNaN(y[i]) && y[i] <= ymax) {
                    g2D.drawLine(getScreenX(x[i]), getScreenY(y[i]), getScreenX(x[i + 1]), getScreenY(y[i + 1]));
                }
            }
        }
    }

    public int getScreenX(double x) {
        if (x < xmin) {
            return 0;
        } else if (x > xmax) {
            return WIDTH;
        }
        return (int) (Math.round(this.getWidth() * x / (xmax - xmin) - xmin * this.getWidth() / (xmax - xmin)));
    }

    public int getScreenY(double y) {
        if (y < ymin) {
            return this.getHeight();
        } else if (y > ymax) {
            return 0;
        }
        return (int) (Math.round(this.getHeight() * y / (ymin - ymax) - this.getHeight() * ymax / (ymin - ymax)));
    }

    public double geCartesianX(int x) {
        return (xmax - xmin) * x / this.getWidth() + xmin;
    }

    public double getCartesianY(int y) {
        return (ymin - ymax) * y / this.getHeight() + ymax;
    }

    public void setPoints(double[] x, double[] y) {
        this.x = x;
        this.y = y;
        repaint();
    }

    public void resetPoints() {
        x = null;
        y = null;
    }

    public void setRanges(double xmin, double ymin, double xmax, double ymax) {
        this.xmin = xmin;
        this.ymin = ymin;
        this.xmax = xmax;
        this.ymax = ymax;
    }

    public double getXmin() {
        return xmin;
    }

    public double getXmax() {
        return xmax;
    }

    public double getYmin() {
        return ymin;
    }

    public double getYmax() {
        return ymax;
    }
    
}
