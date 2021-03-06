
package fr.iutinfo.N2.VIRTUAL_WAR.Tests;
import fr.iutinfo.N2.VIRTUAL_WAR.Action.Action;
import fr.iutinfo.N2.VIRTUAL_WAR.Action.Attaque;
import fr.iutinfo.N2.VIRTUAL_WAR.Coordonnees.Coordonnees;
import fr.iutinfo.N2.VIRTUAL_WAR.Plateau.Plateau;
import fr.iutinfo.N2.VIRTUAL_WAR.Plateau.Vue;
import fr.iutinfo.N2.VIRTUAL_WAR.Robot.Char;
import fr.iutinfo.N2.VIRTUAL_WAR.Robot.Robot;


import junit.framework.Assert;
import org.junit.Test;

public class TestAction{

//test getObectif
   @Test
	public void testObjectif(){
		Coordonnees co=new Coordonnees(2,2);
		Coordonnees c=new Coordonnees(1,1);
		Plateau p=new Plateau(10,10,5);
		Vue v=new Vue(1,p);
		Robot r=new Char(v,1,1,1);
		r.setCoordonnees(c);
		Action a=new Attaque(r,co);
		Coordonnees coo=new Coordonnees(co.getLargeur()+r.getCoordonnees().getLargeur(),co.getHauteur()+r.getCoordonnees().getHauteur());
		Assert.assertEquals(a.getObjectif(),coo);
	}
   }