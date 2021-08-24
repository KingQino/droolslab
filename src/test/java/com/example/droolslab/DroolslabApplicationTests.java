package com.example.droolslab;

import com.example.droolslab.domain.OrderRequest;
import org.drools.core.io.impl.UrlResource;
import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.builder.KieModule;
import org.kie.api.builder.KieRepository;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.InputStream;

@SpringBootTest
class DroolslabApplicationTests {

	@Autowired
	KieContainer kieContainer;

	@Test
	void contextLoads() {
		KieSession kieSession = kieContainer.newKieSession();
		OrderRequest orderRequest = OrderRequest.builder()
				.orderId(1231)
				.paymentType("CARD")
				.totalPrice(1000000)
				.build();

		kieSession.insert(orderRequest);
		kieSession.fireAllRules();
		kieSession.dispose();
		System.out.println(orderRequest);
	}

}
