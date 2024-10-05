package org.example.repository;

import org.example.model.VoluntarioEmpresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoluntarioEmpresaRepository extends JpaRepository<VoluntarioEmpresa, Integer> {
    VoluntarioEmpresa findByEmail(String email);
}
