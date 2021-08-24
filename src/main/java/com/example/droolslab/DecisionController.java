package com.example.droolslab;

import com.example.droolslab.domain.OrderRequest;
import lombok.Data;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Data

public class DecisionController {

    @Autowired
    private KieContainer kieContainer;

    @PostMapping("/discount")
    private OrderRequest getDiscountPercent(@RequestBody OrderRequest orderRequest) {
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(orderRequest);
        kieSession.fireAllRules();
        kieSession.dispose();
        return orderRequest;
    }
}
