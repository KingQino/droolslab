package com.example.droolslab;

import com.example.droolslab.domain.OrderRequest;
import org.junit.jupiter.api.Test;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
