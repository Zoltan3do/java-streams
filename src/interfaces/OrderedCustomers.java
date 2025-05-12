package interfaces;

import java.util.List;

import entities.Order;
import entities.Product;

@FunctionalInterface
public interface OrderedCustomers {
	
	List<Product> listaProdottiLivello2(List<Order> prodotti); 

}
