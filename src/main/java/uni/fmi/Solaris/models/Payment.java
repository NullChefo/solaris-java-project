package uni.fmi.Solaris.models;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "payments")
public class Payment extends MainModel{

	@Column(length = 36, nullable = false, unique = true)
	private String token;

	private boolean successful = false;
	private BigDecimal sum;

	@ManyToOne
	@JoinColumn(name = "ORDER_ID")
	private Order order;
}
