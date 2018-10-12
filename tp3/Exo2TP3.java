import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Exo2TP3 {
	public static void main(String args[]) {
   	    EventQueue.invokeLater(new Runnable() { 
   			public void run() { 
   				Frame_Exo2TP3 f = new Frame_Exo2TP3 ("Dessiner");
   				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   				f.pack();
   				f.setVisible(true);  	
   			}
   		 }); 
   		}
}

class Frame_Exo2TP3 extends JFrame{
	private Image fond, im[]=new Image[10];
	private int pos1,pos2,numlic=0;
	private int[] ordre= {10,9,1,2,4,2,7,6,5,10,3,3,8,9,1,8,6,5,4,7};
	
	//Rand r1=new Rand();
	//private int []ordre=r1.rand();
	
	
	private boolean[] trouve= {false,false,false,false,false,false,false,false,false,false,
			false,false,false,false,false,false,false,false,false,false};
	private Pan panneau;
	private JPanel p1,p2,p3;
	private JLabel t1,t2,t3,t4;
	private int np=0;
	private int nc=0;
	private boolean ver=true;
	private boolean ver1=false;
	private int i;
    private JLabel j1;
    private JButton b1,b2;
	private JPanel jp,jp1,jp2;
    
    
	public Frame_Exo2TP3(String titre) {
		super(titre);
		
		panneau=new Pan();
		panneau.addMouseListener(new MonMouseListener());
		try {
			fond=ImageIO.read(new File("fond.png"));
			im[0]=ImageIO.read(new File("im1.png"));
			im[1]=ImageIO.read(new File("im2.png"));
			im[2]=ImageIO.read(new File("im3.png"));
			im[3]=ImageIO.read(new File("im4.png"));
			im[4]=ImageIO.read(new File("im5.png"));
			im[5]=ImageIO.read(new File("im6.png"));
			im[6]=ImageIO.read(new File("im7.png"));
			im[7]=ImageIO.read(new File("im8.png"));
			im[8]=ImageIO.read(new File("im9.png"));
			im[9]=ImageIO.read(new File("im10.png"));
		}catch (Exception e) {};
		panneau.setPreferredSize(new Dimension(605, 485));
		this.add(panneau,BorderLayout.CENTER);
	    p1=new JPanel(new BorderLayout());
	    p1.setPreferredSize(new Dimension(605, 100));
		
		p2=new JPanel();
		t1=new JLabel("Nombre de coups");
		t1.setPreferredSize(new Dimension(230, 35));
		t1.setBorder(BorderFactory.createLoweredBevelBorder());
		t1.setForeground(Color.BLUE);
		t2=new JLabel("0",JLabel.CENTER);
		t2.setPreferredSize(new Dimension(35, 35));
		t2.setBorder(BorderFactory.createLoweredBevelBorder());
		t2.setOpaque(true);
		t2.setBackground(Color.BLUE);
		t2.setForeground(Color.WHITE);
		p2.add(t1);
		p2.add(t2);
		
		p3=new JPanel();
		t3=new JLabel("Nombre de paires découvertes");
		t3.setForeground(Color.BLUE);
		t3.setPreferredSize(new Dimension(230, 35));
		t3.setBorder(BorderFactory.createLoweredBevelBorder());
		t4=new JLabel("0",JLabel.CENTER);
		t4.setPreferredSize(new Dimension(35, 35));
		t4.setBorder(BorderFactory.createLoweredBevelBorder());
		t4.setOpaque(true);
		t4.setBackground(Color.BLUE);
		t4.setForeground(Color.WHITE);
		p3.add(t3);
		p3.add(t4);
		p1.add(p2,BorderLayout.CENTER);
		p1.add(p3,BorderLayout.SOUTH);
		this.add(p1,BorderLayout.SOUTH);
		
	}
	
    class Pan extends JPanel {
    	public void paintComponent(Graphics g) {
    		super.paintComponent(g);

    		for(int i=0;i<=4;i++)
    		    for(int j=0;j<=3;j++)
    		    {    
    		    	if(trouve[i+5*j]==true)
    		    	{    
    		    		g.drawImage(im[ordre[i+5*j]-1], 5+120*i, 5+120*j, this);
    		        }
    		    	else
    		    		g.drawImage(fond,5+120*i,5+120*j,this);
    		    }
	
    	}
    }

