package Day4;


class Scart{
    //data members
    //Array of Products
    Product sprod[];
    int cindex;
    //Constructor
    Scart(){
        sprod=new Product[3];
        cindex=0;
    }
    //Member Methods
    //Add Product
    Product addProduct(Product prod){
        sprod[cindex]=prod;
        cindex++;
        return prod;
    }
    //List Product
    void listProduct(){
        System.out.println("----------------------------------");
        for(int i=0;i<cindex;i++){
            sprod[i].display();
        }
        System.out.println("----------------------------------");
    }
    //Empty ShoppingCart
    void emptyCart(){
        sprod=new Product[3];
        cindex=0;
        System.out.println("Deleted all products in cart");
    }
    //Checkout ShoppingCart with Total amount
    void checkoutCart(){
        float total=0;
        for(int i=0;i<cindex;i++){
            total+=sprod[i].price;
        }
        System.out.println("Total of All products   |"+total);
    }
}
class Product{
    int id;
    String name;
    float price;
    Product(){
        id=0;
		name="A";
		price=1;
    }
    Product(int pid, String pname,float pprice){
        id=pid;
		name=pname;
		price=pprice;
    }
    void display(){
        System.out.println(id+"\t|"+name+"\t\t|"+price);
    }
}
public class ShoppingCart
{
	public static void main(String[] args) {
		
		//Enhances for loop
		System.out.println("Item Details");
		System.out.println("Id   "+"\t|"+"Name      "+"\t|Price  ");
		Scart scart= new Scart();
		Product p1= new Product(100,"Chair",1000);
		scart.addProduct(p1);
		Product p2= new Product(101,"Table",2000);
		scart.addProduct(p2);
		Product p3= new Product(103,"Sofa",3000);
		scart.addProduct(p3);
		scart.listProduct();
		scart.checkoutCart();
		scart.emptyCart();
		scart.listProduct();
		
	}
}
