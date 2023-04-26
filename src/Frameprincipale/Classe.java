package Frameprincipale;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

import Back.GestioneDB;

public class Classe extends JFrame implements ActionListener{
	JLabel desc = new JLabel("Descrizione");
	JTextField t1 = new JTextField();
	JLabel cap = new JLabel("Capienza");
	JTextField t2 = new JTextField();
	JButton b1 = new JButton ("INSERISCI");
	JButton b2 = new JButton ("INDIETRO");
	JPanel p1 = new JPanel();
	
	public Classe() {
		
		this.add(desc);
		this.add(t1);
		this.add(cap);
		this.add(t2);
		this.add(b1);
		this.add(b2);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		this.setLayout(new GridLayout(3,2));

		this.setTitle("Classe");
		this.setSize(500,500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) {
			try {
			GestioneDB.InsertClasse(t1.getText(), Integer.parseInt(t2.getText()));
			}catch(Exception err) {}
		}
		else if(e.getSource()==b2) {
			MyFrame frame = new MyFrame();
			this.dispose();
		}
			
		
	}

}
