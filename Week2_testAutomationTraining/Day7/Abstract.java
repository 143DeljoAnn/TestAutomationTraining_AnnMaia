package Day7;

abstract class AnimalEg {
	String move;
	String name;
	String color;
	
	abstract void move();
	abstract void name();
	abstract void color();
	
	AnimalEg(String move, String name, String color){
		this.move = move;
		this.name = name;
		this.color = color;
	}
	
	void eat() {
		System.out.println("Animal.eat()");
	}
}

//concrete class
class Snake extends AnimalEg{

	Snake(String move, String name, String color) {
		super(move, name, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	void move() {
		System.out.println(this.move);
		
	}

	@Override
	void name() {
		System.out.println(this.name);
		
	}

	@Override
	void color() {
		System.out.println(this.color);
	}
	
}
public class Abstract {
	public static void main(String[] args) {
		AnimalEg obj = new Snake("Crawling...","Nagin...", "white...");
		obj.move();
		obj.color();
		obj.name();
	}
}