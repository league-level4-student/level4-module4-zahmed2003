package _01_introduction_to_encapsulation;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class EncapsulationTest{
	
	EncapsulateTheData e = new EncapsulateTheData();
	
	@Test
	public void testItemsReceived()
	{
		e.setItemsReceived(10);
		assertEquals(10, e.getItemsReceived());
		
		e.setItemsReceived(-50);
		assertEquals(0, e.getItemsReceived());
	}
	
	@Test
	public void testDegreesTurned()
	{
		e.setDegreesTurned(361);
		assertEquals(1, e.getDegreesTurned());
	}
	
	@Test
	public void testNomenclature()
	{
		e.setNomenclature("XYZ");
		assertEquals("XYZ", e.getNomenclature());
		
		e.setNomenclature("");
		assertEquals(" ", e.getNomenclature());
	}
	
	@Test
	public void testMemberObj()
	{
		e.setMemberObj(10);
		assertEquals(e.getMemberObj(), 10);
		
		int[] x = {0,1,2};
		e.setMemberObj(x);
		assertEquals(x, e.getMemberObj());
		
		e.setMemberObj('a');
		assertEquals('a', e.getMemberObj());
		
		e.setMemberObj("test");
		assertEquals(new Object().getClass(), e.getMemberObj().getClass());
	}
	
}
