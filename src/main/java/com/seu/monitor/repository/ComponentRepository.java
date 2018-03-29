package com.seu.monitor.repository;

import com.seu.monitor.entity.Component;
import com.seu.monitor.entity.composite.ComponentCompositeKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComponentRepository extends JpaRepository<Component,ComponentCompositeKey>{
    /*List<Component> findByIdentifier(String identifier);

    List<Component> findByMachineIdentifierAndIdentifier(String machineIdentifier,
                                                            String identifier);*/
    List<Component> findByPkIdentifier(String identifier);

    List<Component> findByPkMachineIdentifierAndPkIdentifier(String machineIdentifier,
                                                             String identifier);

}
