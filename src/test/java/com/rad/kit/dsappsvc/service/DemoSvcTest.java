package com.rad.kit.dsappsvc.service;

import com.rad.kit.dsappsvc.entity.DemoMessage;
import com.rad.kit.dsappsvc.repository.DemoMessageRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;

public class DemoSvcTest {

    DemoSvc svc;

    @Mock
    DemoMessageRepository demoMessageRepository;

    @BeforeEach
    public void setup() {
        initMocks(this);
        svc =  new DemoSvc(demoMessageRepository);
        List<DemoMessage> list = new ArrayList<>();
        list.add(new DemoMessage(1, "Hello World", new Date(0)));
        when(demoMessageRepository.findAll()).thenReturn(list);
    }

    @Test
    public void testGetAllDemoMessages() {
        List<DemoMessage> list = svc.getAllDemoMessages();
        Assertions.assertEquals(1 ,list.size());
        DemoMessage demoMessage = list.get(0);
        Assertions.assertEquals(1, demoMessage.getId());
        Assertions.assertEquals("Hello World", demoMessage.getMessage());
        Assertions.assertEquals(0, demoMessage.getLastModifiedDate().getTime());
    }
}
