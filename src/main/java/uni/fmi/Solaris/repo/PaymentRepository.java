package uni.fmi.Solaris.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uni.fmi.Solaris.models.Payment;
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
