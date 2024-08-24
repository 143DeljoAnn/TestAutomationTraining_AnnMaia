package Day8;

interface Circle {
	
	
	double PI = 3.14;
	double getSurfaceArea(double radius);
	double getCircumference (double radius);
}

class CircleEg implements Circle {
	
	@Override
	public double getSurfaceArea(double radius) {
		return 2*PI*radius;
	}
 
	@Override
	public double getCircumference(double radius) {
		return PI*radius;
	}
	
}
public class Interface {
	
    public static void main(String[] args) {
		
		Circle obj = new CircleEg();
		System.out.println("Circumference of the Circle is "+ obj.getCircumference(5));
		System.out.println("Surface Area of the Circle is " + obj.getSurfaceArea(6));
		
		}
	

}
