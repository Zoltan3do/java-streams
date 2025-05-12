package interfaces;
import java.util.List;

import entities.Product;

@FunctionalInterface
public interface BooksInterface {
	
	List<Product> underUndred(List<Product> products);

}
