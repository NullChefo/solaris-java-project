package uni.fmi.Solaris.utils;

import jakarta.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import uni.fmi.Solaris.models.Category;
import uni.fmi.Solaris.models.Product;
import uni.fmi.Solaris.models.Rating;
import uni.fmi.Solaris.models.User;
import uni.fmi.Solaris.repo.CategoryRepo;
import uni.fmi.Solaris.repo.ProductRepo;
import uni.fmi.Solaris.repo.RatingRepo;
import uni.fmi.Solaris.repo.UserRepo;

@Component
public class DataGenerator {
	private final CategoryRepo categoryRepo;
	private final UserRepo userRepo;

	private final ProductRepo productRepo;
	private final RatingRepo ratingRepo;

	public DataGenerator(final CategoryRepo categoryRepo, final UserRepo userRepo, final ProductRepo productRepo,
						 final RatingRepo ratingRepo) {
		this.categoryRepo = categoryRepo;
		this.userRepo = userRepo;
		this.productRepo = productRepo;
		this.ratingRepo = ratingRepo;
	}

	@PostConstruct
	public void initCategories() {
		if (categoryRepo.count() == 0) {
			Category category = new Category();
			category.setName("Category 1");
			category.setVatPercent(12);


			category.addProduct(createProduct(100, "Product 1", 2, category));

			category.addProduct(createProduct(200, "Product 2", 2, category));
			category.addProduct(createProduct(300, "Product 3", 2, category));

			category.addProduct(createProduct(-500, "Product 5", 5, category));


			categoryRepo.save(category);
			productRepo.saveAll(category.getProducts());

			Category category2 = new Category();
			category2.setName("Category 2");
			category2.setVatPercent(21);
			categoryRepo.save(category2);
		}

		if (userRepo.count() == 0) {
			User user = new User();
			user.setName("Ivan");
			user.setEmail("ivan@test.com");
			user.setAddress("Plovdiv");
			user.setPassword("password");
			user.setPhone("+359888969696");
			userRepo.save(user);
		}


		if (ratingRepo.count() == 0){
			ratingRepo.save(Rating.builder().value(3)
								  .product(productRepo.findById(1L).get())
								  .user(userRepo.findById(1L).get())
								  .build());
		}

//		if (productRepo.count() == 0) {
//			Product product =
//			productRepo.save(product);
//
//		}

	}

	private Product createProduct(double price, String name, int quantity, Category category){
		return Product
				.builder()
				.price(price)
				.name(name)
				.description("description")
				.quantity(quantity)
				.category(category)
				.build();
	}


}
