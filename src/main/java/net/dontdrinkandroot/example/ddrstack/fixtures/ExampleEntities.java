package net.dontdrinkandroot.example.ddrstack.fixtures;

import com.github.javafaker.Faker;
import net.dontdrinkandroot.example.ddrstack.entity.ExampleEntity;
import net.dontdrinkandroot.fixtures.Fixture;
import net.dontdrinkandroot.fixtures.referencerepository.ReferenceRepository;

import javax.persistence.EntityManager;
import java.time.ZoneId;
import java.util.Random;

public class ExampleEntities implements Fixture
{
    @Override
    public void load(EntityManager entityManager, ReferenceRepository referenceRepository)
    {
        ExampleEntity entity;
        Faker faker = new Faker(new Random(28976423948726384L));

        for (int i = 0; i < 97; i++) {
            entity = new ExampleEntity();
            entity.setStringField(faker.name().fullName());
            entity.setIntegerField(faker.random().nextInt(0, 1000));
            entity.setDateField(faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            entityManager.persist(entity);
        }

        entityManager.flush();
    }
}
