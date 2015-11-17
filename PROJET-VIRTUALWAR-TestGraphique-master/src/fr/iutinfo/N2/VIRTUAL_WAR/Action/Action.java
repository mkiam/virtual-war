/**
 * Classe Action, classe abstraite mere de toute action dans VirtualWar
 * 
 * @author Bryan Vergauwen
 * @author Yann Dujardin
 */
package fr.iutinfo.N2.VIRTUAL_WAR.Action;
import fr.iutinfo.N2.VIRTUAL_WAR.Coordonnees.Coordonnees;
import fr.iutinfo.N2.VIRTUAL_WAR.Robot.Robot;

public abstract class Action {
	/**
	 * Robot courant
	 */
	protected Robot r;
	/**
	 * Coordonnee [x,y] du robot r
	 * 	 
	 */
	protected Coordonnees c;
	/**
	 * Construit une action
	 * 
	 * @param robot le robot qui effectuera l'action
	 * @param direction Orientation de l'Action
	 */

	public Action(Robot robot, Coordonnees direction){
		r=robot;
		c=direction;
	}
	/**
	 * Calcule les coordonnees de l'objectif
	 * 
	 * @return les coordonnees de l'objectif
	 */
	
	public Coordonnees getObjectif(){
		int x=r.getCoordonnees().getLargeur()+c.getLargeur(); // Largeur de la future case
		int y=r.getCoordonnees().getHauteur()+c.getHauteur(); // hauteur de la future case
	
		return new Coordonnees(x, y);
	}
	/**
	 * Methode abstraite qui contiendra l'action
	 */
	public abstract void agit();
}