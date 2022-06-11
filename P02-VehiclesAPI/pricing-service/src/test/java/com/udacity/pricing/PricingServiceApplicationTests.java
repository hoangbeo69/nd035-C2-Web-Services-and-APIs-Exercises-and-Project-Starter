package com.udacity.pricing;

import com.udacity.pricing.domain.price.Price;
import com.udacity.pricing.domain.price.PriceRepository;
import java.math.BigDecimal;
import java.util.NoSuchElementException;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PricingServiceApplicationTests {

  @Autowired
  PriceRepository priceRepository;

  @Test
  public void testFindPriceByVehicleId() {
    Price originalPrice = new Price("VND", new BigDecimal(14.0), 101L);
    priceRepository.save(originalPrice);
    Price price = priceRepository.findById(originalPrice.getId()).get();
    Assertions.assertThat(price.getPrice()).isEqualTo(new BigDecimal(14.0));
    Assertions.assertThat(price.getCurrency()).isEqualTo("VND");
  }

  @Test(expected = NoSuchElementException.class)
  public void testDelete() {
    Price originalPrice = new Price("VND", new BigDecimal(12.0), 105L);
    priceRepository.save(originalPrice);
    Price price = priceRepository.findById(originalPrice.getId()).get();
    priceRepository.delete(price);
    priceRepository.findById(originalPrice.getId()).get();
  }

}
