package uni.fmi.Solaris.rest;

import java.util.List;
import java.util.Objects;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uni.fmi.Solaris.dto.BaseDTO;
import uni.fmi.Solaris.dto.RatingDTO;
import uni.fmi.Solaris.models.Rating;
import uni.fmi.Solaris.services.RatingService;

@RestController()
@RequestMapping(path = "/rating")
public class RatingController {
	
	private final RatingService ratingService;

	public RatingController(final RatingService ratingService) {
		this.ratingService = ratingService;
		
	}

	@GetMapping()
	public List<BaseDTO<Rating>> list() {
		//categoryService.get(12l);
		return ratingService.getAll();
	}

	@GetMapping(path = "/{categoryId}")
	public BaseDTO<Rating> getRating(@PathVariable(name = "categoryId") long categoryId) {
		return ratingService.getBy(categoryId);
	}

	@PostMapping()
	public BaseDTO<Rating> create(@RequestBody RatingDTO newRating) {
		return ratingService.create(newRating);
	}

	@PutMapping()
	public BaseDTO<Rating> update(@RequestBody RatingDTO newRating) {
		return ratingService.update(newRating);
	}

	@DeleteMapping(path = "/{categoryId}")
	public ResponseEntity<String> remove(@PathVariable(name = "categoryId") long categoryId) {

		boolean isRemoved = ratingService.remove(categoryId);

		String deletedMessage = "Rating with id: '" + categoryId + "' was deleted!";
		String notDeletedMessage = "Rating with id: '" + categoryId + "' does not exists!";
		return isRemoved ?
				new ResponseEntity(deletedMessage, HttpStatusCode.valueOf(200)):
				new ResponseEntity(notDeletedMessage, HttpStatusCode.valueOf(404));
	}


	@GetMapping(path = "/list")
	public List<RatingDTO> list(@RequestParam(name = "userId", required = false) Long userId, @RequestParam(name = "productId", required = false) Long productId ) {

		if (userId != null && productId != null){
			return ratingService.findByUserIdAndProductId(userId, productId);
		}

		if (userId !=  null) {
			return ratingService.findByUserId(userId);
		}

		if (productId != null) {
			return ratingService.findByProductId(productId);
		}

		return null;
	}
	
	
	
}
