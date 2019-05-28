package com.project.smarty.model.repository;

import com.project.smarty.beans.RoleBean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleBean,Integer> {

    RoleBean findByRole(String role);
}
