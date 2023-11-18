package uni.fmi.Solaris.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uni.fmi.Solaris.models.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
