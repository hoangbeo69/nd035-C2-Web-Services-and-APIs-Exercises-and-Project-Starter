package com.udacity.pricing.service;

import com.udacity.pricing.domain.price.Price;
import com.udacity.pricing.domain.price.PriceRepository;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.ThreadLocalRandom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Implements the pricing service to get prices for each vehicle.
 */
@Component
public class PricingService {

  @Autowired PriceRepository priceRepository;

  /**
   * Gets a random price to fill in for a given vehicle ID.
   *
   * @return random price for a vehicle
   */
  private static BigDecimal randomPrice() {
    return new BigDecimal(ThreadLocalRandom.current().nextDouble(1, 5))
        .multiply(new BigDecimal(5000d)).setScale(2, RoundingMode.HALF_UP);
  }

  /**
   * If a valid vehicle ID, gets the price of the vehicle from the stored array.
   *
   * @param vehicleId ID number of the vehicle the price is requested for.
   * @return price of the requested vehicle
   * @throws PriceException vehicleID was not found
   */
  public Price getPrice(Long vehicleId) throws PriceException {
    Price price = priceRepository.findById(vehicleId)
        .orElseThrow(() -> new PriceException("Vehicle ID not found: " + vehicleId));

    return price;
  }

}
