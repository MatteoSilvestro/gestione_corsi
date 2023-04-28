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

		JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        
        buttonPanel.add(b1);
        buttonPanel.add(b2);
        buttonPanel.add(b3);
        buttonPanel.add(b4);

       
        JLabel titleLabel = new JLabel("Gestione Scuola", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
       
        labelPanel.add(titleLabel);

        
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(buttonPanel, BorderLayout.CENTER);
        getContentPane().add(labelPanel, BorderLayout.NORTH);

        b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		
        setTitle("Gestione Corsi");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


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

