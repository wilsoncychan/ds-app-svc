package com.rad.kit.dsappsvc.controller;

import com.rad.kit.dsappsvc.dto.DemoMessageDto;
import com.rad.kit.dsappsvc.entity.DemoMessage;
import com.rad.kit.dsappsvc.service.DemoSvc;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class DemoControllerTest {

    DemoController controller;

    @Mock
    DemoSvc demoSvc;

    @BeforeEach
    public void setup() {
        initMocks(this);
        controller =  new DemoController(demoSvc, new ModelMapper());
        List<DemoMessage> list = new ArrayList<>();
        list.add(new DemoMessage(1, "Hello World", new Date(0)));
        when(demoSvc.getAllDemoMessages()).thenReturn(list);
    }

    @Test
    public void testGetAllDemoMessages(){
        List<DemoMessageDto> list = controller.getAllDemoMessages();
        Assertions.assertEquals(1 ,list.size());
        DemoMessageDto demoMessageDto = list.get(0);
        Assertions.assertEquals(1, demoMessageDto.getId());
        Assertions.assertEquals("Hello World", demoMessageDto.getMessage());
        Assertions.assertEquals(0, demoMessageDto.getLastModifiedDate().getTime());
    }
}
