package com.bob.test_my_sql.reposirity;

import com.bob.test_my_sql.entity.Machine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MachineRepository extends JpaRepository<Machine,Integer> {
    public List<Machine> findByMachineIdentityCode(String machineIdentityCode);
    public List<Machine> deleteByMachineIdentityCode(String machineIdentityCode);
}

