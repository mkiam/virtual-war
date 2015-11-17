/**
 * Classe abstraite Robot, ce sont les pions qui circulent et s'attaquent sur le plateau
 * 
 * @author Bryan Vergauwen
 * @author Paul-Ivan Affolaby
 * 
 */
package fr.iutinfo.N2.VIRTUAL_WAR.Robot;

import java.util.List;

import fr.iutinfo.N2.VIRTUAL_WAR.Coordonnees.Coordonnees;
import fr.iutinfo.N2.VIRTUAL_WAR.Plateau.Vue;

public abstract class Robot {
	/**
	 * niveau d'energie du robot
	 */
	private int energie;
	/**
	 * equipe du robot
	 */
	private int equipe;
	/**
	 * vue du robot
	 */
	private Vue v;
	/**
	 * a Coordonnees du robot
	 */
	private Coordonnees c;

	/**
	 * Constructeur de Robot
	 * @param v une vue
	 * @param x son abscisse
	 * @param y son ordonnee
	 * @param equipe son equipe
	 */
	public Robot(Vue v, int x, int y, int equipe){
		this.v=v;
		this.equipe=equipe;
		v.p.getCellule(x, y).deplaceSur(this);
	}
	/**
	 * Si le robot peut tirer
	 * @return vrai s'il peut, sinon faux
	 */
	public abstract boolean peutTirer();
	/**
	 * retourne true si un robot est dans une base
	 * @return vrai si le robot est dans la base, sinon faux
	 */
	public boolean estSurBase(){ // retourne true si un robot est dans une base
		if(equipe==1)
			return c.getLargeur()==0 && c.getHauteur()==0;
		else if(equipe==2){
			int size_largeur=v.p.getPlateau().length-1;
			int size_hauteur=v.p.getPlateau()[0].length-1;

			return c.getLargeur()==size_largeur && c.getHauteur()==size_hauteur;
		}
		return false;
	}
	public void setCoordonnees(Coordonnees c){
		this.c=c;
	}
	public Coordonnees getCoordonnees(){
		return c;
	}
	public Vue getVue(){ // retourne la vue courante 
		return v;
	}
	public int getEnergie(){ // retourne le niveau d'energie
		return energie;
	}
	public void setEnergie(int energie){
		this.energie=energie;
	}
	public int getEquipe(){
		return equipe;
	}
	/**
	 * 
	 * @return le cout d'une action
	 */
	public abstract int getCoutAction();
	/**
	 * 
	 * @return le cout d'un deplacement
	 */
	public abstract int getCoutDep();
	/**
	 * 
	 * @return le cout d'un tir
	 */
	public abstract int getDegatTir();
	/**
	 * 
	 * @return le cout d'une pose de mine
	 */
	public abstract int getDegatMine();
	/**
	 * 
	 * @return renvoie le type du robot
	 */
	public abstract String getType();
	/**
	 * 
	 * @return renvoie la liste de coordonnees possibles pour se deplacer
	 */
	public abstract List<Coordonnees> getDeplacement();

	public void setVue(Vue v){
		this.v=v;
	}
	/**
	 * Affichage d'un robot
	 */
	public String toString(){ // Affichage d'un robot
		if(equipe==1)
			return (getType().charAt(0)+"").toLowerCase();
		return getType().charAt(0)+"";
	}
	public void subitTir(){
		energie-=getDegatTir();
	}
	public void subitMine(){
		energie-=getDegatMine();
	}
}