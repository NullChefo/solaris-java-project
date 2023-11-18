package uni.fmi.Solaris.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import uni.fmi.Solaris.models.Cart;

public interface CartRepository  extends JpaRepository<Cart, Long> {
}
