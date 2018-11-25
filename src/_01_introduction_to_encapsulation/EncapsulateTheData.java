package _01_introduction_to_encapsulation;

/*
 * Encapsulation is a way of protecting the data in a class from being
 * unintentionally altered from another class.
 * 
 * To encapsulate a member variable, follow these three steps:
 * 
 * 1. Make the member variable private (or protected)
 * 
 * 2. Make a getter and setter method (accessor and mutator) for the variable.
 * 
 * 3. Add restrictions to the setter method so the member variable cannot be 
 * 	  adversely altered
 * 
 * */


public class EncapsulateTheData {
	//1. Encapsulate the member variables.
	//   Add restrictions to the setters according to the comment.
	
	//2. Create a new JUnit Test case and write tests to verify that 
	//   the member variables' getters and setters are working
	
	int itemsReceived; //must not be negative. All negative arguments get set to 0.
	float degreesTurned; //must be locked between 0.0 and 360.0 inclusive.
	String nomenclature = " "; //must not be set to a blank string. Blank Strings get set to a space
	Object memberObj; //can be any object type except String. Strings get turned into objects.
	
	
	public int getItemsReceived()
	{
		return itemsReceived;
	}
	public void setItemsReceived(int x)
	{
		if(x < 0) {itemsReceived = 0;}
		else {itemsReceived = x;}
	}
	
	public float getDegreesTurned() {return degreesTurned;}
	public void setDegreesTurned(float x) 
	{
		degreesTurned = x%360;
	}
	
	public String getNomenclature() {return nomenclature;}
	public void setNomenclature(String s)
	{
		if(s.length() == 0) {nomenclature = " ";}
		else {nomenclature = s;}
	}
	
	public Object getMemberObj() {return memberObj;}
	public void setMemberObj(Object o)
	{
		if(o.getClass().getName().equalsIgnoreCase("java.lang.String")) {memberObj = new Object();}
		else {memberObj = o;}
	}
	
}
