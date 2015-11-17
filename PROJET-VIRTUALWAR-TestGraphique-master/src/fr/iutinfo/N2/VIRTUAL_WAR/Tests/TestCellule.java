
package fr.iutinfo.N2.VIRTUAL_WAR.Tests;
import fr.iutinfo.N2.VIRTUAL_WAR.Cellule.Case;
import fr.iutinfo.N2.VIRTUAL_WAR.Cellule.Cellule;

import junit.framework.Assert;
import org.junit.Test;

public class TestCellule{
	
	//testtoString
   @Test
   public void testToString(){
   Cellule c1=new Case(3,3);
		c1.setMine(new Integer(1));
  Assert.assertEquals(c1.toString(),new String("X"));
   Cellule c2=new Case(3,3);
		c2.setObstacle(true);
  Assert.assertEquals(c2.toString(),new String("O"));
   Cellule c3=new Case(3,3);
		c3.setBase(new Integer(1));
  Assert.assertEquals(c3.toString(),new String("b"));
  
  
   }	
	//test BaseParEquipe
   @Test
	public void testBaseParEquipe(){
		Cellule cel=new Case(3,3);
		cel.setBase(new Integer(1));
		Assert.assertEquals(cel.getBaseParEquipe(),new String("b"));
		Cellule cel1=new Case(2,2);
		cel1.setBase(new Integer(2));
		Assert.assertEquals(cel1.getBaseParEquipe(),new String("B"));
	}
   }