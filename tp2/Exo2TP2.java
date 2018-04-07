import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Exo2TP2 {
    public static void main(String args[]) {
    	 EventQueue.invokeLater(new Runnable() { 
    			public void run() { 
    				Frame_Exo2TP2 f = new Frame_Exo2TP2 ("Dessiner");
    				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    				f.pack();
    				f.setVisible(true);  	
    			}
    		 }); 
    		}
}


class Frame_Exo2TP2 extends JFrame implements ActionListener{
	private Dessin dess;
	private JButton b1,b2,b3,b4,b5,b6;
	private JPanel p,pad,pag,pa;
	private char f;

	public Frame_Exo2TP2 (String titre) {
		super(titre);
		dess=new Dessin();
		dess.setPreferredSize(new Dimension(400,200));

		b1=new JButton("Cercle");
		b1.addActionListener(this);
		b2=new JButton("Carré jaune");
		b2.addActionListener(this);
		
		p=new JPanel(new GridLayout(1,0,2,2));
		pad=new JPanel();
		pag=new JPanel();
		p.setBackground(Color.BLUE);
		pag.add(b1);
		pad.add(b2);
		p.setPreferredSize(new Dimension(400, 100));
		p.add(pag);
		p.add(pad);
		this.add(p,BorderLayout.SOUTH);
		this.add(dess, BorderLayout.CENTER);
	}
	



public void actionPerformed(ActionEvent e)
{
	if((e.getSource()).equals(b1)) f='o';

	if((e.getSource()).equals(b2)) f='c';   
 
    dess.repaint();

}

class Dessin extends JPanel {
	private EcouteurButton ecouteur;
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(Color.BLUE);
		ecouteur=new EcouteurButton();
		switch(f) {
		    case 'o': g.setColor(Color.yellow);
		              g.drawOval(150, 50, 100, 100);
		              p.remove(pad);
		    		  pa=new JPanel(new GridLayout(2,0));              
		    		  b3=new JButton("rouge");
		    		  b3.addActionListener(ecouteur);
		    		  b4=new JButton("vert");
		    		  b4.addActionListener(ecouteur);
		    		  b5=new JButton("noir");
		    		  b5.addActionListener(ecouteur);
		    		  b6=new JButton("rose");
		    		  b6.addActionListener(ecouteur);
		    		  pa.add(b3);
		    	      pa.add(b4);
		    		  pa.add(b5);
		    		  pa.add(b6);           
		    		  p.add(pa);
		    		  p.validate();
		    		  p.repaint();
		              break;
		    case 'c': g.setColor(Color.yellow);
		              g.fillRect(150, 50, 100, 100);
                      break;
		    default: break;
		          
		}
		

		}
		
	
	}
    class EcouteurButton implements ActionListener
    {
    	Graphics g=dess.getGraphics();
	    public void actionPerformed(ActionEvent e) 
	    {	
		    if((e.getSource()).equals(b3)) 
		    {
			    g.setColor(Color.red);
                g.fillOval(150, 50, 100, 100);
                p.remove(pa);
                p.add(pad);
	    		p.validate();
	    		p.repaint();
		    }
		    if((e.getSource()).equals(b4)) 
		    {
			    g.setColor(Color.green);
                g.fillOval(150, 50, 100, 100);
                p.remove(pa);
                p.add(pad);
	    		p.validate();
	    		p.repaint();
		    }
		    if((e.getSource()).equals(b5)) 
		    {
			    g.setColor(Color.black);
                g.fillOval(150, 50, 100, 100);
                p.remove(pa);
                p.add(pad);
	    		p.validate();
	    		p.repaint();
		    }
		    if((e.getSource()).equals(b6)) 
		    {
			    g.setColor(Color.pink);
                g.fillOval(150, 50, 100, 100);
                p.remove(pa);
                p.add(pad);
	    		p.validate();
	    		p.repaint();
		    }
        }
    }



}
