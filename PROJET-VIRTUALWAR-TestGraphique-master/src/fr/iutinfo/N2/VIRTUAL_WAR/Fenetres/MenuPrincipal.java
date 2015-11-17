package fr.iutinfo.N2.VIRTUAL_WAR.Fenetres;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.Border;

public class MenuPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	private JButton jouer=new JButton(), tournoi=new JButton();
	private JButton parametre=new JButton(), regle=new JButton();
	private Border b=parametre.getBorder();
	private JComboBox<String> langue;
	private GridBagConstraints c1;
	private JMenuBar menu=new JMenuBar();
	private JMenu fichier=new JMenu("Fichier");
	private JMenuItem quitter=new JMenuItem("Quitter");
	private JLabel titre = new JLabel("Bienvenue dans Virtual_War!");
	private Font f=new Font("Arial", Font.PLAIN, 20);

	public MenuPrincipal() {
		super("Virtual_War - Menu Principal");
		configFrame();
		ajoutComposants();
		addActionListeners();
		setVisible(true);
	}
	private void configFrame() {
		setLayout(new GridBagLayout());
		setLocation(400, 20);
		setSize(500, 700);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
	}
	public void addMenuActionListeners(){
		quitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
	}
	public void addActionListeners(){
		jouer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Configuration(langue.getSelectedIndex());
				dispose();
			}
		});
		jouer.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent arg0) {}
		
			public void mousePressed(MouseEvent arg0) {}
			
			public void mouseExited(MouseEvent arg0) {
				jouer.setBorder(b);
			}
			
			public void mouseEntered(MouseEvent arg0) {
				jouer.setBorder(BorderFactory.createLineBorder(Color.RED));
			}
			
			public void mouseClicked(MouseEvent arg0) {}
		});
		parametre.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent arg0) {}
			
			public void mousePressed(MouseEvent arg0) {}
			
			public void mouseExited(MouseEvent arg0) {
				parametre.setBorder(b);
			}
			
			public void mouseEntered(MouseEvent arg0) {
				parametre.setBorder(BorderFactory.createLineBorder(Color.RED));
			}
			
			public void mouseClicked(MouseEvent arg0) {}
		});
		regle.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent arg0) {}
			
			public void mousePressed(MouseEvent arg0) {}
			
			public void mouseExited(MouseEvent arg0) {
				regle.setBorder(b);
			}
			
			public void mouseEntered(MouseEvent arg0) {
				regle.setBorder(BorderFactory.createLineBorder(Color.RED));
			}
			
			public void mouseClicked(MouseEvent arg0) {}
		});
		tournoi.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent arg0) {}
			
			public void mousePressed(MouseEvent arg0) {}
			
			public void mouseExited(MouseEvent arg0) {
				tournoi.setBorder(b);
			}
			
			public void mouseEntered(MouseEvent arg0) {
				tournoi.setBorder(BorderFactory.createLineBorder(Color.RED));
			}
			
			public void mouseClicked(MouseEvent arg0) {}
		});
		langue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(langue.getSelectedIndex()==0){
					setTitle("Virtual_War - Menu Principal");
					ajoutMenuFr();
					ajoutTitreFR();
					ajoutBoutonJouerFR();
					ajoutBoutonTournoiFR();
					ajoutBoutonParamFR();
					ajoutBoutonReglesFR();
				}
				else{
					setTitle("Virtual_War - Main Menu");
					ajoutMenuEn();
					ajoutTitreEN();
					ajoutBoutonJouerEN();
					ajoutBoutonTournoiEN();
					ajoutBoutonParamEN();
					ajoutBoutonReglesEN();
				}
			}
		});
	}
	public void ajoutMenuFr(){
		menu.remove(fichier);
		setJMenuBar(menu);
		fichier=new JMenu("Fichier");
		quitter=new JMenuItem("Quitter");
		fichier.add(quitter);
		menu.add(fichier);
		setJMenuBar(menu);
		addMenuActionListeners();
	}
	public void ajoutMenuEn(){
		menu.remove(fichier);
		setJMenuBar(menu);
		fichier=new JMenu("File");
		quitter=new JMenuItem("Quit");
		fichier.add(quitter);
		menu.add(fichier);
		setJMenuBar(menu);
		addMenuActionListeners();
	}
	public void ajoutTitreFR(){
		paramInterComposants();
		titre.setText("Bienvenue dans Virtual_War!");
		titre.setFont(f);
		c1.gridx = 1;
		c1.gridy = 0;
		add(titre, c1);
	}
	public void ajoutTitreEN(){
		paramInterComposants();
		titre.setText("Welcome to Virtual_War!");
		c1.gridx = 1;
		c1.gridy = 0;
		add(titre, c1);
	}
	public void ajoutComposants(){
		c1=new GridBagConstraints();
		
		paramInterComposants();
		ajoutTitreFR();
		ajoutMenuFr();
		ajoutWallpaper();
		ajoutChoixLangues();
		ajoutBoutonJouerFR();
		ajoutBoutonTournoiFR();
		ajoutBoutonParamFR();
		ajoutBoutonReglesFR();
	}
	private void ajoutBoutonReglesFR() {
		regle.setText("Regles");
		regle.setFont(f);
		c1.ipadx = 150;
		c1.ipady = 20;
		c1.gridx = 1;
		c1.gridy = 6;
		c1.gridheight = 1;
		c1.gridwidth = 1;
		add(regle, c1);
	}
	private void ajoutBoutonReglesEN() {
		regle.setText("Rules");
	}
	private void ajoutBoutonParamFR() {
		parametre.setText("Parametres");
		parametre.setFont(f);
		c1.ipadx = 125;
		c1.ipady = 20;
		c1.gridx = 1;
		c1.gridy = 5;
		c1.gridheight = 1;
		c1.gridwidth = 1;
		add(parametre, c1);		
	}
	private void ajoutBoutonParamEN() {
		parametre.setText("Settings");
	}
	private void ajoutBoutonTournoiFR() {
		tournoi.setText("Tournoi");
		tournoi.setFont(f);
		c1.gridx = 1;
		c1.gridy = 4;
		c1.gridheight = 1;
		c1.gridwidth = 1;
		add(tournoi, c1);		
	}
	private void ajoutBoutonTournoiEN() {
		tournoi.setText("Tournament");
	}
	private void ajoutBoutonJouerFR() {
		jouer.setText("Jouer");
		jouer.setFont(f);
		c1.ipadx = 150;
		c1.ipady = 20;
		c1.gridx = 1;
		c1.gridy = 3;
		c1.gridheight = 1;
		c1.gridwidth = 1;
		add(jouer, c1);		
	}
	private void ajoutBoutonJouerEN() {
		jouer.setText("Play");
	}
	private void ajoutChoixLangues() {
		langue = new JComboBox<String>();
		langue.setFont(f);
		langue.addItem("Francais");
		langue.addItem("English");
		c1.gridx = 1;
		c1.gridy = 2;
		c1.gridheight = 1;
		c1.gridwidth = 1;
		add(langue, c1);		
	}
	private void ajoutWallpaper() {
	    JLabel wallp= new JLabel(new ImageIcon("ressources/wallp.png"));

		c1.gridx=1;
		c1.gridy=1;
		add(wallp, c1);		
	}
	private void paramInterComposants() {
		c1.fill = GridBagConstraints.VERTICAL;
		c1.ipadx = 30;
		c1.ipady = 10;
		c1.insets = new Insets(8, 8, 8, 8);
		jouer.setPreferredSize(new Dimension(80, 30));
		regle.setPreferredSize(new Dimension(80, 30));
		parametre.setPreferredSize(new Dimension(105, 30));
		tournoi.setPreferredSize(new Dimension(80, 30));
	}
}