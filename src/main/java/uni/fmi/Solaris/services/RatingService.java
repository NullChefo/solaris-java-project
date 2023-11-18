package uni.fmi.Solaris.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import uni.fmi.Solaris.dto.BaseDTO;
import uni.fmi.Solaris.dto.RatingDTO;
import uni.fmi.Solaris.dto.UserDTO;
import uni.fmi.Solaris.models.Product;
import uni.fmi.Solaris.models.Rating;
import uni.fmi.Solaris.models.User;
import uni.fmi.Solaris.repo.RatingRepo;

@Service
public class RatingService extends BaseService<Rating> {

	private final RatingRepo ratingRepo;
	private final UserService userService;

	private final ProductService productService;

	public RatingService(
			final RatingRepo ratingRepo, final UserService userService,
			final ProductService productService) {
		this.ratingRepo = ratingRepo;
		this.userService = userService;
		this.productService = productService;
	}

	@Override
	protected JpaRepository<Rating, Long> getRepo() {
		return this.ratingRepo;
	}

	@Override
	protected Rating convertDTOtoModel(final BaseDTO<Rating> baseDTO) {
		RatingDTO ratingDTO = (RatingDTO) baseDTO;
		Rating rating = new Rating();

		mergeRating(ratingDTO, rating);

		return rating;
	}

	private void mergeRating(final RatingDTO ratingDTO, final Rating rating) {
		final Optional<User> user = userService.getById(ratingDTO.getUserId());
		if (user.isEmpty()) {
			throw new IllegalStateException("The owner of the rating does not exist!");
		}
		final Optional<Product> product = productService.getById(ratingDTO.getProductId());

		if (product.isEmpty()) {
			throw new IllegalStateException("The product does not exist");
		}

		rating.setProduct(product.get());
		rating.setUser(user.get());
		rating.setValue(ratingDTO.getValue());
		rating.setComment(ratingDTO.getComment());
		rating.setProduct(product.get());
		rating.setUser(user.get());
	}

	@Override
	protected void updateEntity(final Rating entity, final BaseDTO<Rating> categoryDTO) {
		RatingDTO ratingDTO = (RatingDTO) categoryDTO;
		mergeRating(ratingDTO, entity);
	}

	@Override
	protected BaseDTO<Rating> convert(final Rating entity) {
		return null;
	}

	public List<RatingDTO> findByUserId(final long userId) {

		Optional<User> user = userService.getById(userId);
		if (user.isEmpty()) {
			throw new IllegalStateException("The user does not exist!");
		}
		return ratingRepo.findByUser(user.get()).stream().map(RatingDTO::new).toList();

	}

	public List<RatingDTO> findByProductId(final long productId) {

		Optional<Product> product = productService.getById(productId);
		if (product.isEmpty()) {
			throw new IllegalStateException("The product does not exist!");
		}
		return ratingRepo.findByProduct(product.get())
						 .stream()
						 .map(RatingDTO::new)
						 .collect(Collectors.toList());

	}

	public List<RatingDTO> findByUserIdAndProductId(final Long userId, final Long productId) {
//		return ratingRepo.findByUserAndProduct(userService.getById(userId).get(), productService.getById(productId).get())
//						 .stream()
//						 .map(RatingDTO::new)
//						 .collect(Collectors.toList());

		Optional<Product> product = productService.getById(productId);
		Optional<User> user = userService.getById(userId);

		return ratingRepo.findByUserAndProduct(user.orElseThrow(), product.orElseThrow())
						 .stream()
						 .map(RatingDTO::new)
						 .collect(Collectors.toList());
	}
}
