package uni.fmi.Solaris.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

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

    public boolean addProduct(final Product product){
        if(products ==null){
            products = new HashSet<>();
        }
        return products.add(product);
    }
}
