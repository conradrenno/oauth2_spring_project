package com.devrenno.resourceserver.repositories;

import com.devrenno.resourceserver.dto.UserDetailsProjection;
import com.devrenno.resourceserver.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(nativeQuery = true, value = """
            
            SELECT u.email AS username, u.password, a.id AS authority_id, a.name AS authority 
            FROM tb_user u 
            INNER JOIN tb_user_authority ua ON ua.user_id = u.id
            INNER JOIN tb_authority a ON a.id = ua.authority_id
            WHERE u.email = :email
            
            """)
    List<UserDetailsProjection> searchUserAndAuthoritiesByEmail(String email);

    Optional<User> findByEmail(String email);
}
