package fr.iutinfo.N2.VIRTUAL_WAR.Tests;
import fr.iutinfo.N2.VIRTUAL_WAR.Coordonnees.Coordonnees;
import fr.iutinfo.N2.VIRTUAL_WAR.Plateau.Plateau;
import fr.iutinfo.N2.VIRTUAL_WAR.Plateau.Vue;
import fr.iutinfo.N2.VIRTUAL_WAR.Robot.Char;
import fr.iutinfo.N2.VIRTUAL_WAR.Robot.Piegeur;
import fr.iutinfo.N2.VIRTUAL_WAR.Robot.Robot;

import junit.framework.Assert;

import org.junit.Test;


public class TestRobot{

	//test estSurBase
	@Test
	public void testEstSurBase(){
		Coordonnees c=new Coordonnees(0,0);
		Plateau p5=new Plateau(10,10,5);
		Vue vu5=new Vue(1,p5);
		Robot t5=new Piegeur(vu5,1,1,1);
		t5.setCoordonnees(c);
		Assert.assertTrue(t5.estSurBase());
		Coordonnees c1=new Coordonnees(9,9);
		Plateau p6=new Plateau(10,10,5);
		Vue vu6=new Vue(1,p6);
		Robot t6=new Piegeur(vu6,1,1,1);
		t6.setCoordonnees(c1);
		Assert.assertFalse(t6.estSurBase());

	}
	//Test toString
	@Test
	public void testToString(){
		Plateau p5=new Plateau(10,10,5);
		Vue vu5=new Vue(1,p5);
		Char t5=new Char(vu5,1,1,1);
		Assert.assertEquals(t5.toString(),new String("c"));
		Plateau p6=new Plateau(10,10,5);
		Vue vu6=new Vue(2,p6);
		Char t6=new Char(vu6,1,1,2);
		Assert.assertEquals(t6.toString(),new String("C"));
	}

}