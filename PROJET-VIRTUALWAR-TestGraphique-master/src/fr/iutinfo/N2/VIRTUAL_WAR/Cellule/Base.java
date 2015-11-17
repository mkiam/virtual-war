/**
 * Classe Base: Gestion des bases. Elle herite de Cellule
 * 
 * @author Bryan Vergauwen
 * @author Yann Dujardin
 * 
 */
package fr.iutinfo.N2.VIRTUAL_WAR.Cellule;

import fr.iutinfo.N2.VIRTUAL_WAR.Coordonnees.Coordonnees;
import fr.iutinfo.N2.VIRTUAL_WAR.Plateau.Vue;
import fr.iutinfo.N2.VIRTUAL_WAR.Robot.Robot;

public class Base extends Cellule{
	/**
	 * Construit une Base
	 * @param largeur Sa colonne
	 * @param hauteur Sa ligne
	 */
	public Base(int largeur, int hauteur) {
		super(largeur, hauteur);
	}
	/**
	 * @param robot Le robot
	 * Mise a jour des coordonnees du robot
	 */
	public void deplaceSur(Robot robot){
		if(robot.getEquipe()==1)
			robot.setCoordonnees(new Coordonnees(0, 0));
		else
			robot.setCoordonnees(new Coordonnees(Vue.SIZE_X-1, Vue.SIZE_Y-1));
	}
	/**
	 * Ajoute une base avec une equipe
	 */
	public void ajoute(int equipe){
		setBase(equipe);
	}
	/**
	 * Supprime la base
	 */
	public void videCase(){
		setBase(0);
	}
}