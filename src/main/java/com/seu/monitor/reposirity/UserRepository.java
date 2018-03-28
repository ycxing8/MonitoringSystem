package com.seu.monitor.reposirity;

import com.seu.monitor.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
    List<User> findByName(String Name);
    List<User> deleteByName(String Name);
}

