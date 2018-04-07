import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class TP2_squelette {

public static void main(String[] args) { 

 EventQueue.invokeLater(new Runnable() { 
	public void run() { 
		FrameSquelette  f = new FrameSquelette ("TP2 à compléter ");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setVisible(true);  
	}
 }); 
}
}

/**
 * la Classe FrameSquelette permet de construire l'interface graphique demandée 
 * dans l'exercice 1 - gestion des évènements clavier -
 * 
 */
class FrameSquelette extends JFrame implements ActionListener {
	   
	private Border raisedbevel;
	private Pan panneau;
	private int[][] t; //Tableau représentant la grille des cases visitées
	private int x,y;   //Coordonnées du point courant
    private JPanel p2,p3,p4,p5,p6;
    private JLabel l1,l2,l3,l4;
    private JButton b1,b2,b3,b4,b5,b6;
    private int score=10; 
    private boolean bb=true;
    private int max=0;
	
 
	/**
	*  Constructeur permettant de créer l'interface graphique demandée - A COMPLETER
	* @param titre 
	*	titre de la fenêtre
	*/ 		
	public FrameSquelette(String titre){
		super(titre);
		
		t=new int[10][25]; //Initialisation du tableau des cases visitées
		for(int i=0;i<10;i++)
			for(int j=0;j<25;j++)
				t[i][j]=0;
		t[0][0]=1;		//Première case visitée
		x=0;y=0;		//Initialisation du point courant
		
		raisedbevel = BorderFactory.createRaisedBevelBorder();
	
		panneau=new Pan();
		panneau.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e){    
				if (e.getKeyCode()==KeyEvent.VK_LEFT){
					if(x>=20) x-=20;

				}
				else if (e.getKeyCode()==KeyEvent.VK_RIGHT){
						if(x<=460)	x+=20;	

					}
					else if (e.getKeyCode()==KeyEvent.VK_DOWN){
							if(y<=160) y+=20;	

						}	
						else if (e.getKeyCode()==KeyEvent.VK_UP){
								if(y>=20) y-=20 ;

							}
				
				if(t[y/20][x/20]==1 )
	                score-=100;
	            else
	                score+=10;
	            l2.setText("Votre score: "+score);			

				t[y/20][x/20]=1;
				panneau.repaint();
				bb=true;
			    for(int i=0;i<10;i++)
					for(int j=0;j<25;j++)	
						if(t[i][j]==0) bb=false;
                  
				
				if(bb)
				{
					if(score>max)
						max=score;
					score=10;
					remove(panneau);
					remove(p2);
					p3=new JPanel(new BorderLayout());
					p3.setBorder(new EmptyBorder(15, 15, 15, 15));
					p4=new JPanel();
					l3=new JLabel("Fin de partie",JLabel.CENTER);
					l4=new JLabel("Vous-vous rejouer",JLabel.CENTER);
					b5=new JButton("Oui");
					b5.addActionListener(new ActionListener() {

						public void actionPerformed(ActionEvent e) {
							remove(p3);
							t=new int[10][25]; 
							for(int i=0;i<10;i++)
								for(int j=0;j<25;j++)
									t[i][j]=0;
							t[0][0]=1;		//Première case visitée
							x=0;y=0;
							l1.setText("Meilleur score : "+max);
							l2.setText("Votre score : 10");
							add(panneau,BorderLayout.CENTER);
							add(p2,BorderLayout.EAST);
							panneau.requestFocus();
							validate();
							repaint();
						}
						
					});
					b6=new JButton("Non");	
					b6.addActionListener(new ActionListener() {

						public void actionPerformed(ActionEvent e) {
		                    dispose();
						}
						
					});
					p4.add(b5);
					p4.add(b6);
					p3.add(l3,BorderLayout.NORTH);
					p3.add(l4,BorderLayout.CENTER);
                    p3.add(p4,BorderLayout.SOUTH);
					add(p3);
					validate();
					repaint();
			    }


				
				    
			}	
		}); 
		
		panneau.setFocusable(true);   //Permet de donner le focus à panneau
		panneau.setPreferredSize(new Dimension(500,210));
	    
		this.add(panneau,BorderLayout.CENTER); //A COMPLETER
		
        p2=new JPanel(new GridBagLayout());
        GridBagConstraints c=new GridBagConstraints();
        p2.setBorder(raisedbevel);
        
       
        

        l1=new JLabel("Meilleur sorce : 0",JLabel.CENTER);
        c.insets=new Insets(10,5,10,5);
        l1.setBorder(raisedbevel);
        c.ipadx=25;
        c.gridwidth=GridBagConstraints.REMAINDER;
        c.gridx=0;
        c.gridy=0;
        p2.add(l1,c);
        
        
        b1=new JButton("Haut");
        c.insets=new Insets(5,1,5,1);
        c.gridwidth=2;
        c.gridx=1;
        c.gridy=1;
        p2.add(b1,c);
        b1.addActionListener(this);
   
        
        b2=new JButton("Gauche");
        c.gridwidth=2;
        c.gridx=0;
        c.gridy=2;
        p2.add(b2,c);
        b2.addActionListener(this);
        
        
        b3=new JButton("Droite");
        c.gridwidth=2;
        c.gridx=2;
        c.gridy=2;
        p2.add(b3,c);
        b3.addActionListener(this);
        
        
        b4=new JButton("Bas");
        c.gridwidth=2;
        c.gridx=1;
        c.gridy=3;
        p2.add(b4,c);
        b4.addActionListener(this);
        

        
        l2=new JLabel("Votre score : 10",JLabel.CENTER);   
        c.insets=new Insets(20,20,20,20);
        c.ipadx=25;
        l2.setBorder(raisedbevel);
        c.gridwidth=GridBagConstraints.REMAINDER;
        c.gridx=0;
        c.gridy=4;
        p2.add(l2,c);
        
       
        this.add(p2,BorderLayout.EAST);
        p5=panneau;
        p6=p2;
        
	}

	public void actionPerformed(ActionEvent e) {
		Object source=e.getSource();
		if(source.equals(b1)) 
			if(y>=20) y-=20;


		if(source.equals(b2))
			if(x>=20) x-=20;
			

		if(source.equals(b3))
			if(x<=460) x+=20;



		if(source.equals(b4))
			if(y<=160) y+=20;

			
		
		if(t[y/20][x/20]==1 )
            score-=100;
        else
            score+=10;
        l2.setText("Votre score: "+score);
        t[y/20][x/20]=1;
		panneau.repaint();
		bb=true;
	    for(int i=0;i<10;i++)
			for(int j=0;j<25;j++)	
				if(t[i][j]==0) bb=false;
          
		
		if(bb)
		{
			if(score>max)
				max=score;
			score=10;
			remove(panneau);
			remove(p2);
			p3=new JPanel(new BorderLayout());
			p3.setBorder(new EmptyBorder(15, 15, 15, 15));
			p4=new JPanel();
			l3=new JLabel("Fin de partie",JLabel.CENTER);
			l4=new JLabel("Vous-vous rejouer",JLabel.CENTER);
			b5=new JButton("Oui");
			b5.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					remove(p3);
					t=new int[10][25]; 
					for(int i=0;i<10;i++)
						for(int j=0;j<25;j++)
							t[i][j]=0;
					t[0][0]=1;		//Première case visitée
					x=0;y=0;
					l1.setText("Meilleur score : "+max);
					l2.setText("Votre score : 10");
					
					add(panneau,BorderLayout.CENTER);
					add(p2,BorderLayout.EAST);
					validate();
					repaint();

				}
				
			});
			b6=new JButton("Non");
			b6.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
                    dispose();
				}
				
			});
			p4.add(b5);
			p4.add(b6);
			p3.add(l3,BorderLayout.NORTH);
			p3.add(l4,BorderLayout.CENTER);
            p3.add(p4,BorderLayout.SOUTH);
			add(p3);
			validate();
			repaint();
	    }
		
        panneau.setFocusable(true);
        panneau.requestFocus();
        panneau.repaint();	
	}
	
/**
 * la Classe Pan correspond au JPanel dans lequel le dessin des traces du disque 
 * ainsi que le disque jaune sont réalisés
 * 
 */	
class Pan extends JPanel { 

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(Color.BLUE);
		g.setColor(Color.YELLOW);
		g.fillOval(x,y,19,19);	
			
		for(int i=0;i<10;i++)
			for(int j=0;j<25;j++)
				if(t[i][j]==1) 
				
					g.fillOval(20*j+10,20*i+10,5,5);

				// Si une case a été visitée, dessiner un rond jaune
	}
	
}

}
