import de.htw.berlin.configuration.CardServiceImpl;
import de.htw.berlin.configuration.GameServiceImpl;
import de.htw.berlin.configuration.PlayerServiceImpl;
import de.htw.berlin.configuration.RulesServiceImpl;
import de.htw.berlin.export.CardService;
import de.htw.berlin.export.GameService;
import de.htw.berlin.export.PlayerService;
import de.htw.berlin.export.RulesService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
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
