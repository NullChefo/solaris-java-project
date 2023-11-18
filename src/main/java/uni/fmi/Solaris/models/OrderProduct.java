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
@Table(name = "ORDER_PRODUCTS")
public class OrderProduct extends MainModel{
	@ManyToOne
	@JoinColumn(name = "ORDER_ID")
	private Order order;

	@ManyToOne
	@JoinColumn(name = "PRODUCT_ID")
	private Product product;

	@Column(nullable = false)
	private int quantity;

	@Column(nullable = false, name = "PRICE_NOT_VAT")
	private BigDecimal priceNotVat;

	@Column(nullable = false)
	private	int vat;



}
