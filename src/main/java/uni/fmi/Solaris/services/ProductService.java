package uni.fmi.Solaris.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import uni.fmi.Solaris.dto.BaseDTO;
import uni.fmi.Solaris.models.Product;
import uni.fmi.Solaris.repo.ProductRepo;
@Service
public class ProductService extends BaseService<Product>{
    @Autowired
    private ProductRepo productRepo;
    @Override
    protected JpaRepository<Product, Long> getRepo() {
        return productRepo;
    }

    @Override
    protected Product convertDTOtoModel(BaseDTO<Product> baseDTO) {
        return null;
    }

    @Override
    protected void updateEntity(Product entity, BaseDTO<Product> categoryDTO) {

    }

    @Override
    protected BaseDTO<Product> convert(Product entity) {
        return null;
    }
}
