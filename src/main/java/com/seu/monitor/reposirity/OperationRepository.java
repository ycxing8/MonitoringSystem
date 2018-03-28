package com.seu.monitor.reposirity;

import com.seu.monitor.entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OperationRepository extends JpaRepository<Operation,Integer>{
    List<Operation> findByUserName(String userName);
}
