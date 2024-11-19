


package Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import Model.Product;

@Service // which helps to create list using Spring
public class PService {

	// for now we just create an temp data
	private final List<Product> product = new ArrayList<> (Arrays.asList(new Product(1,"Casio217w",1675), new Product(2,"CasioA500",2400),
			new Product(3,"Casio M24",1200))); // we are creating it as new array due to immutable nature it cant be get into post method in post man

	public List<Product> getProduct() {
		return product;

	}
	
	// for fetching the data using get and Stream API
	public Product getProductById(int pid) {
		// TODO Auto-generated method stub
		return product.stream() // which allows to get stream of inputs.
				.filter(p -> p.getPid() == pid)
				.findFirst().orElse(new Product(0,"unknown",0));
	}
	
	//to put the data in the list
	public void addProduct(Product prod) {
		product.add(prod);
	}
	
	public void updateProduct(Product prod) {
		int index = 0;
		for (int i =0;i<product.size();i++) {
			if(product.get(i).getPid() == prod.getPid()) {
				index = i;
				
				product.set(index,prod);
			}
		}
	}

	public void deletProduct( int  pid) {
		// TODO Auto-generated method stub
		int index = 0;
		for (int i=0;i<product.size();i++) {
			if (product.get(i).getPid() == pid) {
				
				product.remove(i);
			}
		}
	}
}
