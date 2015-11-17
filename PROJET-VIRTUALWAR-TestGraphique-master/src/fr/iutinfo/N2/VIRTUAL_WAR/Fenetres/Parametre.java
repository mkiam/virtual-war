package fr.iutinfo.N2.VIRTUAL_WAR.Fenetres;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Parametre extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton obstacle, ia, choixmusique, son, musique, touche, retour;
	private JLabel titre, vide;
	private JComboBox<String> lvlia, listemusique, sononoff, musiqueonoff;

	public Parametre() {
		super("Parametre de jeu");
		setSize(500, 300);
		setVisible(true);
		GridBagLayout g = new GridBagLayout();
		setLayout(g);
		GridBagConstraints c1 = new GridBagConstraints();
		c1.fill = GridBagConstraints.VERTICAL;

		// titre
		titre = new JLabel("Reglage des parametres");
		c1.gridx = 1;
		c1.gridy = 0;
		getContentPane().add(titre, c1);
		c1.ipadx = 70;
		c1.ipady = 40;

		c1.insets = new Insets(20, 20, 20, 20);

		// titre
		vide = new JLabel(" ");
		c1.gridx = 0;
		c1.gridy = 0;
		getContentPane().add(vide, c1);

		// bouton obstacle
		obstacle = new JButton("Nombre d'obstacle sur le plateau");
		c1.ipadx = 150;
		c1.ipady = 20;
		c1.gridx = 1;
		c1.gridy = 1;
		c1.gridheight = 1;
		c1.gridwidth = 1;
		c1.ipadx = 70;
		c1.ipady = 20;
		add(obstacle, c1);

		// bouton ia
		ia = new JButton("Niveau de l'IA");
		c1.ipadx = 150;
		c1.ipady = 20;
		c1.gridx = 1;
		c1.gridy = 2;
		c1.gridheight = 1;
		c1.gridwidth = 1;
		c1.ipadx = 185;
		c1.ipady = 20;
		add(ia, c1);

		// JtextField lvlia
		lvlia = new JComboBox<String>();
		lvlia.addItem("facile");
		lvlia.addItem("moyen");
		lvlia.addItem("difficile");
		c1.ipadx = 95;
		c1.ipady = 20;
		c1.gridx = 2;
		c1.gridy = 2;
		add(lvlia, c1);

		// bouton choixmusique
		choixmusique = new JButton("Choix de la musique");
		c1.ipadx = 150;
		c1.ipady = 20;
		c1.gridx = 1;
		c1.gridy = 4;
		c1.gridheight = 1;
		c1.gridwidth = 1;
		add(choixmusique, c1);

		// JComboBox humain
		listemusique = new JComboBox<String>();
		listemusique.addItem("rock");
		listemusique.addItem("metal");
		listemusique.addItem("rap");
		listemusique.addItem("classique");
		c1.ipadx = 80;
		c1.ipady = 20;
		c1.gridx = 2;
		c1.gridy = 4;
		add(listemusique, c1);

		// bouton son on/off
		son = new JButton("Son");
		c1.ipadx = 150;
		c1.ipady = 20;
		c1.gridx = 1;
		c1.gridy = 5;
		c1.gridheight = 1;
		c1.gridwidth = 1;
		c1.ipadx = 245;
		c1.ipady = 20;
		add(son, c1);

		// JtextField sononoff
		sononoff = new JComboBox<String>();
		sononoff.addItem("on");
		sononoff.addItem("off");
		c1.ipadx = 121;
		c1.ipady = 20;
		c1.gridx = 2;
		c1.gridy = 5;
		add(sononoff, c1);

		// bouton musique on/off
		musique = new JButton("Musique");
		c1.ipadx = 150;
		c1.ipady = 20;
		c1.gridx = 1;
		c1.gridy = 3;
		c1.gridheight = 1;
		c1.gridwidth = 1;
		c1.ipadx = 220;
		c1.ipady = 20;
		add(musique, c1);

		// JtextField musiqueonoff
		musiqueonoff = new JComboBox<String>();
		musiqueonoff.addItem("on");
		musiqueonoff.addItem("off");
		c1.ipadx = 121;
		c1.ipady = 20;
		c1.gridx = 2;
		c1.gridy = 3;
		add(musiqueonoff, c1);

		// bouton touche
		touche = new JButton("Definir touche de jeu");
		c1.ipadx = 150;
		c1.ipady = 20;
		c1.gridx = 1;
		c1.gridy = 6;
		c1.gridheight = 1;
		c1.gridwidth = 1;
		add(touche, c1);

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
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		new Parametre();
	}
}
