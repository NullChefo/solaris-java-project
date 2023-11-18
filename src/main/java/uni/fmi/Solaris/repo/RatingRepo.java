package uni.fmi.Solaris.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uni.fmi.Solaris.models.Product;
import uni.fmi.Solaris.models.Rating;
import uni.fmi.Solaris.models.User;

@Repository
public interface RatingRepo extends JpaRepository<Rating, Long> {

	List<Rating> findByUser(final User owner);

	List<Rating> findByProduct(final Product relatedProduct);

	List<Rating> findByUserAndProduct(User user, Product product);
}

