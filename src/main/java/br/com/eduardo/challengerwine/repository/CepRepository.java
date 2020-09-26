package br.com.eduardo.challengerwine.repository;

import br.com.eduardo.challengerwine.domain.TCep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CepRepository extends JpaRepository<TCep, Long> {
}
