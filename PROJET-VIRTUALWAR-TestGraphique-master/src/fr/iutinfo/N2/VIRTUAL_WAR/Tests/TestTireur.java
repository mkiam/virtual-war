package fr.iutinfo.N2.VIRTUAL_WAR.Tests;
import fr.iutinfo.N2.VIRTUAL_WAR.Plateau.Plateau;
import fr.iutinfo.N2.VIRTUAL_WAR.Plateau.Vue;
import fr.iutinfo.N2.VIRTUAL_WAR.Robot.Tireur;
import junit.framework.Assert;
import org.junit.Test;

public class TestTireur{
	//test peutTirer
	@Test
	public void testPeutTirer(){
		Plateau p=new Plateau(10,10,5);
		Vue vu=new Vue(1,p);
		Tireur t=new Tireur(vu,1,1,1);
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
		Tireur t1=new Tireur(vu1,1,1,1);
		Assert.assertEquals(t1.getCoutAction(),2);

	}
	//test coutDep
	@Test
	public void testCoutDep(){
		Plateau p2=new Plateau(10,10,5);
		Vue vu2=new Vue(1,p2);
		Tireur t2=new Tireur(vu2,1,1,1);
		Assert.assertEquals(t2.getCoutDep(),1);

	}

	//test DegatTir
	@Test
	public void testDegatTir(){
		Plateau p3=new Plateau(10,10,5);
		Vue vu3=new Vue(1,p3);
		Tireur t3=new Tireur(vu3,1,1,1);
		Assert.assertEquals(t3.getDegatTir(),3);

	}

	//test DegatMine
	@Test
	public void testDegatMine(){
		Plateau p4=new Plateau(10,10,5);
		Vue vu4=new Vue(1,p4);
		Tireur t4=new Tireur(vu4,1,1,1);
		Assert.assertEquals(t4.getDegatMine(),3);

	}

	//test Type
	@Test
	public void testType(){
		Plateau p5=new Plateau(10,10,5);
		Vue vu5=new Vue(1,p5);
		Tireur t5=new Tireur(vu5,1,1,1);
		Assert.assertEquals(t5.getType(),new String("Tireur 1"));

	}
}