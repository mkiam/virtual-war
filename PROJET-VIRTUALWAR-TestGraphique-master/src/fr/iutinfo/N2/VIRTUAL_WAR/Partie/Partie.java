/**
 * Classe creant une partie
 * 
 * @author Bryan Vergauwen
 * @author Yann Dujardin
 */
package fr.iutinfo.N2.VIRTUAL_WAR.Partie;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import fr.iutinfo.N2.VIRTUAL_WAR.Action.Attaque;
import fr.iutinfo.N2.VIRTUAL_WAR.Action.Deplacement;
import fr.iutinfo.N2.VIRTUAL_WAR.Coordonnees.Constante;
import fr.iutinfo.N2.VIRTUAL_WAR.Coordonnees.Coordonnees;
import fr.iutinfo.N2.VIRTUAL_WAR.Fenetres.Game;
import fr.iutinfo.N2.VIRTUAL_WAR.Plateau.Plateau;
import fr.iutinfo.N2.VIRTUAL_WAR.Plateau.Vue;
import fr.iutinfo.N2.VIRTUAL_WAR.Robot.Char;
import fr.iutinfo.N2.VIRTUAL_WAR.Robot.Piegeur;
import fr.iutinfo.N2.VIRTUAL_WAR.Robot.Robot;
import fr.iutinfo.N2.VIRTUAL_WAR.Robot.Tireur;

public class Partie { // Classe qui gere le deroulement d'une partie
	private Scanner s=new Scanner(System.in);
	/**
	 * le nombre de robots durant la partie
	 */
	private int mode;
	private Vue v1, v2;
	private List<Robot> equipe1, equipe2;
	private List<String> liste1, liste2;
	private String team1, team2;
	private Plateau plateau;
	private Game g;
	
	public Partie(Plateau plateau, List<String> l1, List<String> l2, int mode, String team1, String team2){
		equipe1=new LinkedList<Robot>();
		equipe2=new LinkedList<Robot>();
		this.team1=team1;
		this.team2=team2;
		this.mode=mode;
		liste1=l1;
		liste2=l2;
		v1=new Vue(1, plateau);
		v2=new Vue(2, plateau);
		this.plateau=plateau;
		g=new Game(plateau, v1, this);
		partie();
	}
	/**
	 * ajoute les robots choisis par l'utilisateur dans des listes
	 * @param team nom de l'equipe
	 * @param equipe equipe en question
	 * @param v vue de l'equipe
	 * @param sizeX taille du tableau (abscisses)
	 * @param sizeY taille du tableau (ordonnees)
	 * @param numEquipe numero de l'equipe
	 */
	private void ajoutRobots(String team, List<String> equipeString, List<Robot> equipeRobot, Vue v, int numEquipe) { // ajoute les robots choisis par l'utilisateur dans des listes
		int x, y;
		
		if(numEquipe==1){
			x=0;
			y=0;
		}
		else{
			x=Vue.SIZE_X-1;
			y=Vue.SIZE_Y-1;
		}
		for(int i=0; i<equipeString.size(); i++){
			if(!equipeString.get(i).equals("")){
				if(equipeString.get(i).substring(0, 1).equalsIgnoreCase("p"))
					equipeRobot.add(new Piegeur(v, x, y, numEquipe)); // Ajoute un piegeur
				else if(equipeString.get(i).substring(0, 1).equalsIgnoreCase("t"))
					equipeRobot.add(new Tireur(v, x, y, numEquipe)); // ajoute un tireur
				else
					equipeRobot.add(new Char(v, x, y, numEquipe)); // ajoute un char
			}
		}
	}
	/**
	 * Teste si le jeu est termine
	 * @param l1 liste de robots de l'equipe 1
	 * @param l2 liste de robots de l'equipe 2
	 * @return vrai si une liste est vide, sinon faux
	 */
	
