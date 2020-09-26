package br.com.eduardo.challengerwine.repository;

import br.com.eduardo.challengerwine.domain.TCidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<TCidade, Long> {
}
