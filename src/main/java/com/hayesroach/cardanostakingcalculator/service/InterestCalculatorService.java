package com.hayesroach.cardanostakingcalculator.service;

import org.springframework.stereotype.Service;

@Service
public class InterestCalculatorService {

    public double calculateADA(double adaAmount, int years, double adaAddedPerYear) {

        if (adaAmount <= 0.0) {
            return 0.0;
        }

        if (years <= 0) {
            return adaAmount;
        }

        double interest;

        for (int i = 0; i < years; i++) {
            adaAmount += adaAddedPerYear;
            interest = adaAmount * 0.05;
            adaAmount += interest;
            System.out.println("YEAR " + (i + 1) + ": " + adaAmount);
        }

        return adaAmount;
    }

    public double calculateUSD(double adaAmount, int years, double adaAddedPerYear) {

        if (adaAmount <= 0.0) {
            return 0.0;
        }

        if (years <= 0) {
            return adaAmount;
        }

        double interest;

        for (int i = 0; i < years; i++) {
            adaAmount += adaAddedPerYear;
            interest = adaAmount * 0.05;
            adaAmount += interest;
            System.out.println("YEAR " + (i + 1) + ": " + adaAmount);
        }

        return adaAmount;
    }
}
