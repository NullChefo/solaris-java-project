package uni.fmi.Solaris.dto;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uni.fmi.Solaris.models.Product;
import uni.fmi.Solaris.models.Rating;
import uni.fmi.Solaris.models.User;

@Getter
@Setter
@NoArgsConstructor
public class RatingDTO extends BaseDTO<Rating>{


	private int value;
	private String comment;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private long productId;
	private long userId;

	public RatingDTO(Rating rating){
		super(rating);
	}

	@Override
	protected void convertToDTO(final Rating entity) {
		setComment(entity.getComment());
		setValue(entity.getValue());
		setCreatedAt(entity.getCreatedAt());
		setUpdatedAt(entity.getUpdatedAt());
		setProductId(entity.getProduct().getId());
		setUserId(entity.getUser().getId());
	}
}
