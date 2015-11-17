package fr.iutinfo.N2.VIRTUAL_WAR.Fenetres;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

import fr.iutinfo.N2.VIRTUAL_WAR.Partie.Partie;
import fr.iutinfo.N2.VIRTUAL_WAR.Plateau.Plateau;

public class Configuration extends JFrame {
	private static final long serialVersionUID = 1L;
	private JButton valider, retour;
	private JComboBox<String> mode;
	private JComboBox<String>[] robots1, robots2;
	private JComboBox<Integer> jc;
	private List<String> liste1, liste2;
	private JLabel message;
	private JTextField equipe1, equipe2;
	private GridBagConstraints c1;
	private Plateau p;
	private JMenuBar menu;
	private JMenu fichier;
	private JMenuItem quitter;
	private int langue;
	
	@SuppressWarnings("unchecked")
	public Configuration(int langue) {
		super("Configuration");
		robots1=new JComboBox[5];
		robots2=new JComboBox[5];
		liste1=new LinkedList<String>();
		liste2=new LinkedList<String>();
		setLayout(new GridBagLayout());
		setLocation(100, 80);
		setResizable(false);
		ajoutComp();
		addActionListeners();
		getContentPane().setBackground(new Color(150, 180, 200));
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
		setVisible(true);
	}
	public void addActionListeners(){
		retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new MenuPrincipal();
				dispose();
			}
		});
		valider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(int i=0; i<5; i++){
					liste1.add(robots1[i].getSelectedItem().toString());
					liste2.add(robots2[i].getSelectedItem().toString());
				}
				p=new Plateau(10, 10, (int)jc.getSelectedItem());
				dispose();
				new Partie(p, liste1, liste2, mode.getSelectedIndex()+1, equipe1.getText(), equipe2.getText());
			}
		});
		for(int i=0; i<5; i++){
			robots1[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
		}
		for(int i=0; i<5; i++){
			robots2[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
		}
		quitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Random r=new Random();
				
				if(mode.getSelectedIndex()==1){
					equipe2.setText("IA");
					equipe2.setEditable(false);
					for(int i=0; i<5; i++){
						robots2[i].setSelectedIndex(r.nextInt(3)+1);
						robots2[i].setEnabled(false);
					}
				}
				else{
					equipe2.setEditable(true);
					equipe2.setText("");
					for(int i=0; i<5; i++){
						robots2[i].setSelectedIndex(0);
						robots2[i].setEnabled(true);
					}
				}
			}
		});
		equipe1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		equipe2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
	public Plateau getPlateau(){
		return p;
	}
	public void ajoutComp(){
		menu=new JMenuBar();
		fichier=new JMenu("Fichier");
		quitter=new JMenuItem("Quitter");
		Font f=new Font("Times New Roman", Font.BOLD, 16);
		c1 = new GridBagConstraints();
		c1.fill = GridBagConstraints.VERTICAL;
				
		// gestion de l'espace inter-composants
		c1.ipadx = 30;
		c1.ipady = 5;
		c1.insets = new Insets(15, 15, 15, 15);
		
		// menu
		fichier.add(quitter);
		menu.add(fichier);
		setJMenuBar(menu);

		// noms equipes
		equipe1=new JTextField(10);
		equipe2=new JTextField(10);
		equipe1.setFont(f);
		equipe2.setFont(f);
		message=new JLabel("Equipe 1: ");
		message.setFont(f);
		c1.gridx = 1;
		c1.gridy = 0;
		add(message, c1);
		c1.gridx = 1;
		c1.gridy = 1;
		message=new JLabel("Equipe 2: ");
		message.setFont(f);
		add(equipe1, c1);
		c1.gridx = 2;
		c1.gridy = 0;
		add(message, c1);
		c1.gridx = 2;
		c1.gridy = 1;
		add(equipe2, c1);
		
		// mode
		mode=new JComboBox<String>();
		mode.addItem("Joueur VS Joueur");
		mode.addItem("Joueur VS IA");
		mode.setFont(f);
		c1.ipadx = 70;
		c1.weightx = 0.5;
		c1.gridx = 0;
		c1.gridy = 1;
		add(mode, c1);
		
		// ajout des labels
		c1.gridy=0;
		
		for(int i=0; i<6; i++){
			JLabel j=new JLabel("Robot " + i);
			
			j.setFont(new Font("Arial", Font.BOLD, 15));
			c1.gridx=0;
			c1.gridy++;
			add(j, c1);
		}
		
		JLabel mode=new JLabel("Mode: ");
		mode.setFont(new Font("Arial", Font.BOLD, 15));
		c1.gridx=0;
		c1.gridy=0;
		add(mode, c1);
		
		// %age obstacles
		c1.gridx=3;
		c1.gridy=1;
		JLabel jl=new JLabel("Pourcentage d'obstacles sur le plateau : ");
		jl.setFont(f);
		add(jl, c1);
		
		c1.gridx=3;
		c1.gridy=2;
		jc=new JComboBox<Integer>();
		for(int i=0; i<75; i++)
			jc.addItem(i);
		add(jc, c1);

		// choix des robots
		c1.ipadx = 70;
		c1.weightx = 0.5;
		c1.gridy=2;
		for(int i=0; i<5; i++){
			robots1[i]=new JComboBox<String>();
			robots1[i].addItem("");
			robots1[i].addItem("Tireur");
			robots1[i].addItem("Piegeur");
			robots1[i].addItem("Char");
			robots1[i].setFont(f);
			
			c1.gridx=1;
			add(robots1[i], c1);
			c1.gridy++;
		}
		c1.gridy=2;
		for(int i=0; i<5; i++){
			robots2[i]=new JComboBox<String>();
			robots2[i].addItem("");
			robots2[i].addItem("Tireur");
			robots2[i].addItem("Piegeur");
			robots2[i].addItem("Char");
			robots2[i].setFont(f);
			
			c1.gridx=2;
			add(robots2[i], c1);
			
			c1.gridy++;
		}
		// bouton Valider
		valider = new JButton("Valider");
		valider.setFont(f);
		c1.weightx = 0.5;
		c1.gridx = 3;
		c1.gridy = 5;
		add(valider, c1);

		// retour au Menu principal
		retour = new JButton("Retour au menu principal");
		retour.setFont(f);
		c1.ipadx = 2;
		c1.gridx = 3;
		c1.gridy = 6;
		c1.gridheight = 1;
		c1.gridwidth = 1;
		add(retour, c1);
	}
}