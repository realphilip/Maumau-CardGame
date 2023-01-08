import de.htw.berlin.impl.CardServiceImpl;
import de.htw.berlin.impl.GameServiceImpl;
import de.htw.berlin.impl.PlayerServiceImpl;
import de.htw.berlin.impl.RulesServiceImpl;
import de.htw.berlin.export.CardService;
import de.htw.berlin.export.GameService;
import de.htw.berlin.export.PlayerService;
import de.htw.berlin.export.RulesService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {

    @Bean
    public CardService cardService(){
        return new CardServiceImpl();
    }
    @Bean
    public GameService gameService(){
        return new GameServiceImpl();
    }
    @Bean
    public PlayerService playerService(){
        return new PlayerServiceImpl();
    }

    @Bean
    public RulesService rulesService(){
        return new RulesServiceImpl();
    }
}
