package com.api.task.repo;

import com.api.task.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepo extends JpaRepository<Permission, Integer> {


}
