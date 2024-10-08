package com.example.Tech4Good.REPOSITORIOS;

import com.example.Tech4Good.MODELOS.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {
    User findByuserName(String userName);
}
