import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class ExoTP3 {

public static void main(String[] args) { 

 EventQueue.invokeLater(new Runnable() { 
	public void run() { 
		FrameSquelette1  f = new FrameSquelette1 ("TP2 à compléter ");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setVisible(true);  
	}
 }); 
}
}

class FrameSquelette1 extends JFrame{
	private JPanel p;
	private JLabel titre,nom,adresse,paiement,ville,code;
	private JTextField nomField,adresseField,villeField,codeField;
	private JComboBox modePaiement;
	private String[] str= {"Mastercard","CreditCard","Paypal"};
	
	
	public FrameSquelette1(String ti) {
		super(ti);
		p=new JPanel(new GridBagLayout());
		p.setBackground(Color.yellow);
		GridBagConstraints gbc=new GridBagConstraints();
		
		titre=new JLabel("Achetez maintenant!");
		nom=new JLabel("Nom:");
		adresse=new JLabel("Adresse:");
		paiement=new JLabel("Mode de paiement");
		ville=new JLabel("Ville:");
		code=new JLabel("Code:");
		
		nomField=new JTextField(30);
		adresseField=new JTextField(30);
		villeField=new JTextField(15);
		codeField=new JTextField(5);
		
		modePaiement=new JComboBox(str);
		modePaiement.setMaximumRowCount(3);
		
		titre.setFont(new Font("Times-Roman",Font.BOLD+Font.ITALIC,16));
		
		gbc.gridwidth=GridBagConstraints.REMAINDER;
		gbc.insets=new Insets(5,0,10,0);
		p.add(titre,gbc);
		
		
	    gbc.gridwidth=GridBagConstraints.WEST;
	    gbc.insets=new Insets(0,5,0,5);
	    gbc.anchor=GridBagConstraints.WEST;
		gbc.gridwidth=1;
		p.add(nom, gbc);
		
		nomField.setFont(new Font(null,0,30));
		gbc.gridwidth=GridBagConstraints.REMAINDER;
		p.add(nomField,gbc);
		
		gbc.gridwidth=1;
	    p.add(adresse,gbc);
	    
	    
	    adresseField.setFont(new Font(null,0,30));
	    gbc.gridwidth=GridBagConstraints.REMAINDER;
	    p.add(adresseField,gbc);
		
	    gbc.gridwidth=1;
	    p.add(ville,gbc);
	    
	    
	    villeField.setFont(new Font(null,0,15));
	    gbc.gridwidth=1;
	    p.add(villeField,gbc);
	    
	    gbc.gridwidth=1;
	    p.add(code,gbc);
	    
	    codeField.setFont(new Font(null,0,5));
	    gbc.gridwidth=GridBagConstraints.REMAINDER;
	    p.add(codeField,gbc);
	    
	    gbc.gridwidth=1;
	    p.add(paiement,gbc);
	    
	    gbc.gridwidth=1;
	    p.add(modePaiement,gbc);
	    
	    add(p);
	}
}