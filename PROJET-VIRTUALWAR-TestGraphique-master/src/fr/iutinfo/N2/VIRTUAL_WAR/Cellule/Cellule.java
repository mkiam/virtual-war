/**
 * Classe abstraite Cellule
 * 
 * @author Bryan Vergauwen
 * @author Yann Dujardin
 * 
 */
package fr.iutinfo.N2.VIRTUAL_WAR.Cellule;

import fr.iutinfo.N2.VIRTUAL_WAR.Coordonnees.Coordonnees;
import fr.iutinfo.N2.VIRTUAL_WAR.Robot.Robot;

public abstract class Cellule {
	/**
	 * Indique si la cellule est un obstacle
	 * TRUE = obstacle
	 * FALSE = libre
	 */
	protected boolean obstacle = false;
	/**
	 * Indique s'il  a une mine ou pas et indique à quelle equipe elle appartient
	 * 0 = pas de mine
	 * 1 = mine de l'equipe 1
	 * 2 = mine de l'equipe 2
	 */
	protected int mine = 0;
	/**
	 * Indique si la cellule est une base et à quelle equipe elle appartient
	 * 0 = ce n'est pas une base
	 * 1 = base de l'equipe 1
	 * 2 = base de l'equipe 2
	 */
	protected int base = 0;
	/**
	 * Robot courant
	 */
	protected Robot r;
	/**
	 * Coordonnee du robot
	 */
	protected Coordonnees c;
	
	/**
	 * Constructeur de cellule
	 * @param largeur le "x" de la cellule
	 * @param hauteur le "y" de la cellule
	 */
	public Cellule(int largeur, int hauteur){
		c=new Coordonnees(largeur, hauteur);
		mine=0;
		base=0;
		r=null;
	}
	/**
	 * Teste si une mine est presente sur la case
	 * @return le numero de l'equipe si une mine est posee, sinon 0;
	 */
	
	public int contientMine(){
		return mine;
	}
	/**
	 * pose une mine
	 * @param mine pose une mine du numero de l'equipe dans la cellule 
	 */
	public void setMine(int mine){
		this.mine=mine;
	}
	/**
	 * Savoir si une case est un obstacle
	 * @return TRUE si la case est un obstacle, sinon FALSE
	 */
	
	public boolean getObstacle() {
		return obstacle;
	}
	/**
	 * Attribue à l'obstacle la valeur TRUE ou FALSE
	 * @param b, la nouvelle valeur de l'obstacle
	 */
	public void setObstacle(boolean b) {
		obstacle=b;
	}
	/**
	 * indique si la cellule est une base
	 * @return le numero d'equipe de la base, sinon 0
	 */
	
	public int estBase(){
		return base;
	}
	/**
	 * Attribue une base à une equipe
	 * @param b numero d'equipe à qui est attribuee la base
	 */
	public void setBase(int b){
		base=b;
	}
	/**
	 * donne les coordonnees de la cellule
	 * @return les coordonnees de la cellule
	 */
	public Coordonnees getCoordonnees(){
		return c;
	}
	/**
	 * attribue des coordonnees à une cellule
	 * @param c les coordonnees de la cellule donnee
	 */
	public void setCoord(Coordonnees c){
		this.c=c;
	}
	/**
	 * Retourne la valeur du robot dans la cellule
	 * @return le robot si il est present, sinon null
	 */
	public Robot getContenu(){
		return r;
	}
	/**
	 * Retourne la representation de la base selon l'equipe
	 * @return "b" pour l'equipe 1, "B" pour l'equipe 2
	 */
	public String getBaseParEquipe(){
		if(base==1)
			return "b";
		else if(base==2)
			return "B";
		return null;
	}
	
	/**
	 * Affiche la cellule
	 */
	public String toString(){
		if(r!=null)
			return r.toString();
		else if(base!=0)
			return getBaseParEquipe();
		else if(mine!=0)
			return "X";
		else if(obstacle)
			return "O";
		return " ";
	}
	/**
	 * Met a jour les infos d'une case (robot, coordonnees)
	 * @param robot le robot à mettre à jour
	 */
	public abstract void deplaceSur(Robot robot);
	/**
	 * ajoute une mine d'une equipe sur la case courante
	 * @param equipe numero de l'equipe à qui appartient la mine
	 */
	public abstract void ajoute (int equipe);
	/**
	 * vide la case
	 */
	public abstract void videCase();
}