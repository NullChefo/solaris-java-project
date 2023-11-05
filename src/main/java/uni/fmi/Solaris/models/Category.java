package uni.fmi.Solaris.models;

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
}
