package Frameprincipale;


import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

import Back.GestioneDB;

public class Corso  extends JFrame implements ActionListener{

	JLabel titoloLabel = new JLabel("Titolo");
	JTextField titoloTextField = new JTextField();

	JLabel capienzaLabel = new JLabel("Capienza");
	JTextField capienzaTextField = new JTextField();

	JLabel descrizioneLabel = new JLabel("Descrizione");
	JTextField descrizioneTextField = new JTextField();

	JLabel bloccoLabel = new JLabel("Blocco orario");
	String[] opzioniBlocco = {"-","1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"};
	JComboBox bloccoComboBox = new JComboBox(opzioniBlocco);

	JLabel destinatariLabel = new JLabel("Destinatari");
	JTextField destinatariTextField = new JTextField();

	JLabel professoreLabel = new JLabel("Professore");
	String[] opzioniProfessore = {""};
	JComboBox professoreComboBox = new JComboBox(opzioniProfessore);

	JLabel aulaLabel = new JLabel("Aula");
	String[] opzioniAula = {""};
	JComboBox aulaComboBox = new JComboBox(opzioniAula);

	JButton b1 = new JButton("INSERISCI");
	JButton b2 = new JButton("INDIETRO");
	
	public Corso() {
			
			this.add(titoloLabel);
			this.add(titoloTextField);
			this.add(capienzaLabel);
			this.add(capienzaTextField);
			this.add(descrizioneLabel);
			this.add(descrizioneTextField);
			this.add(bloccoLabel);
			this.add(bloccoComboBox);
			this.add(destinatariLabel);
			this.add(destinatariTextField);
			this.add(professoreLabel);
			this.add(professoreComboBox);
			this.add(aulaLabel);
			this.add(aulaComboBox);
			this.add(b1);
			this.add(b2);
			
			ResultSet item=GestioneDB.GetInsegnanti();
			try {
				while(item.next()) {
			
					System.out.println(item.getInt(1)+item.getString(2)+" "+item.getString(3)+" "+item.getString(4)+" "+item.getString(5)+" "+item.getInt(6));
					professoreComboBox.addItem(Integer.toString(item.getInt(1))+" "+item.getString(2)+" "+item.getString(3)+" "+item.getString(4)+" "+item.getString(5)+" "+Integer.toString(item.getInt(6)));
		
				}
			}catch(SQLException ex) {

				ex.printStackTrace();

			}
			ResultSet itemAula=GestioneDB.GetAula();
			try {
				while(itemAula.next()) {
			
					System.out.println(itemAula.getInt(1)+" "+itemAula.getInt(2)+" "+itemAula.getString(3));
					aulaComboBox.addItem(Integer.toString(itemAula.getInt(1))+" "+itemAula.getString(3)+" "+Integer.toString(itemAula.getInt(2)));
		
				}
			}catch(SQLException ex) {

				ex.printStackTrace();

			}
			
			b1.addActionListener(this);
			b2.addActionListener(this);
			
			this.setLayout(new GridLayout(8,2));

			bloccoComboBox.setSelectedIndex(0);
			professoreComboBox.setSelectedIndex(0);
			aulaComboBox.setSelectedIndex(0);
			
			this.setTitle("Corso");
			this.setSize(500,500);
			this.setVisible(true);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) {
			try {
			if(titoloTextField.getText().equals("") || capienzaTextField.getText().equals("")|| descrizioneTextField.getText().equals("") || bloccoComboBox.getSelectedIndex()==0 || destinatariTextField.getText().equals("") || aulaComboBox.getSelectedItem().toString().split(" ")[0].equals("") || professoreComboBox.getSelectedItem().toString().split(" ")[0].equals("")) {
				JOptionPane.showMessageDialog(null, "Tutti i campi sono obbligatori!", "ERRORE", JOptionPane.ERROR_MESSAGE);}
				
				else {
					GestioneDB.InsertCorsi(titoloTextField.getText(), Integer.parseInt(capienzaTextField.getText()),descrizioneTextField.getText(),Integer.parseInt(opzioniBlocco[bloccoComboBox.getSelectedIndex()]),destinatariTextField.getText(),Integer.parseInt(professoreComboBox.getSelectedItem().toString().split(" ")[0]),Integer.parseInt(aulaComboBox.getSelectedItem().toString().split(" ")[0]));
					}
			}catch(Exception er) {JOptionPane.showMessageDialog(null, "Inserire i campi correttamente", "ERRORE", JOptionPane.ERROR_MESSAGE);}
		}
		else if(e.getSource()==b2) {
			MyFrame frame = new MyFrame();
			this.dispose();
		}
			
		
}}