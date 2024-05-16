package Files;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JComponent;

public class Star extends JComponent {

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(new Color(80,90, 70));
        g.fillRect(0, 0, 600, 600);

        int N = 10;
        int[] x = new int[N];
        int[] y = new int[N];

        Point center = new Point(300, 300);
        double r1 = 200;
        double r2 = 80;
        double dTheta = 2 * Math.PI / N;
        double theta = 270 * Math.PI / 180;
        
        for (int i = 0; i < N; i++)
        {
            double vx = 0, vy = 0;
            // double dist = 4 + 15 * Math.cos(8 * theta);
            // double dist = 120 + 30 * Math.sin(-5 * theta);
            double dist = i % 2 == 0 ? r1 : r2;

            vx = dist * Math.cos(theta);
            vy = dist * Math.sin(theta);
            theta += dTheta;

            x[i] = (int)(center.getX() + vx);
            y[i] = (int)(center.getY() + vy);
        }

        g.setColor(Color.cyan);
        g.fillPolygon(x, y, N);
    }   
}