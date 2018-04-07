import java.awt.*;      
import javax.swing.*;
import java.awt.event.*;   
import javax.swing.border.*;

 
 public class Exo2TP1Squelette {
   
public static void main(String[] args) { 

 EventQueue.invokeLater(new Runnable() { 
	public void run() { 
		Frame_Exo1TP1 f = new Frame_Exo1TP1 ("Questionnaire");
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
class Frame_Exo1TP1 extends JFrame implements ActionListener{
	private JPanel p1,pb;
	private JComboBox cb;
	private JTextField j1,j2;
	private JButton b1;
	private String[] cal= {"+","-","*","/"};
	private JLabel Imess;
	private double d1,d2;
 
/**
*  Constructeur permettant de créer l'interface graphique demandée
* @param titre 
*	titre de la fenêtre
*/ 	
 public Frame_Exo1TP1(String titre){
	    super(titre);
	    b1=new JButton("Calcul");
	    b1.addActionListener(this);
	    
	    cb=new JComboBox(cal);
	    cb.setMaximumRowCount(4);

	    j1=new JTextField(10);
	    
	    j2=new JTextField(10);
	    
	    p1=new JPanel();
	    p1.add(j1);
	    p1.add(cb);
	    p1.add(j2);
	    p1.add(b1);
	    Imess=new JLabel("Résultat:0",SwingConstants.CENTER);
	    pb=new JPanel(new BorderLayout());
	    pb.add(p1,BorderLayout.NORTH);
	    pb.add(Imess,BorderLayout.CENTER);
	    add(pb);
	    
	    
	
	}
  public void actionPerformed(ActionEvent e) {
	  d1=(Double.valueOf(j1.getText()).doubleValue());
	  d2=(Double.valueOf(j2.getText()).doubleValue());
	  String calname=(String)cb.getSelectedItem();
	  Object source=e.getSource();
	  if (source.equals(b1))
	  {
		  if(calname.equals("*"))
			  Imess.setText("Resulat:"+(d1*d2));
		  else if (calname.equals("/"))
			      if(d2==0.0)
			    	  Imess.setText("ll y a une erreur de diviser par 0");
			      else
			          Imess.setText("Resulat:"+(d1/d2));
		  else if (calname.equals("+"))
			  Imess.setText("Resulat:"+(d1+d2));
		  else if (calname.equals("-"))
			  Imess.setText("Resulat:"+(d1-d2));
	  }	  
  }	
}

