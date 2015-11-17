/**
 * Classe Vue, ce que voit une equipe
 * 
 * @author Bryan Vergauwen
 * @author Yann Dujardin
 * 
 */
package fr.iutinfo.N2.VIRTUAL_WAR.Plateau;
import fr.iutinfo.N2.VIRTUAL_WAR.Cellule.Cellule;

public class Vue {
	/**
	 * un plateau
	 */
	public Plateau p;
	/**
	 * une equipe
	 */
	protected int equipe;
	/**
	 * Les dimensions du plateau
	 */
	public static int SIZE_X, SIZE_Y;
	
	/**
	 * Constructeur de vue
	 * @param equipe numero d'equipe
	 * @param p le plateau de jeu
	 */
	public Vue(int equipe, Plateau p) { // construit une vue
		this.equipe=equipe;
		this.p=p;
		SIZE_X=p.getPlateau().length;
		SIZE_Y=p.getPlateau()[0].length;
	}
	/**
	 * affichage d'une vue pour chaque equipe
	 */
	public String toString(){ // affichage d'une vue pour chaque equipe (ne voit que ses mines)
		String tmp="   ";
		Cellule c=null;
		
		for(int i=0; i<p.getPlateau()[0].length; i++)
			tmp+="+---"; // 1ere ligne de +---
		tmp+="+";
		for(int i=0; i<p.getPlateau().length; i++){
			tmp+="\n"+i+" "; // affichage des coordonnees X
			if(i<10)
				tmp+=" ";
			for(int j=0; j<p.getPlateau()[0].length; j++){
				tmp+="| ";
				c=p.getCellule(i, j);
				if(c.getContenu()!=null || c.estBase()!=0 || c.contientMine()==equipe)
					tmp+=c; // affichage du robot ou de la base ou de la mine
				else
					tmp+=" ";
				tmp+=" ";
			}
			tmp+="|\n   ";
			for(int k=0; k<p.getPlateau()[0].length; k++)
				tmp+="+---";
			tmp+="+";
		}
		tmp+="\n     ";
		for(int i=0; i<p.getPlateau()[0].length; i++){
			if(i<10)
				tmp+=i+"   ";
			else
				tmp+=i+"  ";
		}
		return tmp;
	}
	public int getEquipe(){
		return equipe;
	}
}