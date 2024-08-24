package Day7;


class Product {

	int id;
	String name;
	
	void display() {
		
		System.out.println("Product.dis");
	}
}

class ElectronicProduct extends Product {
	
	float voltage;
	
	void display() {
		System.out.println("ElectronicProducts");
	}
}

public class Overriding {
	
	public static void main(String[] args) {
		
		Product obj = new ElectronicProduct();
		obj.display();
		}
}

