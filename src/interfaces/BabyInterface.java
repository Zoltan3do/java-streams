package interfaces;

import java.util.List;

import entities.Product;

@FunctionalInterface
public interface BabyInterface {
	
	List<Product> babies(List<Product> products);

}
