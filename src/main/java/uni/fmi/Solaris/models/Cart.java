package uni.fmi.Solaris.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "carts")
public class Cart extends MainModel{

	@OneToOne(optional = false) // no cart without user
	@JoinColumn(name = "USER_ID")
	private User user;

	@OneToMany
	@JoinColumn(name = "CART_ID")
	private List<CartProduct> cartProductList;
}
