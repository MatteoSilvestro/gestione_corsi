package Frameprincipale;


import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

import Back.GestioneDB;

public class Corso  extends JFrame implements ActionListener{

	JLabel desc = new JLabel("Descrizione");
	JTextField t1 = new JTextField();
	JLabel l1 = new JLabel("Insegnanti");
	String opzioniIns[]= {"","","",""};
	JComboBox ins = new JComboBox(opzioniIns);
	JLabel l2 = new JLabel("Classi");
	String opzioniCl[]= {"",""};
	JComboBox cl = new JComboBox(opzioniCl);
	JLabel l3 = new JLabel("Blocco");
	String opzioniBl[]= {"",""};
	JComboBox bl = new JComboBox(opzioniBl);	
	JButton b1 = new JButton ("INSERISCI");
	JButton b2 = new JButton ("INDIETRO");
	
	public Corso() {
			
			this.add(desc);
			this.add(t1);
			this.add(l1);
			this.add(ins);
			this.add(l2);
			this.add(cl);
			this.add(l3);
			this.add(bl);
			this.add(b1);
			this.add(b2);
			
			
			b1.addActionListener(this);
			b2.addActionListener(this);
			
			this.setLayout(new GridLayout(5,2));

			this.setTitle("Corso");
			this.setSize(500,500);
			this.setVisible(true);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		}

	


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) {
			
		}
		else if(e.getSource()==b2) {
			MyFrame frame = new MyFrame();
			this.dispose();
		}
			
		
}}