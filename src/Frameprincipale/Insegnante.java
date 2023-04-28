package Frameprincipale;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

import Back.GestioneDB;

public class Insegnante  extends JFrame implements ActionListener{

	JLabel nome = new JLabel("Nome");
	JTextField t1 = new JTextField();
	JLabel cognome = new JLabel("Cognome");
	JTextField t2 = new JTextField();
	JLabel ore = new JLabel("Ore");
	JTextField t3 = new JTextField();
	JLabel email = new JLabel("Email");
	JTextField t4 = new JTextField();
	JLabel materia = new JLabel("Materia");
	JTextField t5 = new JTextField();
	JButton b1 = new JButton ("INSERISCI");
	JButton b2 = new JButton ("INDIETRO");
	
	public Insegnante() {
			
			this.add(nome);
			this.add(t1);
			this.add(cognome);
			this.add(t2);
			this.add(ore);
			this.add(t3);
			this.add(email);
			this.add(t4);
			this.add(materia);
			this.add(t5);
			this.add(b1);
			this.add(b2);
			
			
			b1.addActionListener(this);
			b2.addActionListener(this);
			
			this.setLayout(new GridLayout(6,2));

			this.setTitle("Insegnante");
			this.setSize(500,500);
			this.setVisible(true);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		}

	


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) {
			try {
				if(t1.getText().equals("") || t2.getText().equals("")|| t3.getText().equals("")|| t4.getText().equals("")|| t5.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Inserire il campi correttamente", "ERRORE", JOptionPane.ERROR_MESSAGE);
				}
				else {
					GestioneDB.Insert_Insegnanti(t1.getText(), t2.getText(),t4.getText(),Integer.parseInt(t3.getText()),t5.getText());
				}
			
			}catch(Exception er) {JOptionPane.showMessageDialog(null, "Inserire il campi correttamente", "ERRORE", JOptionPane.ERROR_MESSAGE);}
		}
		else if(e.getSource()==b2) {
			MyFrame frame = new MyFrame();
			this.dispose();
		}
			
		
}}