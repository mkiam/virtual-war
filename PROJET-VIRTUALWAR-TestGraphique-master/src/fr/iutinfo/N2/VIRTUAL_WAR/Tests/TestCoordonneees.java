
package fr.iutinfo.N2.VIRTUAL_WAR.Tests;
import fr.iutinfo.N2.VIRTUAL_WAR.Coordonnees.Coordonnees;


import junit.framework.Assert;
import org.junit.Test;

public class TestCoordonneees {
	//test toString
	@Test
	public void testToString(){
		Coordonnees c=new Coordonnees(2,2);
		Assert.assertEquals(c.toString(),"(2;2)");

	}
}