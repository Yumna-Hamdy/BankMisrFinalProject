package com.example.finalProject.Repositories;

import com.example.finalProject.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
   User findByUserName(String email);


    Optional<User> findByEmail(String email);
}
