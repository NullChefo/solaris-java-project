package uni.fmi.Solaris.utils;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uni.fmi.Solaris.models.Category;
import uni.fmi.Solaris.models.Product;
import uni.fmi.Solaris.models.User;
import uni.fmi.Solaris.repo.CategoryRepo;
import uni.fmi.Solaris.repo.ProductRepo;
import uni.fmi.Solaris.repo.UserRepo;

@Component
public class DataGenerator {
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private UserRepo userRepo;

    @PostConstruct
    public void initCategories() {
        if (categoryRepo.count() == 0) {
            Category category = new Category();
            category.setName("Category 1");
            category.setVatPercent(12);
            final Product prod1 = createProduct(category,
                                            100,
                                            "Product 1",
                                            10);
            category.addProduct(prod1);
            category.addProduct(createProduct(category, 45.59, "Product 2", 2));
            categoryRepo.save(category);
            productRepo.saveAll(category.getProducts());

            Category category2 = new Category();
            category2.setName("Category 2");
            category2.setVatPercent(21);
            categoryRepo.save(category2);
        }

        if(userRepo.count()==0){
            User user = new User();
            user.setName("Ivan");
            user.setEmail("ivan@test.com");
            user.setAddress("Plovdiv");
            user.setPassword("password");
            user.setPhone("+359888969696");
            userRepo.save(user);
        }

    }

    private Product createProduct(Category category, double price, String name, int quantity) {
        Product product = new Product();
        product.setPrice(price);
        product.setName(name);
        product.setQuantity(quantity);
        product.setCategory(category);
        return product;
    }
}
