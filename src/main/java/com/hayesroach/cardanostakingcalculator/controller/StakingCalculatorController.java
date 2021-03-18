package com.hayesroach.cardanostakingcalculator.controller;

import com.hayesroach.cardanostakingcalculator.service.InterestCalculatorService;
import com.litesoftwares.coingecko.CoinGeckoApiClient;
import com.litesoftwares.coingecko.constant.Currency;
import com.litesoftwares.coingecko.domain.Coins.CoinFullData;
import com.litesoftwares.coingecko.impl.CoinGeckoApiClientImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class StakingCalculatorController {

    @Autowired
    InterestCalculatorService interestCalculatorService;

    CoinGeckoApiClient client = new CoinGeckoApiClientImpl();


    // based on a 5% interest
    @GetMapping(value = "/calculate/ada")
    public double calculateRewards(@RequestParam double adaAmount, @RequestParam int years, @RequestParam double adaAddedPerYear) {
        return interestCalculatorService.calculateADA(adaAmount, years, adaAddedPerYear);
    }

    // based on current usd value
    @GetMapping(value = "/calculate/usd")
    public String calculateRewardsUSD(@RequestParam double adaAmount,
                                      @RequestParam int years,
                                      @RequestParam double adaAddedPerYear,
                                      @RequestParam(required = false) Double usdFuturePrice) {
        double ada = interestCalculatorService.calculateADA(adaAmount, years, adaAddedPerYear);

        if(usdFuturePrice == null) {
            Map<String, Map<String, Double>> coin = client.getPrice("cardano", Currency.USD);
            double currentUsdValue = coin.get("cardano").get("usd");

            ada = ada * currentUsdValue;
            return "Value of ADA based on today's price: $" + ada;
        } else {
            ada = ada * usdFuturePrice;
            return "Value of ADA based on future price input: $" + ada;
        }
    }

}
