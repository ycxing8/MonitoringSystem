package com.seu.monitor.reposirity;

import com.seu.monitor.entity.ComponentLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComponentLogRepository extends JpaRepository<ComponentLog,Integer>{
    List<ComponentLog> findByComponentIdentifierAndAndMachineIdentifier(
            String componentIdentifier, String machineIdentifier);

}
