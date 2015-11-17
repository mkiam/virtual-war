package fr.iutinfo.N2.VIRTUAL_WAR.Cellule;
import fr.iutinfo.N2.VIRTUAL_WAR.Robot.Robot;

public class Case extends Cellule{
	/**
	 * Construit une case
	 * @param largeur La colonne
	 * @param hauteur La ligne
	 */
	public Case(int largeur, int hauteur) {
		super(largeur, hauteur);
	}
	/**
	 * Met a jour les informations d'une case (robot, coordonnees)
	 */
	public void deplaceSur(Robot robot){
		r=robot;
		r.setCoordonnees(c);
	}
	/**
	 * ajoute une mine d'une equipe sur la case courante
	 */
	public void ajoute(int equipe){
		setMine(equipe);
	}
	/**
	 * Mise a zero des informations d'une case
	 */
	public void videCase(){
		setBase(0);
		setMine(0);
		r=null;
	}
}