/**
 * Classe Plateau, c'est le plateau de jeu sur lequel circulent les robots
 * 
 * @author Bryan Vergauwen
 * @author Matthias Chombart
 * 
 */
package fr.iutinfo.N2.VIRTUAL_WAR.Plateau;
import java.util.Random;

import fr.iutinfo.N2.VIRTUAL_WAR.Cellule.Base;
import fr.iutinfo.N2.VIRTUAL_WAR.Cellule.Case;
import fr.iutinfo.N2.VIRTUAL_WAR.Cellule.Cellule;

public class Plateau {
	/**
	 * Plateau de Cellules
	 */
	private Cellule[][] plateau;
	
	/**
	 * Constructeur de plateau
	 * @param x abscisse
	 * @param y ordonnee
	 */
	public Plateau(int x, int y, int nbObst){ // Cree un plateau de cellules, lesquelles sont composees de cases...
		Random r = new Random();
		
		plateau=new Cellule[x][y];
		for(int i=0; i<plateau.length; i++){
			for(int j=0; j<plateau[0].length; j++){
				plateau[i][j]=new Case(i, j);
			}
		}
		plateau[0][0]=new Base(0, 0); // ... sauf ces deux la .. 
		plateau[x-1][y-1]=new Base(x-1, y-1); // ... qui sont des bases
		plateau[0][0].ajoute(1); // ajout de la Base 1
		plateau[x-1][y-1].ajoute(2); // ajout de la base 2
		
		while(nbObst>0){
			int a=r.nextInt(x);
			int b=r.nextInt(y);
			
			if(getCellule(a, b).toString().equals(" ")){
				plateau[a][b].setObstacle(true);
				nbObst--;
		 	}
		}
	}
	
	public Cellule getCellule(int x, int y){
		return plateau[x][y];
	}
	public Cellule[][] getPlateau(){
		return plateau;
	}
}