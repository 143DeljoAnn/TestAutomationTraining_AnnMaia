package Day7;

class Product1 {

	int id;
	String name;
	
	void display() {
		
		System.out.println("Product.dis");
	}
}

class ElectronicProduct1 extends Product {
	
	float voltage;
	
	void display() {
		System.out.println("ElectronicProducts");
	}
}

public class OverrideEquals {

	public static void main(String[] args) {
		Product obj1 = new Product();
		Product obj2 = new Product();
		System.out.println("obj1"+obj1);
		System.out.println("obj2"+obj2);
		System.out.println(obj1.equals(obj2)); 
}
}