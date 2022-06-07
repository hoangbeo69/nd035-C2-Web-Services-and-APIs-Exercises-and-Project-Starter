package com.udacity.pricing;

import com.udacity.pricing.service.PriceException;
import com.udacity.pricing.service.PricingService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PricingServiceApplicationTests {

	private static PricingService pricingService;
	@Test
	public void contextLoads() throws PriceException {
		Assert.assertNotNull(PricingService.getPrice(1L));
		Assert.assertNotNull(PricingService.getPrice(3L));
		Assert.assertNotNull(PricingService.getPrice(4L));
		Assert.assertNotNull(PricingService.getPrice(2L));
		Assert.assertNotNull(PricingService.getPrice(5L));
	}

}
