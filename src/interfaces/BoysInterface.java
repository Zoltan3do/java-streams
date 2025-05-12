package interfaces;

import java.util.List;

import entities.Product;

@FunctionalInterface
public interface BoysInterface {
	
	List<Product> boysDiscount(List<Product> products);
	
}
