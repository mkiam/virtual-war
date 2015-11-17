/**
 * Classe Deplacement, classe utilisee pour les deplacements. Elle herite de Action
 * 
 * @author Bryan Vergauwen
 * @author Yann Dujardin
 */
package fr.iutinfo.N2.VIRTUAL_WAR.Action;
import fr.iutinfo.N2.VIRTUAL_WAR.Cellule.Cellule;
import fr.iutinfo.N2.VIRTUAL_WAR.Coordonnees.Coordonnees;
import fr.iutinfo.N2.VIRTUAL_WAR.Robot.Robot;

public class Deplacement extends Action{
	/**
	 * Reprend les parametres du constructeur de la classe mere
	 * 
	 * @param robot Un Robot
	 * @param direction Une direction
	 */
	public Deplacement(Robot robot, Coordonnees direction){
		super(robot, direction);
	}
	/**
	 * Verifie si un deplacement est possible, et si oui deplace le robot, Sinon affiche un message de refus
	 */
	public void agit(){
		int xOld=r.getCoordonnees().getLargeur(); // Largeur de l'ancienne coord
		int yOld=r.getCoordonnees().getHauteur(); // Hauteur de l'ancienne coord
		int xNew=getObjectif().getLargeur(); // Largeur de la nouvelle coord
		int yNew=getObjectif().getHauteur(); // Hauteur de la nouvelle coord
		Cellule cNew=r.getVue().p.getCellule(xNew, yNew); // Nouvelle cellule
		Cellule cOld=r.getVue().p.getCellule(xOld, yOld); // Ancienne cellule
		boolean vouluRentrer=false;

		if(cNew.getContenu()==null && !cNew.getObstacle()){ // Si il n'y a pas  de robot dans la nouvelle case
			if(cNew.contientMine()!=0){ // Si il y a une mine
				System.out.println("Vous avez marche sur une mine!");
				cNew.deplaceSur(r); // deplacement du robot
				System.out.println("Deplacement effectue!");
			}
			else if(cNew.estBase()==r.getEquipe()){ // Si la base est bien de l'equipe du robot qui veut y rentrer
				System.out.println("Robot rentre dans sa base!");
				cNew.deplaceSur(r); // Deplacement du robot
				System.out.println("Deplacement effectue!");
			}
			else if(cNew.estBase()!=r.getEquipe() && cNew.estBase()!=0){ // Si l'equipe de la base et du robot sont differentes
				System.out.println("Impossible de rentrer dans la base adverse!");
				vouluRentrer=true;
			}
			else{ // Deplacement normal, sur case vide
				cNew.deplaceSur(r);
				System.out.println("Deplacement effectue!");
			}
			if(cOld.estBase()==0 && !vouluRentrer) // Si l'ancienne case n'est pas une base
				cOld.videCase(); // On vide la case
		}
		else // Si la case est occupee
			System.out.println("Deplacement impossible, case occupee!");
		r.setEnergie(r.getEnergie()-r.getCoutDep()); // mise a jour de l'energie
	}
}