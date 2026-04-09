package com.devsuperior.demo.repositories;

import com.devsuperior.demo.dto.UserDTO;
import com.devsuperior.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(nativeQuery = true, value = "SELECT to user.email AS username, tb user password, tb role.id AS roleld, tb role authority " +
            "FROM tb user " +
            "INNER JOIN to user role ON tb_user.id = tb user role user id " +
            "INNER JOIN to role ON tb_role.id = tb user role.role id " +
            "WHERE to user.email = :username")
    List<UserDTO> searchUserAndRolesByEmail(String username);
}
