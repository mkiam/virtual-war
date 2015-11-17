package fr.iutinfo.N2.VIRTUAL_WAR.Tests;
import fr.iutinfo.N2.VIRTUAL_WAR.Plateau.Plateau;
import fr.iutinfo.N2.VIRTUAL_WAR.Plateau.Vue;
import fr.iutinfo.N2.VIRTUAL_WAR.Robot.Piegeur;


import junit.framework.Assert;
import org.junit.Test;

public class TestPiegeur{
	//test peutTirer
	@Test
	public void testPeutTirer(){
		Plateau p=new Plateau(10,10,5);
		Vue vu=new Vue(1,p);
		Piegeur t=new Piegeur(vu,1,1,1);
		t.setEnergie(0);
		Assert.assertFalse(t.peutTirer());
		t.setEnergie(1);
		Assert.assertFalse(t.peutTirer());
		t.setEnergie(3);
		Assert.assertTrue(t.peutTirer());
	}


	//test coutAction
	@Test	
	public void testCoutAction(){
		Plateau p1=new Plateau(10,10,5);
		Vue vu1=new Vue(1,p1);
		Piegeur t1=new Piegeur(vu1,1,1,1);
		Assert.assertEquals(t1.getCoutAction(),2);

	}

	//test coutDep
	@Test
	public void testCoutDep(){
		Plateau p2=new Plateau(10,10,5);
		Vue vu2=new Vue(1,p2);
		Piegeur t2=new Piegeur(vu2,1,1,1);
		Assert.assertEquals(t2.getCoutDep(),2);

	}

	//test DegatTir
	@Test
	public void testDegatTir(){
		Plateau p3=new Plateau(10,10,5);
		Vue vu3=new Vue(1,p3);
		Piegeur t3=new Piegeur(vu3,1,1,1);
		Assert.assertEquals(t3.getDegatTir(),2);

	}

	//test DegatMine
	@Test
	public void testDegatMine(){
		Plateau p4=new Plateau(10,10,5);
		Vue vu4=new Vue(1,p4);
		Piegeur t4=new Piegeur(vu4,1,1,1);
		Assert.assertEquals(t4.getDegatMine(),2);

	}

	//test Type
	@Test
	public void testType(){
		Plateau p5=new Plateau(10,10,5);
		Vue vu5=new Vue(1,p5);
		Piegeur t5=new Piegeur(vu5,1,1,1);
		Assert.assertEquals(t5.getType(),new String("Piegeur 1"));

	}
}
