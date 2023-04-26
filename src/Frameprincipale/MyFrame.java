package Frameprincipale;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener {

JButton b1 = new JButton("Classi");
JButton b2 = new JButton("Insegnanti");
JButton b3 = new JButton("Corsi");
JButton b4 = new JButton("Esci");
JPanel griglia = new JPanel();
JPanel p1 = new JPanel();
JPanel p2 = new JPanel();
JPanel p3 = new JPanel();
JPanel p4 = new JPanel();


public MyFrame() {

b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);


griglia.setLayout(new GridLayout(4,1));
griglia.add(p1);
griglia.add(p2);
griglia.add(p3);
griglia.add(p4);

p1.add(b1);
p2.add(b2);
p3.add(b3);
p4.add(b4);


b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);

this.getContentPane().add(griglia);
this.setTitle("Progetto");
this.setLayout(new FlowLayout());
this.setSize(500,500);
this.setVisible(true);
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


}


@Override
public void actionPerformed(ActionEvent e) {

	if(e.getSource()==b1) {
	Classe f_aula = new Classe();
	this.dispose();
	}

	else if(e.getSource()==b2) {
	Insegnante f_ins = new Insegnante();
	this.dispose();
	}

	else if(e.getSource()==b3) {
	Corso f_corso = new Corso();
	this.dispose();
	}

	else if(e.getSource()==b4) {
		System.exit(0);
	}

	}
	
}

