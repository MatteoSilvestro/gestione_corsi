package Frameprincipale;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

import Back.GestioneDB;

public class Ricerca  extends JFrame implements ActionListener  {
	
		JPanel p1 = new JPanel();
	
		JLabel bloccoLabel = new JLabel("Blocco orario");
		String[] opzioniBlocco = {""};
		JComboBox bloccoComboBox = new JComboBox(opzioniBlocco);
		
		JLabel professoreLabel = new JLabel("Professore");
		String[] opzioniProfessore = {""};
		JComboBox professoreComboBox = new JComboBox(opzioniProfessore);
		
		JLabel aulaLabel = new JLabel("Aule");
		String[] opzioniAule = {""};
		JComboBox aulaComboBox = new JComboBox(opzioniAule);

		
		JButton b1 = new JButton ("CERCA");
		JButton b2 = new JButton ("INDIETRO");
		
		JTextArea t2 = new JTextArea(5,10);
		JScrollPane scroll = new JScrollPane(t2);
		 
		


	public Ricerca (){
		
		p1.setLayout(new GridLayout(4,2));
		
		p1.add(bloccoLabel);
		p1.add(bloccoComboBox);
		p1.add(professoreLabel);
		p1.add(professoreComboBox);
		p1.add(aulaLabel);
		p1.add(aulaComboBox);
		p1.add(b1);
		p1.add(b2);
		
		
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		t2.setBorder(BorderFactory.createLineBorder(Color.white));
		t2.setEditable(true);

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
	
		ResultSet itemBlocco=GestioneDB.GetBlocco();
		try {
			while(itemBlocco.next()) {
		
				System.out.println(itemBlocco.getInt(1));
				bloccoComboBox.addItem(itemBlocco.getInt(1));
	
			}
		}catch(SQLException ex) {

			ex.printStackTrace();

		}
		
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		this.setLayout(new BorderLayout());
		
		
		this.getContentPane().add(p1, BorderLayout.CENTER);
		this.getContentPane().add(scroll, BorderLayout.SOUTH);
		
		
		
		this.setTitle("Ricerca");
		this.setSize(500,500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) {
			try {
				t2.setText("");
				if(bloccoComboBox.getSelectedIndex()==0 && professoreComboBox.getSelectedItem().toString().split(" ")[0].equals("") && aulaComboBox.getSelectedItem().toString().split(" ")[0].equals("")) {
					JOptionPane.showMessageDialog(null, "Inserire almeno un elemento", "ERRORE", JOptionPane.ERROR_MESSAGE);
					}
				
				else {
					ResultSet item = GestioneDB.GetRicerca(bloccoComboBox.getSelectedItem().toString(),professoreComboBox.getSelectedItem().toString().split(" ")[0],aulaComboBox.getSelectedItem().toString().split(" ")[0]);
					
					while(item.next()) {
						t2.append(""+item.getInt(1)+" "+item.getString(2)+" "+item.getInt(3)+" "+item.getString(4)+" "+item.getInt(5)+" "+item.getString(6)+" "+item.getInt(7)+" "+item.getInt(8)+"\n");
					}
					
					
					
				}
			}catch(Exception er) {JOptionPane.showMessageDialog(null, "Inserire i campi correttamente", "ERRORE", JOptionPane.ERROR_MESSAGE);}
		}
		else if(e.getSource()==b2) {
			MyFrame frame = new MyFrame();
			this.dispose();
		}
		
	}

}
