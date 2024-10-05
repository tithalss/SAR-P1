package org.example.repositories;

import org.example.VoluntarioEmpresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoluntarioEmpresaRepository extends JpaRepository<VoluntarioEmpresa, Integer> {
    VoluntarioEmpresa findByEmail(String email);
}
