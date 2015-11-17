package fr.iutinfo.N2.VIRTUAL_WAR.Fenetres;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.List;

import javax.swing.JFrame;

import fr.iutinfo.N2.VIRTUAL_WAR.Coordonnees.Coordonnees;
import fr.iutinfo.N2.VIRTUAL_WAR.Partie.Partie;
import fr.iutinfo.N2.VIRTUAL_WAR.Plateau.Plateau;
import fr.iutinfo.N2.VIRTUAL_WAR.Plateau.Vue;
import fr.iutinfo.N2.VIRTUAL_WAR.Robot.Robot;

public class Game extends JFrame{
	private static final long serialVersionUID = 1L;
	private Plateau plateau;
	private Image wallp=getToolkit().getImage("ressources/wallpaper3.png");
	private Image mine=getToolkit().getImage("ressources/mine.png");
	private Image base1=getToolkit().getImage("ressources/base1.png");
	private Image base2=getToolkit().getImage("ressources/base2.png");
	private Image tireur1=getToolkit().getImage("ressources/tireur1.png");
	private Image tireur2=getToolkit().getImage("ressources/tireur2.png");
	private Image piegeur1=getToolkit().getImage("ressources/piegeur1.png");
	private Image piegeur2=getToolkit().getImage("ressources/piegeur2.png");
	private Image char1=getToolkit().getImage("ressources/char1.png");
	private Image char2=getToolkit().getImage("ressources/char2.png");
	private Image obst=getToolkit().getImage("ressources/obst.png");
	private Vue v;
	private Partie partie;
	public static boolean clear=true;

	public Game(Plateau plateau, Vue v, Partie partie) {
		configFrame();
		this.plateau=plateau;
		this.v=v;
		this.partie=partie;
		update(getGraphics());
	}
	public void configFrame(){
		setTitle("Virtual War");
		setSize(1200,680);
		setLocation(100, 30);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void paint(Graphics g){
		int length, decalage=160;
		List<Robot> l;
		Coordonnees c;
		
		// clean partie droite
		if(clear){
			g.setColor(new Color(238, 238, 238));
			g.fillRect(745, 40, 450, 550);
			clear=false;
		}
		
		// affichage infos
		g.setFont(new Font("Arial", Font.PLAIN, 25));
		g.drawString("C'est a l'equipe \""+v.getEquipe()+"\" de jouer!", 750, 80);
		
		if(v.getEquipe()==1){
			length=partie.getListe1().size();
			l=partie.getListe1();
		}
		else{
			length=partie.getListe2().size();
			l=partie.getListe2();
		}
		for(int i=0; i<length; i++){
			c=l.get(i).getCoordonnees(); // coordonnee du robot courant
			
			if((c.getLargeur()==0 && c.getHauteur()==0) || (c.getLargeur()==Vue.SIZE_X-1 && c.getHauteur()==Vue.SIZE_Y-1)) // robot en base
				g.drawString(l.get(i)+": "+l.get(i).getEnergie()+" pvs - "+l.get(i).getCoordonnees() + " (en base) - Numero "+i, 750, decalage);
			else
				g.drawString(l.get(i)+": "+l.get(i).getEnergie()+" pvs - "+l.get(i).getCoordonnees() + " Numero "+i, 750, decalage); // robot sur le plateau
			decalage+=40;
		}
	
		// Affichage wallpaper
		try {
			Thread.sleep(25);
		} catch (InterruptedException e) {}
		g.drawImage(wallp, 5, 50, this);
		try {
			Thread.sleep(25);
		} catch (InterruptedException e) {}
		
		// affichage robots, bases, mines...
		g.setFont(new Font("serif", Font.PLAIN, 50));
		g.setColor(new Color(0,0,255));
		for(int i=0; i<Vue.SIZE_X; i++){
			for(int j=0; j<Vue.SIZE_Y; j++){
				//affichage des mines
				if(v.p.getCellule(i, j).contientMine()==v.getEquipe())
					g.drawImage(mine, 70+66*j, 49+56*i, this);
				//affichage de la base 1
				else if(plateau.getCellule(i, j).toString().equals("b"))
					g.drawImage(base1, 70+66*j, 51+56*i, this);
				//affichage de la base 2
				else if(plateau.getCellule(i, j).toString().equals("B"))
					g.drawImage(base2, 70+66*j, 46+56*i, this);
				//affichage du tireur 1
				else if(plateau.getCellule(i, j).toString().equals("t"))
					g.drawImage(tireur1, 70+66*j, 52+56*i, this);
				//affichage du tireur 2
				else if(plateau.getCellule(i, j).toString().equals("T"))
					g.drawImage(tireur2, 70+66*j, 50+56*i, this);
				//affichage du piegeur 1
				else if(plateau.getCellule(i, j).toString().equals("p"))
					g.drawImage(piegeur1, 75+66*j, 52+56*i, this);
				//affichage du piegeur 2
				else if(plateau.getCellule(i, j).toString().equals("P"))
					g.drawImage(piegeur2, 75+66*j, 50+56*i, this);
				//affichage du char 1
				else if(plateau.getCellule(i, j).toString().equals("c"))
					g.drawImage(char1, 72+66*j, 47+54*i, this);
				//affichage du char 2
				else if(plateau.getCellule(i, j).toString().equals("C"))
					g.drawImage(char2, 72+66*j, 55+54*i, this);
				//affichage des obstacles
				else if(plateau.getCellule(i, j).toString().equals("O"))
					g.drawImage(obst, 74+66*j, 55+56*i, this);
			}
		}
	}
	public void setVue(Vue v) {
		this.v=v;
	}
	public Vue getVue(){
		return v;
	}
}