	private boolean jeuFini(){ // teste si leu est fini
		return equipe1.isEmpty() || equipe2.isEmpty(); // (les robots sont supprimes des listes quand ils sont morts) --> Plus facile pour tester la fin du jeu
	}
	/**
	 * met a jour les listes, si des robots n'ont plus d'energie
	 * @param l liste de robot
	 */
	private void supprimeRobots(List<Robot> l){ // met a jour les listes, si des robots n'ont plus d'energie
		int x, y;
		for(int i=0; i<l.size(); i++){
			if(l.get(i).getEnergie()<=0){ // si le robot n'a plus d'energie
				x=l.get(i).getCoordonnees().getLargeur();
				y=l.get(i).getCoordonnees().getHauteur();
				
				System.out.println("Robot "+l.get(i)+" mort!");
				l.get(i).getVue().p.getCellule(x, y).videCase(); // reset la case ou se trouve le robot mort 
				l.remove(i); // suppression du robot de la liste
			}
		}
	}
	/**
	 * affiche le vainqueur
	 * @param equipe1 liste de robots de l'equipe 1
	 * @param equipe2 liste de robots de l'equipe 2
	 * @param team1 nom de l'equipe 1
	 * @param team2 nom de l'equipe 2
	 */
	private void afficheGagnant() {
		if(equipe1.isEmpty()) // si l'equipe 1 n'a plus de robot
			System.out.println("\nVainqueur: Equipe \""+team2+"\"!");
		else // si l'equipe 2 n'a plus de robot
			System.out.println("\nVainqueur: Equipe \""+team1+"\"!");
	}
	/**
	 * affichge la liste des deplacements possibles pour le robot r
	 * @param r un robot
	 */
	private void afficheDeplacements(Robot r) { // affichge la liste des deplacements possibles pour le robot r
		System.out.println("Choisissez le numero de votre direction parmi la liste ci dessous: ");
		System.out.println("Liste des cases ciblables pour le robot ("+r+": "+r.getEnergie()+" pvs - "+r.getCoordonnees()+")");
		for(int i=0; i<r.getDeplacement().size(); i++)
			System.out.println(r.getDeplacement().get(i)+ " Numero "+i+" : ("+Constante.getCoordonneeString(r.getCoordonnees(), r.getDeplacement().get(i))+")");
	}
	/**
	 * Effectue une action
	 * @param r un robot
	 * @param c les coordonnees d'objectif
	 * @param choixAction choix de l'utilisateur
	 */
	private void action(Robot r, Coordonnees c, String choixAction) {
		int x=c.getLargeur()-r.getCoordonnees().getLargeur();
		int y=c.getHauteur()-r.getCoordonnees().getHauteur();
		
		if(choixAction.equalsIgnoreCase("a")) // Attaque
			new Attaque(r, new Coordonnees(x, y)).agit();
		else // Deplacement
			new Deplacement(r, new Coordonnees(x, y)).agit();
		System.out.println("----------------------------------------------------------");
	}
	/**
	 * recupere le choix de l'utilisateur, deplacer ou attaquer
	 * @return retourne le choix
	 */
	private String getChoixAction() { // recupere le choix de l'utilisateur, deplacer ou attaquer
		String tmp;
		
		System.out.println("Voulez vous attaquer (a) ou deplacer un robot (d) ? ");
		tmp=s.next();
		while(!tmp.equalsIgnoreCase("a") && !tmp.equalsIgnoreCase("d")){ // tant que ce n'est ni egal a "a" ni a "d"
			System.out.println("Choix impossible, reessayez: ");
			tmp=s.next();
		}
		return tmp;
	}
	private String getChoixActionIA() { // recupere le choix de l'IA, deplacer ou attaquer
		Random r=new Random();
		
		if(r.nextBoolean())
			return "d";
		return "a";
	}
	/**
	 * Methode pour eviter un try catch
	 * @param l liste de robot 
	 * @param numR numero à parser
	 * @return le robot selectionne
	 */
	private int getRobot(List<Robot> l, String numR) {
		int robot=Integer.parseInt(numR); // parse un String en int
		while(robot>=l.size() || robot<0){ // pose une contrainte de bornes
			System.out.println("Erreur, reessayez");
			numR=s.next();
			robot=Integer.parseInt(numR);
		}
		return robot;
	}
	
