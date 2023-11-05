package uni.fmi.Solaris.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uni.fmi.Solaris.models.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
}
