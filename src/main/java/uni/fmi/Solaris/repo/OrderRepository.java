package uni.fmi.Solaris.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uni.fmi.Solaris.models.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
