package de.htw.berlin.test;

import de.htw.berlin.impl.CardServiceImpl;
import de.htw.berlin.impl.GameServiceImpl;
import de.htw.berlin.impl.PlayerServiceImpl;
import de.htw.berlin.impl.RulesServiceImpl;
import de.htw.berlin.export.CardService;
import de.htw.berlin.export.GameService;
import de.htw.berlin.export.PlayerService;
import de.htw.berlin.export.RulesService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * This is the Spring Configuration that connects the beans.
 */
@ComponentScan(basePackages = {"de.htw.berlin.ai", "-"})
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
    public RulesService specialRulesService(){
        return new SpecialRulesImpl();
    }
    @Bean
    public RulesService normalRulesService(){
        return new NormalRulesImpl();
    }

    @Bean
    public AIService aiService(){
        return new AIServiceImpl();
    }
    @Bean
    public Main controller.Main service(){
        return new UIServiceImpl
    }
}
