package com.rad.kit.dsappsvc.service;

import com.rad.kit.dsappsvc.entity.DemoMessage;
import com.rad.kit.dsappsvc.repository.DemoMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DemoSvc {

    private DemoMessageRepository demoMessageRepository;

    @Autowired
    public DemoSvc(DemoMessageRepository demoMessageRepository) {
        this.demoMessageRepository = demoMessageRepository;
    }

    public List<DemoMessage> getAllDemoMessages() {
        return demoMessageRepository.findAll();
    }
}
