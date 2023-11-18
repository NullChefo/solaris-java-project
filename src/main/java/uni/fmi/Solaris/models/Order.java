package uni.fmi.Solaris.models;

import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Orders")
public class Order extends MainModel{
	@Column(nullable = false, unique = true)
	private String number;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User owner;
	@Enumerated
	private OrderStatus orderStatus;

	@OneToMany(mappedBy = "order", fetch = FetchType.EAGER)// name of property; cascade, TODO: orphanRemoval
	private List<OrderProduct> products;



}
