
package fr.iutinfo.N2.VIRTUAL_WAR.Tests;
import fr.iutinfo.N2.VIRTUAL_WAR.Plateau.Plateau;
import fr.iutinfo.N2.VIRTUAL_WAR.Plateau.Vue;
import fr.iutinfo.N2.VIRTUAL_WAR.Robot.Char;


import junit.framework.Assert;
import org.junit.Test;

public class TestChar{
	@Test
	//test peutTirer
	public void testPeutTirer(){
		Plateau p=new Plateau(10,10,5);
		Vue vu=new Vue(1,p);
		Char t=new Char(vu,1,1,1);
		t.setEnergie(0);
		Assert.assertFalse(t.peutTirer());
		t.setEnergie(1);
		Assert.assertFalse(t.peutTirer());
		t.setEnergie(3);
		Assert.assertTrue(t.peutTirer());
	}
	
	@Test
	//test coutAction
	public void testCoutAction(){
		Plateau p2=new Plateau(10,10,5);
		Vue vu2=new Vue(1,p2);
		Char t2=new Char(vu2,1,1,1);
		Assert.assertEquals(t2.getCoutAction(),1);

	}
	@Test
	//test coutDep
	public void testCoutDep(){
		Plateau p3=new Plateau(10,10,5);
		Vue vu3=new Vue(1,p3);
		Char t3=new Char(vu3,1,1,1);
		Assert.assertEquals(t3.getCoutDep(),5);

	}

	@Test
	//test DegatTir
	public void testDegatTir(){
		Plateau pl3=new Plateau(10,10,5);
		Vue vue3=new Vue(1,pl3);
		Char ta3=new Char(vue3,1,1,1);
		Assert.assertEquals(ta3.getDegatTir(),6);

	}
	@Test
	//test DegatMine
	public void testDegatMine(){
		Plateau p4=new Plateau(10,10,5);
		Vue vu4=new Vue(1,p4);
		Char t4=new Char(vu4,1,1,1);
		Assert.assertEquals(t4.getDegatMine(),6);

	}
	@Test
	//test Type
	public void testType(){
		Plateau p5=new Plateau(10,10,5);
		Vue vu5=new Vue(1,p5);
		Char t5=new Char(vu5,1,1,1);
		Assert.assertEquals(t5.getType(),new String("Char 1"));

	}
}