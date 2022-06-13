package wtf.darius.muse.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wtf.darius.muse.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}

