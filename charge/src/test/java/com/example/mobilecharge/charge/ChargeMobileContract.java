package com.example.mobilecharge.charge;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.mobilecharge.charge.MobileModel.Mobile;
import com.example.mobilecharge.charge.Repository.MobileRepoditory;
import com.google.common.base.Optional;
import com.ibm.icu.util.StringTrieBuilder.Option;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.provider.junitsupport.loader.PactFolder;
import au.com.dius.pact.model.RequestResponsePact;
import au.com.dius.pact.provider.PactVerification;
import au.com.dius.pact.provider.junit5.HttpsTestTarget;
import au.com.dius.pact.provider.junit5.PactVerificationContext;
import au.com.dius.pact.provider.junit5.PactVerificationInvocationContextProvider;
import au.com.dius.pact.provider.junitsupport.Consumer;
import au.com.dius.pact.provider.junitsupport.Provider;
import au.com.dius.pact.provider.junitsupport.State;
import io.netty.handler.codec.http.HttpRequest;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Public;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
	properties = {"server.port=9081"} )
@Tag("Contract")
@PactFolder("pacts")
@Provider("Charge")
@Consumer("Mobile")
class ChargeMobileContract {
	
	@MockBean
	private MobileRepoditory mobRepo;
	
	@BeforeEach
	public void setUpTargrt(PactVerificationContext context) {
		context.setTarget(new HttpsTestTarget("localhaost",9081,"/"));
	}
	
	@TestTemplate
	@ExtendWith(PactVerificationInvocationContextProvider.class)
	void pactVerificationTemplate(PactVerificationContext context, HttpRequest request) {
		context.verifyInteraction();	
	}
	@State("testProvider")
	public void findBrandById() {
		Mobile mobile= setMobile();
		Optional<Mobile> optMobile= Optional.of(mobile);
		Mockito.when(mobRepo.findAllById(Mockito.any())).thenReturn((Iterable<Mobile>) Optional.of(optMobile) );
	}
	
	public Mobile setMobile() {
		Mobile mobile= new Mobile();
		mobile.setBrand("apple");
		mobile.setChargeId(1);
		return mobile;
	}
}

