package br.mg.jcls.auth.repository;

import br.mg.jcls.auth.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {

    public Optional<Permission> findByDescription(String description);

}
