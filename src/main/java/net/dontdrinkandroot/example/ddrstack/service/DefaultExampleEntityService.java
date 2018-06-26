package net.dontdrinkandroot.example.ddrstack.service;

import net.dontdrinkandroot.example.ddrstack.entity.ExampleEntity;
import net.dontdrinkandroot.example.ddrstack.repository.ExampleEntityRepository;
import net.dontdrinkandroot.extensions.springdatajpa.service.JpaRepositoryEntityService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
@Service
public class DefaultExampleEntityService extends JpaRepositoryEntityService<ExampleEntity, Long, ExampleEntityRepository> implements ExampleEntityService
{
    @Inject
    public DefaultExampleEntityService(ExampleEntityRepository repository)
    {
        super(repository);
    }
}
