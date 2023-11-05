package uni.fmi.Solaris.utils;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uni.fmi.Solaris.dto.CategoryDTO;
import uni.fmi.Solaris.models.Category;
import uni.fmi.Solaris.models.User;
import uni.fmi.Solaris.repo.CategoryRepo;
import uni.fmi.Solaris.repo.UserRepo;

@Component
public class DataGenerator {
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private UserRepo userRepo;

    @PostConstruct
    public void initCategories() {
        if (categoryRepo.count() == 0) {
            Category category = new Category();
            category.setName("Category 1");
            category.setVatPercent(12);
            categoryRepo.save(category);

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
}
