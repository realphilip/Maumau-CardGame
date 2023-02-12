import de.htw.berlin.domain.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * Works with Spring Data
 */
@Repository
public interface GameRepository extends CrudRepository<Game, Long> {

}
