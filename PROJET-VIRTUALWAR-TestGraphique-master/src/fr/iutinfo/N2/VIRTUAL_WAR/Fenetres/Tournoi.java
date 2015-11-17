package fr.iutinfo.N2.VIRTUAL_WAR.Fenetres;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Tournoi extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton plateau, equipe, robot, texthumain, textparticipant, retour;
	private JLabel titre, vide1;
	private JTextField humain, participant;

	public Tournoi() {
		super("Menu du Tournoi");
		setSize(500, 300);
		setVisible(true);
		GridBagLayout g = new GridBagLayout();
		setLayout(g);
		GridBagConstraints c1 = new GridBagConstraints();
		c1.fill = GridBagConstraints.VERTICAL;

		// titre
		titre = new JLabel("Organiser  Votre  Tournoi !");
		c1.gridx = 1;
		c1.gridy = 0;
		getContentPane().add(titre, c1);
		c1.ipadx = 70;
		c1.ipady = 40;

		c1.insets = new Insets(20, 20, 20, 20);

		// placement des boutons par le vide
		vide1 = new JLabel(" ");
		c1.gridx = 0;
		c1.gridy = 1;
		getContentPane().add(vide1, c1);

		// bouton plateau
		plateau = new JButton("Choix du plateau");
		c1.ipadx = 150;
		c1.ipady = 20;
		c1.gridx = 1;
		c1.gridy = 1;
		c1.gridheight = 1;
		c1.gridwidth = 1;
		add(plateau, c1);

		// bouton texthumain
		texthumain = new JButton("choix du nombre de joueur");
		c1.ipadx = 90;
		c1.ipady = 20;
		c1.gridx = 1;
		c1.gridy = 2;
		c1.gridheight = 1;
		c1.gridwidth = 1;
		texthumain.setEnabled(false);
		add(texthumain, c1);

		// JtextField humain
		humain = new JTextField();
		c1.ipadx = 80;
		c1.ipady = 20;
		c1.gridx = 2;
		c1.gridy = 2;
		add(humain, c1);

		// bouton textparticipant
		textparticipant = new JButton("choix du nombre de participant");
		c1.ipadx = 70;
		c1.ipady = 20;
		c1.gridx = 1;
		c1.gridy = 3;
		c1.gridheight = 1;
		c1.gridwidth = 1;
		textparticipant.setEnabled(false);
		add(textparticipant, c1);

		// JtextField participant
		participant = new JTextField();
		c1.ipadx = 80;
		c1.ipady = 20;
		c1.gridx = 2;
		c1.gridy = 3;
		add(participant, c1);

		// bouton equipe
		equipe = new JButton("Choix des equipes");
		c1.ipadx = 140;
		c1.ipady = 20;
		c1.gridx = 1;
		c1.gridy = 4;
		c1.gridheight = 1;
		c1.gridwidth = 1;
		add(equipe, c1);

		// bouton robot
		robot = new JButton("Choix des robots");
		c1.ipadx = 150;
		c1.ipady = 20;
		c1.gridx = 1;
		c1.gridy = 5;
		c1.gridheight = 1;
		c1.gridwidth = 1;
		add(robot, c1);

		// retour au Menu principale
		retour = new JButton("Retour au Menu Principal");
		c1.ipadx = 2;
		c1.ipady = 20;
		c1.gridx = 4;
		c1.gridy = 7;
		c1.gridheight = 1;
		c1.gridwidth = 1;
		add(retour, c1);

		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		new Tournoi();
	}
}
