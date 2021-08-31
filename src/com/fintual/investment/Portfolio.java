package com.fintual.investment;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static java.time.temporal.ChronoUnit.DAYS;

public class Portfolio {
    private static final int DAYS_IN_YEAR = 365;
    private Map<String, Stock> stocks;

    public Portfolio(Set<Stock> stocks) {
        this.stocks = new HashMap<>();
        stocks.forEach(stock -> {
                this.stocks.put(stock.getId(), stock);
        } );
    }

    /**
     * Returns the portfolio's profit between two dates
     * @param first one of the dates of the period
     * @param second the other date of the period
     * @return the portfolio's profit for the given period
     */
    public double getProfit(LocalDate first, LocalDate second) {
        if(first.equals(second)) {
            return 0;
        }

        LocalDate start= first;
        LocalDate end = second;
        if (start.isAfter(second)) {
            start = second;
            end = first;
        }

        double profit = 0;

        for(Stock stock : stocks.values()) {
            double startPrice = stock.getPrice(start);
            double endPrice = stock.getPrice(end);

            profit += endPrice - startPrice;
        }

        return profit;
    }

    /**
     * Returns the portfolio's annualized profit calculated between two dates
     * and considering a 365-day year
     * @param first one of the dates of the period
     * @param second the other date of the period
     * @return the portfolio's annualized profit for the given period
     */
    public double getAnnualizedProfit(LocalDate first, LocalDate second) {
        if(first.equals(second)) {
            return 0;
        }

        return getProfit(first, second) * DAYS_IN_YEAR / Math.abs(DAYS.between(first, second));
    }
}
