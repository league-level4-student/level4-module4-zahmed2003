package complex;

public class ComplexNumber 
{
	private double a;
	private double b;
	
	public ComplexNumber(double a, double b)
	{
		this.a = a;
		this.b = b;
	}
	
	public double getReal() {return a;}
	public double getImaginary() {return b;}
	public void setReal(double x) {a = x;}
	public void setImaginary(double x) {b = x;}
	public double getLength() {return Math.sqrt(a*a+b*b);}
	public double getAngle() {return Math.atan2(a, b);}
	
	public void add(ComplexNumber c)
	{
		a += c.getReal();
		b += c.getImaginary();
	}
	
	public void multiply(ComplexNumber c)
	{
		a = a*c.getReal() - b*c.getImaginary();
		b = a*c.getImaginary() + b*c.getReal();
	}
	
	public void pow(double n)
	{
		double r = Math.pow(a*a+b*b, n/2);
		double theta = Math.atan2(a, b)*n;
		
		a = r*Math.cos(theta);
		b = r*Math.sin(theta);
	}
	
	@Override
	public String toString()
	{
		String s = "";
		if(b > 0) {s = a + " + " + b + "i";}
		else {s = a + " - " + -b + "i";}
		return s;
	}
	
}
