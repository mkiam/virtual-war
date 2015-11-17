package fr.iutinfo.N2.VIRTUAL_WAR.Robot;

import java.util.LinkedList;
import java.util.List;

import fr.iutinfo.N2.VIRTUAL_WAR.Coordonnees.Constante;
import fr.iutinfo.N2.VIRTUAL_WAR.Coordonnees.Coordonnees;
import fr.iutinfo.N2.VIRTUAL_WAR.Plateau.Vue;

public class Char extends Robot{
	/**
	 * une liste de Coordonnees
	 */
	List<Coordonnees> listeDepl, listeCasesAttaquables;

	/**
	 * Constructeur du char
	 * @param v une vue
	 * @param i une abscisse
	 * @param h une ordonnee
	 * @param equipe un numero d'equipe
	 */
	public Char(Vue v, int i, int h, int equipe) {
		super(v, i, h, equipe);
		setEnergie(60);
		listeDepl=new LinkedList<Coordonnees>();
		listeCasesAttaquables=new LinkedList<Coordonnees>();
	}
	public boolean peutTirer() {
		return getEnergie()>1;
	}
	public int getCoutAction() {
		return 1;
	}
	public int getCoutDep() {
		return 5;
	}
	public int getDegatTir() {
		return 6;
	}

	public int getDegatMine() {
		return 6;
	}
	public String getType() {
		return "Char "+getEquipe();
	}
	public List<Coordonnees> getDeplacement() {
		return listeDepl;
	}
	public List<Coordonnees> getCasesAttaquables() {
		return listeCasesAttaquables;
	}
	/**
	 * met a jour les deplacements possibles pour le robot
	 */
	public void setDeplacements(){ // met a jour les deplacements possibles pour le robot
		listeDepl=new LinkedList<Coordonnees>();
		int x=getCoordonnees().getLargeur();
		int y=getCoordonnees().getHauteur();

		if(y>1)	
			listeDepl.add(new Coordonnees(Constante.DEPL_GAUCHE_GAUCHE.getLargeur()+x, Constante.DEPL_GAUCHE_GAUCHE.getHauteur()+y));
		if(y<Vue.SIZE_X-2)	
			listeDepl.add(new Coordonnees(Constante.DEPL_DROITE_DROITE.getLargeur()+x, Constante.DEPL_DROITE_DROITE.getHauteur()+y));
		if(x>1)
			listeDepl.add(new Coordonnees(Constante.DEPL_HAUT_HAUT.getLargeur()+x, Constante.DEPL_HAUT_HAUT.getHauteur()+y));
		if(x<Vue.SIZE_Y-2)	
			listeDepl.add(new Coordonnees(Constante.DEPl_BAS_BAS.getLargeur()+x, Constante.DEPl_BAS_BAS.getHauteur()+y));
	}
	public void setCasesAttaquables() {
		listeCasesAttaquables=new LinkedList<Coordonnees>();
		int x=getCoordonnees().getLargeur();
		int y=getCoordonnees().getHauteur();
		int gauche=y, droite=y, haut=x, bas=x;

		while(gauche>0){
			listeCasesAttaquables.add(new Coordonnees(Constante.DEPL_GAUCHE.getLargeur()+x, Constante.DEPL_GAUCHE.getHauteur()+gauche));
			gauche--;
		}
		while(droite<Vue.SIZE_X-1){
			listeCasesAttaquables.add(new Coordonnees(Constante.DEPL_DROITE.getLargeur()+x, Constante.DEPL_DROITE.getHauteur()+droite));
			droite++;
		}
		while(haut>0){
			listeCasesAttaquables.add(new Coordonnees(Constante.DEPL_HAUT.getLargeur()+haut, Constante.DEPL_HAUT.getHauteur()+y));
			haut--;
		}
		while(bas<Vue.SIZE_Y-1){
			listeCasesAttaquables.add(new Coordonnees(Constante.DEPL_BAS.getLargeur()+bas, Constante.DEPL_BAS.getHauteur()+y));
			bas++;
		}
	}
}
