package com.rad.kit.dsappsvc.controller;

import com.rad.kit.dsappsvc.dto.DemoMessageDto;
import com.rad.kit.dsappsvc.entity.DemoMessage;
import com.rad.kit.dsappsvc.service.DemoSvc;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class DemoController {

    private static final Logger LOG = LoggerFactory.getLogger(DemoController.class);

    private final DemoSvc demoSvc;

    private final ModelMapper modelMapper;

    @Autowired
    public DemoController(DemoSvc demoSvc, ModelMapper modelMapper) {
        this.demoSvc = demoSvc;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/get-all-demo-messages")
    @ResponseBody
    public List<DemoMessageDto> getAllDemoMessages() {
        List<DemoMessage> demoMessages = demoSvc.getAllDemoMessages();
        return demoMessages.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private DemoMessageDto convertToDto(DemoMessage demoMessage) {
        return modelMapper.map(demoMessage, DemoMessageDto.class);
    }
}
