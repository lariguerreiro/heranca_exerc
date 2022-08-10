package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		List<Product> products = new ArrayList<Product>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			System.out.println("Product #" + i + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			String name = sc.next();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			if(ch == 'i') {
				System.out.print("Customs Fee: ");
				double customsFee = sc.nextDouble();
				products.add(new ImportedProduct(name, price, customsFee));
			} else if(ch == 'u') {
				System.out.print("Manufacture Date (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(sc.next());
				products.add(new UsedProduct(name, price, manufactureDate));
			} else if(ch == 'c') {
				products.add(new Product(name, price));
			}	
		}
		
		System.out.println();
		System.out.println("Price tags:");
		for (Product p : products) {
			System.out.println(p.priceTag());
		}
		
		
		sc.close();

	}

}
