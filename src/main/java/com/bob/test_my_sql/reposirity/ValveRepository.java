package com.bob.test_my_sql.reposirity;

import com.bob.test_my_sql.entity.Valve;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ValveRepository extends JpaRepository<Valve,Integer>{
    List<Valve>findByCode(String code);
}
