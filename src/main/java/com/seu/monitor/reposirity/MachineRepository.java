package com.seu.monitor.reposirity;

import com.seu.monitor.entity.Machine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MachineRepository extends JpaRepository<Machine,Integer> {
    public List<Machine> findByIdentifier(String identifier);
    public List<Machine> findByIdentityCode(String identityCode);
}

