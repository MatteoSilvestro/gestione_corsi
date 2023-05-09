package Frameprincipale;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Back.GestioneDB;

public class Ricerca  extends JFrame implements ActionListener  {
	
	JLabel bloccoLabel = new JLabel("Blocco orario");
	String[] opzioniBlocco = {""};
	JComboBox bloccoComboBox = new JComboBox(opzioniBlocco);
		
		JLabel professoreLabel = new JLabel("Professore");
		String[] opzioniProfessore = {""};
		JComboBox professoreComboBox = new JComboBox(opzioniProfessore);

		JLabel aulaLabel = new JLabel("Aula");
		String[] opzioniAula = {""};
		JComboBox aulaComboBox = new JComboBox(opzioniAula);
		
		JButton b1 = new JButton ("CERCA");
		JButton b2 = new JButton ("INDIETRO");

	public Ricerca (){
		
		this.add(bloccoLabel);
		this.add(bloccoComboBox);
		this.add(professoreLabel);
		this.add(professoreComboBox);
		this.add(aulaLabel);
		this.add(aulaComboBox);
		this.add(b1);
		this.add(b2);
		
		ResultSet item=GestioneDB.GetInsegnanti(); //hy
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
		
				System.out.println(itemBlocco.getInt(5));
				bloccoComboBox.addItem(itemBlocco.getInt(5));
	
			}
		}catch(SQLException ex) {

			ex.printStackTrace();

		}
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		
		this.setLayout(new GridLayout(4,2));
		this.setTitle("Ricerca");
		this.setSize(500,500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) {
			try {
			if(bloccoComboBox.getSelectedIndex()==0 && professoreComboBox.getSelectedItem().toString().split(" ")[0].equals("") && aulaComboBox.getSelectedItem().toString().split(" ")[0].equals("")) {
				JOptionPane.showMessageDialog(null, "Tutti i campi sono obbligatori!", "ERRORE", JOptionPane.ERROR_MESSAGE);}
				
				else {
					//System.out.println(Integer.parseInt(opzioniBlocco[bloccoComboBox.getSelectedIndex()]),Integer.parseInt(professoreComboBox.getSelectedItem().toString().split(" ")[0]),Integer.parseInt(aulaComboBox.getSelectedItem().toString().split(" ")[0]));
					GestioneDB.GetRicerca(Integer.parseInt(opzioniBlocco[bloccoComboBox.getSelectedIndex()]),Integer.parseInt(professoreComboBox.getSelectedItem().toString().split(" ")[0]),Integer.parseInt(aulaComboBox.getSelectedItem().toString().split(" ")[0]));
				}
			}catch(Exception er) {JOptionPane.showMessageDialog(null, "Inserire i campi correttamente", "ERRORE", JOptionPane.ERROR_MESSAGE);}
		}
		else if(e.getSource()==b2) {
			MyFrame frame = new MyFrame();
			this.dispose();
		}
		
	}

}
