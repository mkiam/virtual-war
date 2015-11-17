/**
 * Classe qui gere une coordonnee
 * 
 * @author Bryan Vergauwen
 * @author Yann Dujardin
 */

package fr.iutinfo.N2.VIRTUAL_WAR.Coordonnees;
public class Coordonnees {
	/**
	 * largeur et hauteur, bref des coordonnes cartesiennes
	 */
	private int largeur, hauteur;
	
	/**
	 * Construit des coordonnees
	 * @param largeur 
	 * @param hauteur
	 */
	public Coordonnees(int largeur, int hauteur){
		this.largeur=largeur;
		this.hauteur=hauteur;
	}
	public int getLargeur(){
		return largeur;
	}
	public int getHauteur(){
		return hauteur;
	}
	public void setLargeur(int largeur){
		this.largeur=largeur;
	}
	public void setHauteur(int hauteur){
		this.hauteur=hauteur;
	}
	/**
	 * affiche la coordonnee
	 */
	public String toString(){ // Affichage d'une coordonnee (ex: [0;5]) 
		return "("+largeur+";"+hauteur+")";
	}
}