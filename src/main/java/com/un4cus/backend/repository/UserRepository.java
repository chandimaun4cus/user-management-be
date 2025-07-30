package com.un4cus.backend.repository;

import com.un4cus.backend.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query(value = "SELECT * FROM users WHERE email = :email", nativeQuery = true)
    UserEntity findUserByEmail(@Param("email") String email);

    @Query(value = "SELECT * FROM users WHERE user_deleted_status = false", nativeQuery = true)
    List<UserEntity> findUsersNotDeleted();
}
