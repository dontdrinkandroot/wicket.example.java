package net.dontdrinkandroot.example.ddrstack.repository;

import net.dontdrinkandroot.example.ddrstack.entity.ExampleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
@Repository
public interface ExampleEntityRepository extends JpaRepository<ExampleEntity, Long>, JpaSpecificationExecutor<ExampleEntity>
{
}
