package wtf.darius.muse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wtf.darius.muse.model.Audio;

public interface AudioRepository extends JpaRepository<Audio, Integer> {
}



