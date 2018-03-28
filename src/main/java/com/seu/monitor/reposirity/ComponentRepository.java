package com.seu.monitor.reposirity;

import com.seu.monitor.entity.Component;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComponentRepository extends JpaRepository<Component,Integer>{
    List<Component> findByIdentifierAndMachineIdentifier(String identifier, String machineIdentifier);
}
