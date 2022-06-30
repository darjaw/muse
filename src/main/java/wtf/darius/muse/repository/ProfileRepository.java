package wtf.darius.muse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wtf.darius.muse.model.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {
}
