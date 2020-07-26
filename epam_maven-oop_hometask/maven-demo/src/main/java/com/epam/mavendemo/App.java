package com.epam.mavendemo;
import java.util.Scanner;

interface NYG{
	public abstract String getName();
	public abstract int getQuantity();
	public abstract double getPrice();
}
abstract class Sweets implements NYG{
	protected String name;
	protected int quantity;
	protected double price;
	Sweets(String n , int a, double b){
		name = n;
		quantity = a;
		price = b;
	}
	public abstract int updateQuantity(int quan);
	public abstract double updatePrice(int quan);
}
class Chocolates implements NYG {
	private String name;
    private int quantity;
    private double price;

    Chocolates(String n, int q, double p) {
        name = n;
        quantity = q;
        price = p;
    }
    public String getName() {
    	return name;
    }
    public int getQuantity() {
    	return quantity;
    }
    public double getPrice() {
    	return price;
    }
    public int updateQuantity(int qun) {
    	return quantity+qun;
    }
	public double updatePrice(int quan) {
		return (getPrice()*updateQuantity(quan));
	}
}
class Truffles extends Chocolates{
	public Truffles(int qun, double price) {
		super("Truffles",qun, price);
	}
}
class JamShortBreads extends Sweets{
	private static String nam = "JamShortBreads";
	public JamShortBreads(int quantity, double price) {
		super(nam, quantity, price);
	}
	public String getName() {
		return super.name;
	}
	public int getQuantity() {
		return super.quantity;
	}
	public double getPrice() {
		return super.price;
	}
	public int updateQuantity(int qun) {
    	return quantity+qun;
    }
	public double updatePrice(int quan) {
		return (getPrice()*updateQuantity(quan));
	}
}

public class App 
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number items to gift: ");
    	int gift = sc.nextInt();
    	for(int i=0;i<gift;i++) {
	        System.out.println("Enter\n 1.Jam Shortbread --> sweet\n 2.Truffles --> chocolate\n");
	        String s = sc.next();
	        if(s.equals("Jam Shortbread")) {
	        	System.out.println("Enter quantity of sweets required in number: ");
	        	int quantity = sc.nextInt();
	        	System.out.println("Enter price of sweet: ");
	        	double price = sc.nextDouble();
	        	JamShortBreads js = new JamShortBreads(quantity,price);
	        	System.out.println("Enter quantity of sweets to be increased: ");
	        	int increquan = sc.nextInt(); 
	        	System.out.println("Name of sweets:"+js.getName());
	        	System.out.println("Quantity of sweets:"+js.getQuantity());
	        	System.out.println("Price of sweets:"+js.getPrice());
	        	System.out.println("Updated Quantity of sweets:"+js.updateQuantity(increquan));
	        	System.out.println("Updated Price of sweets:"+js.updatePrice(increquan));
	        }
	        else if(s.equals("Truffles")) {
	        	System.out.println("Enter quantity of chocolates required in number: ");
	        	int quantity = sc.nextInt();
	        	System.out.println("Enter price of chocolates: ");
	        	double price = sc.nextDouble();
	        	Truffles tr = new Truffles(quantity,price);
	        	System.out.println("Enter quantity of chocolates to be increased: ");
	        	int increquan = sc.nextInt(); 
	        	tr.updateQuantity(increquan);
	        	System.out.println("Name of chocolates:"+tr.getName());
	        	System.out.println("Quantity of chocolates:"+tr.getQuantity());
	        	System.out.println("Price of chocolates:"+tr.getPrice());
	        	System.out.println("Updated Quantity of chocolates:"+tr.updateQuantity(increquan));
	        	System.out.println("Updated Price of chocolates:"+tr.updatePrice(increquan));
	        }
	        else {
	        	System.out.println("Choose from above two gifts");
	        }
    	}
    	sc.close();
    }
}