    class MonMouseListener extends MouseAdapter{
    	public void mouseClicked(MouseEvent e) {
    		
    		  numlic+=1; 
              if(numlic%2==1)
              {
            	      if(!ver)
            	      {
            	          trouve[pos1]=false;
            	          trouve[pos2]=false;
            	          panneau.repaint();
            	          
            	      }
            	      pos1=(int)((e.getX()-5)/120)+(int)((e.getY()-5)/120)*5;
        		      trouve[pos1]=true;
        		      ver=true;
              }
              else
              {
            	  pos2=pos1;
            	  pos1=(int)((e.getX()-5)/120)+(int)((e.getY()-5)/120)*5;
            	  trouve[pos1]=true;
            	  if(pos1!=pos2)
                      if(ordre[pos1]!=ordre[pos2])
                      {  
                	      nc+=1;
                          t2.setText(""+nc);
                          ver=false;
                     } 
                     else
                     {   
               	         trouve[pos2]=true;
             	         nc+=1;
                         t2.setText(""+nc);
                    	 np+=1;
                    	 t4.setText(""+np);
                     }
              }    		  
              for(i=0;i<20;i++)
    		  {
    			  if(trouve[i]==false)
    			  {
    				  ver1=false;
    				  break;
    			  }
    			  ver1=true;
    		  }
    		  panneau.repaint();
    		  if(ver1)
    			{
    				remove(p1);
    				p1=new JPanel(new GridBagLayout());
    				p1.setPreferredSize(new Dimension(605, 100));
    				GridBagConstraints c=new GridBagConstraints();
    				p1.setBorder(BorderFactory.createRaisedBevelBorder());
    				
    				j1=new JLabel("Vous avez gagné en "+nc+" coup. Vous vous rejouer?",JLabel.CENTER);
    				j1.setPreferredSize(new Dimension(350, 80));
    				j1.setBorder(BorderFactory.createLoweredBevelBorder());
    				j1.setForeground(Color.BLUE);
    				c.gridx=0;
    				c.gridy=0;
    				c.gridwidth=1;
    				c.gridheight=2;
    				p1.add(j1,c);
    				
    				b1=new JButton("Oui");
    				b1.addActionListener(new ActionListener() {
						
						public void actionPerformed(ActionEvent e) {
							remove(p1);
							
							
							Rand r1=new Rand();
							ordre=r1.rand();
							
							
						    for(int k=0;k<20;k++)
								trouve[k]=false;
							np=nc=numlic=0;
							ver=true;
							ver1=false;
						    
							
							
							panneau=new Pan();
							panneau.addMouseListener(new MonMouseListener());
							try {
								fond=ImageIO.read(new File("fond.png"));
								im[0]=ImageIO.read(new File("im1.png"));
								im[1]=ImageIO.read(new File("im2.png"));
								im[2]=ImageIO.read(new File("im3.png"));
								im[3]=ImageIO.read(new File("im4.png"));
								im[4]=ImageIO.read(new File("im5.png"));
								im[5]=ImageIO.read(new File("im6.png"));
								im[6]=ImageIO.read(new File("im7.png"));
								im[7]=ImageIO.read(new File("im8.png"));
								im[8]=ImageIO.read(new File("im9.png"));
								im[9]=ImageIO.read(new File("im10.png"));
							}catch (Exception e1) {};
							panneau.setPreferredSize(new Dimension(605, 485));
							add(panneau,BorderLayout.CENTER);

						    
						    
						    
						    p1=new JPanel(new BorderLayout());
						    p1.setPreferredSize(new Dimension(605, 100));
							
							p2=new JPanel();
							t1=new JLabel("Nombre de coups");
							t1.setPreferredSize(new Dimension(230, 35));
							t1.setBorder(BorderFactory.createLoweredBevelBorder());
							t1.setForeground(Color.BLUE);
							t2=new JLabel("0",JLabel.CENTER);
							t2.setPreferredSize(new Dimension(35, 35));
							t2.setBorder(BorderFactory.createLoweredBevelBorder());
							t2.setOpaque(true);
							t2.setBackground(Color.BLUE);
							t2.setForeground(Color.WHITE);
							p2.add(t1);
							p2.add(t2);
							
							p3=new JPanel();
							t3=new JLabel("Nombre de paires découvertes");
							t3.setForeground(Color.BLUE);
							t3.setPreferredSize(new Dimension(230, 35));
							t3.setBorder(BorderFactory.createLoweredBevelBorder());
							t4=new JLabel("0",JLabel.CENTER);
							t4.setPreferredSize(new Dimension(35, 35));
							t4.setBorder(BorderFactory.createLoweredBevelBorder());
							t4.setOpaque(true);
							t4.setBackground(Color.BLUE);
							t4.setForeground(Color.WHITE);
							p3.add(t3);
							p3.add(t4);
							p1.add(p2,BorderLayout.CENTER);
							p1.add(p3,BorderLayout.SOUTH);
							add(p1,BorderLayout.SOUTH);
							
							validate();
							repaint();
							
						}
					});
    				b1.setPreferredSize(new Dimension(90,30));
    				b1.setBorder(BorderFactory.createRaisedBevelBorder());
    				c.insets=new Insets(5,30,5,30);
    				c.gridheight=1;
    				c.gridx=1;
    				c.gridy=0;
    				p1.add(b1,c);
    				
    				b2=new JButton("Non");
    				b2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							dispose();	
						}
					});
    				b2.setPreferredSize(new Dimension(90,30));
    				b2.setBorder(BorderFactory.createRaisedBevelBorder());
    				c.insets=new Insets(5,30,5,30);
    				c.gridheight=1;
    				c.gridx=1;
    				c.gridy=1;
    				p1.add(b2,c);
    				
    				add(p1,BorderLayout.SOUTH);
    				validate();
    				repaint();
    			}
    	

    			  
    	}
    }
}

class Rand{
	private int ord1[]={1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9,10,10};
	public int index=20;    
    public int data[]=new int[20];
    
	
    public int[] rand()
    {
        for(int i=0;i<20;i++)
        {
            int tt=(int)((Math.random())*index);
            data[i]=ord1[tt];
            rem(tt);
            index-=1;
        }	
        return data;
    }

    public void rem(int pos)
    {
        for(int i=pos;i<ord1.length-2;i++)
        {
            ord1[i]=ord1[i+1];
        }
    }
	
}

