package grafikfinal3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author ERHAN
 */
class Board extends JPanel implements ActionListener{
    Timer timer;
    Random rnd;
    public int DELAY=1000;
    public int R,G,B,O;
    public Board()
    {
        timer = new Timer(DELAY, this);
        timer.start();
        rnd = new Random();
    }
    
    private void doDrawing(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g.create();
        int genislik = getWidth(), yukseklik = getHeight();
        int en = getWidth()/15;
        int boy = getHeight()/15;

        for(int i=0;i<yukseklik;i+=boy)
        {
            for(int j=0;j<genislik;j+=en)
            {
                R = rnd.nextInt(255);
                G = rnd.nextInt(255);
                B = rnd.nextInt(255);
                O = rnd.nextInt(255);
                g2d.setPaint(new Color(R,G,B,O));
                g2d.drawRect(j, i, en, boy);
                
                R = rnd.nextInt(255);
                G = rnd.nextInt(255);
                B = rnd.nextInt(255);
                O = rnd.nextInt(255);
                g2d.setPaint(new Color(R,G,B,O));
                g2d.fillRect(j+1, i+1, en-1, boy-1);
            }
        }
        
        
        
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        doDrawing(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        repaint();
    }
    
}
public class GrafikFinal3 extends JFrame{

    public GrafikFinal3()
    {
        Board board = new Board();
        add(board);
        setSize(700,700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
    }
    public static void main(String[] args) {
        // TODO code application logic here
        GrafikFinal3 gf3 = new GrafikFinal3();
        gf3.setVisible(true);
    }
    
}
