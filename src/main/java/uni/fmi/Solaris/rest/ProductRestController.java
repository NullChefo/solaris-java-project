package uni.fmi.Solaris.rest;

import java.util.List;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uni.fmi.Solaris.dto.BaseDTO;
import uni.fmi.Solaris.dto.ProductDTO;
import uni.fmi.Solaris.dto.UserDTO;
import uni.fmi.Solaris.models.Product;
import uni.fmi.Solaris.models.User;
import uni.fmi.Solaris.services.ProductService;

@RestController()
@RequestMapping(path = "/product")
public class ProductRestController {

	private final ProductService productService;

	public ProductRestController(final ProductService productService) {
		this.productService = productService;
	}

	@GetMapping
	public List<BaseDTO<Product>> findAll() {
		return productService.getAll();
	}


	@GetMapping(path = "/{productId}")
	public BaseDTO<Product> getProduct(@PathVariable(name = "productId") long productId) {
		return productService.getBy(productId);
	}

	@PostMapping()
	public BaseDTO<Product> create(@RequestBody ProductDTO newProduct) {
		return productService.create(newProduct);
	}

	@PutMapping()
	public BaseDTO<Product> update(@RequestBody ProductDTO newProduct) {
		return productService.update(newProduct);
	}

	@DeleteMapping(path = "/{productId}")
	public ResponseEntity<String> remove(@PathVariable(name = "productId") long productId) {

		boolean isRemoved = productService.remove(productId);

		String deletedMessage = "Product  with id: '" + productId + "' was deleted!";
		String notDeletedMessage = "Product with id: '" + productId + "' does not exists!";
		return isRemoved ?
				new ResponseEntity<>(deletedMessage, HttpStatusCode.valueOf(200)) :
				new ResponseEntity<>(notDeletedMessage, HttpStatusCode.valueOf(404));
	}
}
