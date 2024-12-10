package org.example.repository;

import org.example.model.VoluntarioAssociado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoluntarioAssociadoRepository extends JpaRepository<VoluntarioAssociado, Integer> {
    VoluntarioAssociado findByEmail(String email);
    void deleteByEmail(String email);
}