	/**
	 * parseur de string en int
	 * @param r un robot
	 * @param l liste de coordonnees
	 * @param direction une direction
	 * @return le String en int
	 */
	private int getDirection(Robot r, List<Coordonnees> l, String direction){ 
		int dir=Integer.parseInt(direction);
		while(dir>=r.getDeplacement().size() || dir<0){ // Contrainte de bornes
			System.out.println("Erreur, reessayez");
			direction=s.next();
			dir=Integer.parseInt(direction);
		}
		return dir;
	}
	/**
	 * Saisie le choix du robot et de la direction de son deplacement/attaque
	 * @param l liste de robot
	 */
	private void saisie(List<Robot> l) {
		String choixAction, numR="", direction="";
		boolean saisieOk=false;
		Robot r=null;
		int robot=0, dir=0;
		
		choixAction=getChoixAction(); // choix attaque ou deplacement
		while(!saisieOk){
			while(!saisieOk){
				System.out.println("Choisissez le numero de votre robot: ");
				numR=s.next(); // saisie du robot
				try{
					robot=getRobot(l, numR); // parseur
					saisieOk=true;
				}
				catch(java.lang.NumberFormatException e){
					System.out.println("Erreur! reessayez");
				}
			}
		}
		saisieOk=false;
		while(!saisieOk){			
			r=l.get(robot);
			while(!saisieOk){
				if(r.getType().substring(0, 1).equalsIgnoreCase("P")) // Si c'est un piegeur
					((Piegeur) r).setDeplacements(); // met a jour les deplacements du piegeur
				else if(r.getType().substring(0, 1).equalsIgnoreCase("T")) // Sinon si c'est un tireur
					((Tireur) r).setDeplacements(); // met a jour les deplacements du tireur
				else{ // Sinon si c'est un char
					((Char) r).setDeplacements(); // met a jour les deplacements du char
					((Char) r).setCasesAttaquables(); // met a jour les cases ou le char peut attaquer
				}
				if(choixAction.equalsIgnoreCase("a") && r.getType().substring(0, 1).equalsIgnoreCase("C"))
					afficheCasesAttaquables((Char) r);
				else
					afficheDeplacements(r); // affiche les deplacements possibles
				direction=s.next();
				try{
					if(choixAction.equalsIgnoreCase("a") && r.getType().substring(0, 1).equalsIgnoreCase("C"))
						dir=getDirectionAttaque((Char) r, r.getDeplacement(), direction);
					else
						dir=getDirection(r, r.getDeplacement(), direction);
					saisieOk=true;
				}
				catch(java.lang.NumberFormatException e){
					System.out.println("Erreur! reessayez");
				}
			}
		}
		if(choixAction.equalsIgnoreCase("a") && r.getType().substring(0, 1).equalsIgnoreCase("C"))
			action(r, ((Char) r).getCasesAttaquables().get(dir), choixAction); // attaque
		else
			action(r, r.getDeplacement().get(dir), choixAction); // deplacement/attaque des piegeurs/tireurs
	}
	
	private int getDirectionAttaque(Char c, List<Coordonnees> deplacement,String direction) {
		int dir=Integer.parseInt(direction);
		while(dir>=c.getCasesAttaquables().size() || dir<0){ // Contrainte de bornes
			System.out.println("Erreur, reessayez");
			direction=s.next();
			dir=Integer.parseInt(direction);
		}
		return dir;
	}
	private void afficheCasesAttaquables(Char c) {
		System.out.println("Choisissez le numero de votre direction parmi la liste ci dessous: ");
		System.out.println("Liste des cases ciblables pour le robot ("+c+": "+c.getEnergie()+" pvs - "+c.getCoordonnees()+")");
		for(int i=0; i<c.getCasesAttaquables().size(); i++)
			System.out.println(c.getCasesAttaquables().get(i)+ " Numero "+i);		
	}
	/**
	 * Augmente la vie des robots presents en base jusqu'à leur maximum
	 * @param l liste de robot en base
	 */
	private void updateLifeRobotEnBase(List<Robot> l) {
		Robot r;
		int x, y;
		
		for(int i=0; i<l.size(); i++){
			r=l.get(i); // robot courant
			x=r.getCoordonnees().getLargeur(); // largeur de la pos du robot
			y=r.getCoordonnees().getHauteur(); // hauteur de la pos du robot
			String s=r.getType().substring(0, 1); // Type du robot
			
			if((x==0 && y==0 || x==Vue.SIZE_X-1 && y==Vue.SIZE_Y-1)){ // Si ce sont les coordonnes d'une base
				if(s.equalsIgnoreCase("T")){ // Si c'est un piegeur
					if(r.getEnergie()<39) 
						r.setEnergie(r.getEnergie()+2);
					else if(r.getEnergie()==39)
						r.setEnergie(40); // Ne depassera jamais 40
				}
				else if(s.equalsIgnoreCase("P")){ // Si c'est un tireur
					if(r.getEnergie()<49)
						r.setEnergie(r.getEnergie()+2);
					else if(r.getEnergie()==49)
						r.setEnergie(50); // ne depassera jamais 50
				}
				else{ // Si c'est un char
					if(r.getEnergie()<59)
						r.setEnergie(r.getEnergie()+2);
					else if(r.getEnergie()==59)
						r.setEnergie(60); // ne depassera jamais 60
				}
			}
		}
	}
	/**
	 * teste si au moins un robot d'une equipe est present sur le terrain
	 * @param p plateau
	 * @param nbEquipe numero d'equipe
	 * @return vrai s'il reste au moins un robot de l'equipe sur le plateau
	 */
	
