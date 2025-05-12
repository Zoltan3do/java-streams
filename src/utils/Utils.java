package utils;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import entities.Order;
import entities.Product;
import interfaces.BabyInterface;
import interfaces.BooksInterface;
import interfaces.OrderedCustomers;

public class Utils {

	public static List<Product> babies(List<Product> products){

		BabyInterface filteredBabies = (List<Product> productList) -> 
		productList.stream()
		.filter(p -> p.getCategory().equalsIgnoreCase("Baby"))
		.collect(Collectors.toList());

		List<Product> babies = filteredBabies.babies(products);
		return babies;

	}

	public static List<Product> booksUnderPrice(List<Product> products) {

		BooksInterface filteredBooks = (List<Product> productList) -> 
		productList.stream()
		.filter(p -> p.getPrice() < 100 && p.getCategory().equalsIgnoreCase("Books"))
		.collect(Collectors.toList());

		List<Product> booksUnderPriced = filteredBooks.underUndred(products);
		return booksUnderPriced;
	}

	public static List<Product> boysDiscounted(List<Product> products) {

		BooksInterface filteredBoys = (List<Product> productList) -> 
		productList.stream()
		.filter(p -> p.getCategory().equalsIgnoreCase("Boys"))
		.map(p -> new Product(p.getId(), p.getName(), p.getCategory(), p.getPrice()-(p.getPrice()/10 )))
		.collect(Collectors.toList());

		List<Product> boysUnderPriced = filteredBoys.underUndred(products);
		return boysUnderPriced;
	}

	public static List<Product> layer2product(List<Order> prodotti){
		
		OrderedCustomers prodottiFiltrati = (List<Order> listaOrdini) ->
		listaOrdini.stream()
		.filter(o -> o.getCustomer().getTier() == 2 
		&& (o.getOrderDate().isAfter(LocalDate.of(2021,2,1)) 
				&& o.getOrderDate().isBefore(LocalDate.of(2021,4,1))))
		.flatMap(o -> o.getProducts().stream())
		.collect(Collectors.toList());
		
		List<Product> inRangeProduct = prodottiFiltrati.listaProdottiLivello2(prodotti);
		
		return inRangeProduct;
	}
}
