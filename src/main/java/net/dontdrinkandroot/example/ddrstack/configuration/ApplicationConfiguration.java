package net.dontdrinkandroot.example.ddrstack.configuration;

import net.dontdrinkandroot.example.ddrstack.fixtures.ContextRefreshFixtureLoader;
import net.dontdrinkandroot.example.ddrstack.fixtures.ExampleEntities;
import net.dontdrinkandroot.fixtures.loader.FixtureLoader;
import net.dontdrinkandroot.fixtures.purger.DatabasePurger;
import net.dontdrinkandroot.fixtures.purger.MetamodelDatabasePurger;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
@Configuration
public class ApplicationConfiguration
{
    @Bean
    public DatabasePurger databasePurger()
    {
        return new MetamodelDatabasePurger();
    }

    @Bean
    public FixtureLoader fixtureLoader(DatabasePurger purger, AutowireCapableBeanFactory beanFactory)
    {
        return new ContextRefreshFixtureLoader(purger, beanFactory, Arrays.asList(
                ExampleEntities.class
        ));
    }
}