	private boolean isOneRobotOnField(Plateau p, int nbEquipe) { 
		Robot r;
		
		for(int i=0; i<Vue.SIZE_X; i++){
			for(int j=0; j<Vue.SIZE_Y; j++){
				r=p.getCellule(i, j).getContenu(); // robot courant
				if(r!=null && nbEquipe==r.getEquipe()) // si le robot est dans la case et qu'il est de l'equipe passee en parametre
					return true;
			}
		}
		System.out.println("Plus aucun robot sur le plateau, vous avez perdu!");
		return false;
	}
	/**
	 * Un tour de jeu
	 * @param team nom d'equipe
	 * @param v vue
	 * @param equipe liste de robot
	 */
	private void tour(String team, Vue v, List<Robot> equipe){
		g.setVue(v);
		update(false);
		saisie(equipe);
		update(true);
		updateLifeRobotEnBase(equipe);
	}
	private void update(boolean b){
		Game.clear=b;
		g.update(g.getGraphics());
	}
	private void tourIA(String team, Vue v, List<Robot> equipe){
		g.setVue(v);
		update(false);
		saisieIA(equipe);
		update(true);
		updateLifeRobotEnBase(equipe);
	}
	private void saisieIA(List<Robot> l) {
		String choixAction;
		Robot r=null;
		int robot=0, dir=0;
		Random ra=new Random();
		
		choixAction=getChoixActionIA(); // choix attaque ou deplacement
		robot=ra.nextInt(l.size());
		r=l.get(robot);
		if(r.getType().substring(0, 1).equalsIgnoreCase("P")) // Si c'est un piegeur
			((Piegeur) r).setDeplacements(); // met a jour les deplacements du piegeur
		else if(r.getType().substring(0, 1).equalsIgnoreCase("T")) // Sinon si c'est un tireur
			((Tireur) r).setDeplacements(); // met a jour les deplacements du tireur
		else // Sinon si c'est un char
			((Char) r).setDeplacements(); // met a jour les deplacements du tireur
		dir=ra.nextInt(r.getDeplacement().size());
		action(r, r.getDeplacement().get(dir), choixAction); // deplace ou attaque
	}
	private void setTour2() {
		if(mode==1)
			tour(team2, v2, equipe2);    //  Equipe 2
		else
			tourIA(team2, v2, equipe2);		
	}
	private void partie(){
		ajoutRobots(team1, liste1, equipe1, v1, 1);
		ajoutRobots(team2, liste2, equipe2, v2, 2);
		// Joueur vs Joueur
		while(!jeuFini()){ // Boucle de jeu
			tour(team1, v1, equipe1); // Equipe 1		
			if(!isOneRobotOnField(plateau, 1)){
				equipe1.clear();
				break;
			}
			supprimeRobots(equipe1);		
			setTour2();	// Equipe 2	
			if(!isOneRobotOnField(plateau, 2)){
				equipe2.clear();
				break;
			}
			supprimeRobots(equipe2); // Fin du tour
		}
		update(true);
		afficheGagnant();
	}
	public List<Robot> getListe1(){
		return equipe1;
	}
	public List<Robot> getListe2(){
		return equipe2;
	}
}