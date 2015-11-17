/**
 * Classe Attaque, classe fille d'Action, utilisee pour les attaques entre robot
 * 
 * @author Bryan Vergauwen
 * @author Yann Dujardin
 * 
 */
package fr.iutinfo.N2.VIRTUAL_WAR.Action;
import fr.iutinfo.N2.VIRTUAL_WAR.Cellule.Cellule;
import fr.iutinfo.N2.VIRTUAL_WAR.Coordonnees.Coordonnees;
import fr.iutinfo.N2.VIRTUAL_WAR.Robot.Robot;

public class Attaque extends Action{
	/**
	 * Reprend les parametres du constructeur de la classe mere
	 * 
	 * @param robot Un robot
	 * @param direction Une direction
	 */
	public Attaque(Robot robot, Coordonnees direction) {
		super(robot, direction);
	}
	/**
	 * Verifie si l'attaque est possible et si oui, attaque, sinon affiche un message de refus
	 */
	public void agit(){
		int x=getObjectif().getLargeur();
		int y=getObjectif().getHauteur();
		
		if(r.peutTirer()){ // Si le robot a assez de vie
			Cellule objectif=r.getVue().p.getCellule(x, y);
			Robot thisR=r.getVue().p.getCellule(x, y).getContenu(); // robot (à "null" ou pas) de la future case
			
			if(r.getType().substring(0, 1).equalsIgnoreCase("T") || r.getType().substring(0, 1).equalsIgnoreCase("C")){ // Si le robot courant est un Tireur ou un char
				if(thisR!=null && objectif.estBase()==0 && thisR.getEquipe()==r.getEquipe()) // Si un robot tire sur un robot de son equipe
					System.out.println("Hey man, no friendly fire! ;)");
				
				else if(thisR!=null && objectif.estBase()==0){ // Si on ne tire pas sur une base
					thisR.subitTir(); // le robot attaque perd des pvs
					System.out.println("Attaque effectuee!");
				}
				else // Si on ne tire sur rien
					System.out.println("Impossible, vous ne tirez pas sur un robot!");
			}
			else if(r.getType().substring(0, 1).equalsIgnoreCase("P")){ // Si le robot courant est un Piegeur
				if(thisR==null && objectif.estBase()==0){ // Si la case est vide et que ce n'est pas une base
					objectif.ajoute(r.getEquipe()); // Ajoute une mine
					System.out.println("Attaque effectuee!");
				}
				else
					System.out.println("Impossible de poser une mine, case non vide!");
			}
			r.setEnergie(r.getEnergie()-r.getCoutAction()); // mise a jour de l'energie
		}
		else
			System.out.println("Impossible, vous n'avez pas assez de vie pour attaquer!");
	}
}