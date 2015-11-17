/**
 * Classe qui contient la liste des constantes du jeu
 * 
 * @author Bryan Vergauwen
 * @author Yann Dujardin
 */

package fr.iutinfo.N2.VIRTUAL_WAR.Coordonnees;
public class Constante {
	public static final Coordonnees DEPL_GAUCHE=new Coordonnees(0, -1);
	public static final Coordonnees DEPL_DROITE=new Coordonnees(0, 1);
	public static final Coordonnees DEPL_HAUT=new Coordonnees(-1, 0);
	public static final Coordonnees DEPL_BAS=new Coordonnees(1, 0);
	public static final Coordonnees DEPL_DIAGONALE_HAUTE_GAUCHE=new Coordonnees(-1, -1);
	public static final Coordonnees DEPL_DIAGONALE_HAUTE_DROITE=new Coordonnees(-1, 1);
	public static final Coordonnees DEPL_DIAGONALE_BASSE_GAUCHE=new Coordonnees(1, -1);
	public static final Coordonnees DEPL_DIAGONALE_BASSE_DROITE=new Coordonnees(1, 1);
	public static final Coordonnees DEPL_GAUCHE_GAUCHE=new Coordonnees(0, -2);
	public static final Coordonnees DEPL_DROITE_DROITE=new Coordonnees(0, 2);
	public static final Coordonnees DEPl_BAS_BAS=new Coordonnees(2, 0);
	public static final Coordonnees DEPL_HAUT_HAUT=new Coordonnees(-2, 0);
	
	/**
	 * Retourne le mouvement exact d'un deplacement à partir de l'ancienne et de la nouvelle coordonnee, sous forme de String
	 * @param depart Coordonnee de depart
	 * @param arrivee Coordonne d'arrivee
	 * @return Le mouvement du robot (Gauche, Haut_bas, ...) sous forme de String
	 */
	
	public static String getCoordonneeString(Coordonnees depart, Coordonnees arrivee){ // retourne le mouvement exact d'un deplacement à partir de l'ancienne et de la nouvelle coordonnee sous forme de chaine
		int x=arrivee.getLargeur()-depart.getLargeur(); // largeur du mouvement
		int y=arrivee.getHauteur()-depart.getHauteur(); // hauteur du mouvement
		
		if(x==0 && y==-1)
			return "GAUCHE";
		else if (x==0 && y==1)
			return "DROITE";
		else if (x==-1 && y==0)
			return "HAUT";
		else if (x==1 && y==0)
			return "BAS";
		else if (x==-1 && y==-1)
			return "HAUT_GAUCHE";
		else if (x==-1 && y==1)
			return "HAUT_DROIT";
		else if (x==1 && y==-1)
			return "BAS_GAUCHE";
		else if (x==1 && y==1)
			return "BAS_DROITE";
		else if (x==0 && y==-2)
			return "GAUCHE_GAUCHE";
		else if (x==0 && y==2)
			return "DROITE_DROITE";
		else if (x==2 && y==0)
			return "BAS_BAS";
		return "HAUT_HAUT";
	}
}