package com.bob.test_my_sql.reposirity;

import com.bob.test_my_sql.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
    public List<User> findByUserName(String userName);
    public List<User> deleteByUserName(String userName);
    
}

