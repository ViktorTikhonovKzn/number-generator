package ru.inovus.number.generator.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.inovus.number.generator.model.Number;

public interface NumberRepository extends CrudRepository<Number, Long> {

    @Query(
            value = "SELECT * FROM Number n WHERE n.issued = false ORDER BY RANDOM() LIMIT 1",
            nativeQuery = true)
    Number findRandom();

    @Modifying
    @Transactional
    @Query("UPDATE Number n SET n.issued = true WHERE n.id = :id")
    void issueNumber(@Param("id") Long id);

    @Query("SELECT n FROM Number n WHERE n.numOrder = (SELECT MIN(n2.numOrder) FROM Number n2 WHERE n2.issued=false and n2.numOrder > :currentOrder)")
    Number findNext(@Param("currentOrder") Integer current);

    @Query("SELECT n FROM Number n WHERE n.numOrder = (SELECT MIN(n2.numOrder) FROM Number n2 WHERE n2.issued=false)")
    Number findFirst();
}
