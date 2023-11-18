package uni.fmi.Solaris.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Product_Category")
public class Category extends MainModel {
    @Column(nullable = false, unique = true)
    private String name;
    @Column(name = "vat_percent", nullable = false)
    private int vatPercent;
    @Transient
    private String temp;

	@OneToMany(mappedBy = "category")
	private Set<Product> products;

	@ManyToOne(optional = true) // can exist without parent
	@JoinColumn(name = "parent_id")
	private Category parent;

	@OneToMany(mappedBy = "parent", fetch = FetchType.EAGER) // load them all
	private List<Category> children;


	public boolean addProduct(Product product) {
		if (products == null) {
			products = new HashSet<>();
		}
		return products.add(product);
	}
}
