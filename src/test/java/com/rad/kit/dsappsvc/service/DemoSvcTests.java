package com.rad.kit.dsappsvc.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class DemoSvcTests {

    DemoSvc svc;

    @BeforeEach
    public void setup() {
        this.svc =  new DemoSvc();
    }

    @Test
    public void TestProtectedServiceOne() {
        Assert.isTrue(svc.protectedServiceOne(), "Service returns true");
    }
}
