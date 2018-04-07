import java.awt.*;      
import javax.swing.*;
import java.awt.event.*;   
import javax.swing.border.*;

 
 public class Exo1TP1Squelette {
   
public static void main(String[] args) { 

 EventQueue.invokeLater(new Runnable() { 
	public void run() { 
		Frame_Exo1TP f = new Frame_Exo1TP("Questionnaire");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setVisible(true);  
	}
 }); 
}

}


/**
 * la Classe Frame_Exo1TP1 permet de construire l'interface graphique demandée 
 * dans l'exercice 1 - gestion des évènements sur les deux boutons
 * 
 */
class Frame_Exo1TP extends JFrame implements ActionListener{
	private JPanel p1,p2,p3,p4;
	private JButton b1,b2;
	private JCheckBox jcb1,jcb2,jcb3,jcb4,jcb5,jcb6;
	private JLabel j1,j2,j3;
	private JTextField jt1,jt2;
	private JRadioButton jrb1,jrb2;
	private String s="";
	private JLabel IMess;
	private ButtonGroup group;
	
/**
*  Constructeur permettant de créer l'interface graphique demandée
* @param titre 
*	titre de la fenêtre
*/ 	
 public Frame_Exo1TP(String titre){
	super(titre);
	p2=new JPanel(new GridLayout(6,0));
	p2.setBorder(BorderFactory.createLoweredBevelBorder());
	jcb1=new JCheckBox("Tennis");
	jcb2=new JCheckBox("Natation");
	jcb3=new JCheckBox("Athétisme");
	jcb4=new JCheckBox("Foot");
	jcb5=new JCheckBox("Randonnée");
	jcb6=new JCheckBox("Basket");
    p2.add(jcb1);
    p2.add(jcb2);
    p2.add(jcb3);
    p2.add(jcb4);
    p2.add(jcb5);
    p2.add(jcb6);
    
    p1=new JPanel(new GridLayout(5,0));
    p1.setBorder(new EmptyBorder(15,15,15,15));
	j1=new JLabel("Nom");
	jt1=new JTextField(10);
	j2=new JLabel("Prenom");
	jt2=new JTextField(10);
	
	p4=new JPanel();
	j3=new JLabel("Sexe");
	jrb1=new JRadioButton("Femme");
	jrb2=new JRadioButton("Homme");
    group=new ButtonGroup();
    group.add(jrb1);
    group.add(jrb2);
	
	p4.add(j3);
	
	p4.add(jrb1);
	p4.add(jrb2);
	
	p1.add(j1);
	p1.add(jt1);
	p1.add(j2);
	p1.add(jt2);
	p1.add(p4);

    p3=new JPanel();
	b1=new JButton("OK");
	b1.addActionListener(this);
	b2=new JButton("Annuler");
	b2.addActionListener(this);
	p3.add(b1);
	p3.add(b2);
	
	add(p1,BorderLayout.CENTER);
	add(p2,BorderLayout.EAST);
	add(p3,BorderLayout.SOUTH);
	}
 
    public void actionPerformed(ActionEvent e)
    {
    	Object source=e.getSource();
    	if(source.equals(b1))
    	{
    		if(jcb1.isSelected())
    			s=s+"Tennis ";
    		if(jcb2.isSelected())
    			s=s+"Natation ";
    		if(jcb3.isSelected())
        		s=s+"Athétisme ";
        	if(jcb4.isSelected())
            	s=s+"Foot ";
            if(jcb5.isSelected())
                s=s+"Randonnées ";
            if(jcb6.isSelected())
                s=s+"Basket ";
            remove(p1);
            remove(p2);
            remove(p3);
            IMess=new JLabel();
            IMess.setText(s);
            p4=new JPanel();            
            p4.add(IMess);
            add(p4);
            validate();
            repaint(); 
           
            
           
            
         
    	}	
    	if(source.equals(b2))
    	{
    		jt1.setText("");
    		jt2.setText("");
            group.clearSelection();
    		jcb1.setSelected(false);
    		jcb2.setSelected(false);
    		jcb3.setSelected(false);
    		jcb4.setSelected(false);
    		jcb5.setSelected(false);
    		jcb6.setSelected(false);
    	}
    	
    }
	
}

	


 


     

