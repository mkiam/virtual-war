/**
 * Classe fille de Robot, elle cree un robot qui tire de loin
 * 
 * @author Bryan Vergauwen
 * @author Yann Dujardin
 */
package fr.iutinfo.N2.VIRTUAL_WAR.Robot;

import java.util.LinkedList;
import java.util.List;

import fr.iutinfo.N2.VIRTUAL_WAR.Coordonnees.Constante;
import fr.iutinfo.N2.VIRTUAL_WAR.Coordonnees.Coordonnees;
import fr.iutinfo.N2.VIRTUAL_WAR.Plateau.Vue;

public class Tireur extends Robot{
	/**
	 * une liste de coordonnees
	 */
	List<Coordonnees> liste;

	/**
	 * Creee un Tireur
	 * @param v une vue
	 * @param i une abscisse
	 * @param h une ordonnee
	 * @param equipe une equipe
	 */
	public Tireur(Vue v, int i, int h, int equipe) {
		super(v, i, h, equipe);
		setEnergie(40);
		liste=new LinkedList<Coordonnees>();
	}
	
	public boolean peutTirer() {
		return getEnergie()>1;
	}
	public int getCoutAction() {
		return 2;
	}
	public int getCoutDep() {
		return 1;
	}

	public int getDegatTir() {
		return 3;
	}

	public int getDegatMine() {
		return 3;
	}
	

	public String getType() {
		return "Tireur "+getEquipe();
	}
	/**
	 * met a jour les deplacements possibles pour le robot
	 */
	public void setDeplacements(){ // met a jour les deplacements possibles pour le robot
		liste=new LinkedList<Coordonnees>();
		int x=getCoordonnees().getLargeur();
		int y=getCoordonnees().getHauteur();
		
		if(y>0)	
			liste.add(new Coordonnees(Constante.DEPL_GAUCHE.getLargeur()+x, Constante.DEPL_GAUCHE.getHauteur()+y));
		if(y<Vue.SIZE_Y-1)	
			liste.add(new Coordonnees(Constante.DEPL_DROITE.getLargeur()+x, Constante.DEPL_DROITE.getHauteur()+y));
		if(x>0)	
			liste.add(new Coordonnees(Constante.DEPL_HAUT.getLargeur()+x, Constante.DEPL_HAUT.getHauteur()+y));
		if(x<Vue.SIZE_X-1)	
			liste.add(new Coordonnees(Constante.DEPL_BAS.getLargeur()+x, Constante.DEPL_BAS.getHauteur()+y));
		if(x<Vue.SIZE_X-1 && y<Vue.SIZE_Y-1)	
			liste.add(new Coordonnees(Constante.DEPL_DIAGONALE_BASSE_DROITE.getLargeur()+x, Constante.DEPL_DIAGONALE_BASSE_DROITE.getHauteur()+y));
		if(x<Vue.SIZE_X-1 && y>0)	
			liste.add(new Coordonnees(Constante.DEPL_DIAGONALE_BASSE_GAUCHE.getLargeur()+x, Constante.DEPL_DIAGONALE_BASSE_GAUCHE.getHauteur()+y));
		if(x>0 && y<Vue.SIZE_Y-1)	
			liste.add(new Coordonnees(Constante.DEPL_DIAGONALE_HAUTE_DROITE.getLargeur()+x, Constante.DEPL_DIAGONALE_HAUTE_DROITE.getHauteur()+y));
		if(x>0 && y>0)	
			liste.add(new Coordonnees(Constante.DEPL_DIAGONALE_HAUTE_GAUCHE.getLargeur()+x, Constante.DEPL_DIAGONALE_HAUTE_GAUCHE.getHauteur()+y));
	}
	public List<Coordonnees> getDeplacement() {
		return liste;
	}
}