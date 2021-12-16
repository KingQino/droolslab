package com.example.droolslab;

import com.example.droolslab.domain.OrderRequest;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import com.google.gson.Gson;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Data
@Log4j2
public class DecisionController {

    @Autowired
    private KieContainer kieContainer;

    private static final Gson GSON = new Gson();


    @PostMapping("/discount")
    private OrderRequest getDiscountPercent(@RequestBody OrderRequest orderRequest) {
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(orderRequest);
        kieSession.fireAllRules();
        kieSession.dispose();

        log.warn(" DRUG DEALER {} ", GSON.toJson(orderRequest));
//        log.info(" 测试LOGGING {} ", GSON.toJson(orderRequest));
        return orderRequest;
    }
}
