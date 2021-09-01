package com.fintual.investment;

import java.time.LocalDate;
import java.util.HashSet;

import junit.framework.TestCase;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PortfolioUnitTests extends TestCase {

    @Test
    public void testSingleStockPortfolioWithSameDates() {
        // Given
        HashSet stocks = new HashSet();
        stocks.add(new Stock("FIN"));
        Portfolio portfolio = new Portfolio(stocks);

        LocalDate start = LocalDate.of(2021, 8, 1);
        LocalDate end = LocalDate.of(2021, 8, 1);

        // When calling portfolio profit
        double profit = portfolio.getProfit(start, end);

        //Then expected result should be 0
        assertEquals(0d, profit);
    }

    @Test
    public void testSingleStockPortfolioProfitWithDifferentDates() {
        // Given
        LocalDate start = LocalDate.of(2021, 8, 1);
        LocalDate end = LocalDate.of(2021, 8, 11);

        HashSet stocks = new HashSet();
        Stock meliMock = mock(Stock.class);
        when(meliMock.getPrice(start)).thenReturn(8.5);
        when(meliMock.getPrice(end)).thenReturn(13.75);
        stocks.add(meliMock);

        Portfolio portfolio = new Portfolio(stocks);

        // When calling portfolio profit
        double profit = portfolio.getProfit(start, end);

        //Then expected result should be 5.25
        assertEquals(5.25d, profit);
    }

    @Test
    public void testSingleStockPortfolioAnnualizedProfitWithDifferentDates() {
        // Given
        LocalDate start = LocalDate.of(2021, 8, 1);
        LocalDate end = LocalDate.of(2021, 8, 11);

        HashSet stocks = new HashSet();
        Stock meliMock = mock(Stock.class);
        when(meliMock.getPrice(start)).thenReturn(8.5);
        when(meliMock.getPrice(end)).thenReturn(13.75);
        stocks.add(meliMock);

        Portfolio portfolio = new Portfolio(stocks);

        // When calling portfolio profit
        double profit = portfolio.getAnnualizedProfit(start, end);

        //Then expected result should be 5.25
        assertEquals(191.63d, profit);
    }

    @Test
    public void testMultiStockPortfolioProfitWithDifferentDates() {
        // Given
        LocalDate start = LocalDate.of(2021, 8, 1);
        LocalDate end = LocalDate.of(2021, 8, 2);

        HashSet stocks = new HashSet();
        Stock meliMock = mock(Stock.class);
        when(meliMock.getId()).thenReturn("MELI");
        when(meliMock.getPrice(start)).thenReturn(11.09);
        when(meliMock.getPrice(end)).thenReturn(7.20);
        stocks.add(meliMock);

        Stock bkngMock = mock(Stock.class);
        when(bkngMock.getId()).thenReturn("BKNG");
        when(bkngMock.getPrice(start)).thenReturn(27.33);
        when(bkngMock.getPrice(end)).thenReturn(29d);
        stocks.add(bkngMock);
        Portfolio portfolio = new Portfolio(stocks);

        // When calling portfolio profit
        double profit = portfolio.getProfit(start, end);

        //Then expected result should be -2.22
        assertEquals(-2.22d, profit);
    }

    @Test
    public void testMultiStockPortfolioAnnualizedProfitWithDifferentDates() {
        // Given
        LocalDate start = LocalDate.of(2021, 8, 1);
        LocalDate end = LocalDate.of(2021, 8, 2);

        HashSet stocks = new HashSet();
        Stock meliMock = mock(Stock.class);
        when(meliMock.getId()).thenReturn("MELI");
        when(meliMock.getPrice(start)).thenReturn(11.09);
        when(meliMock.getPrice(end)).thenReturn(7.20);
        stocks.add(meliMock);

        Stock bkngMock = mock(Stock.class);
        when(bkngMock.getId()).thenReturn("BKNG");
        when(bkngMock.getPrice(start)).thenReturn(27.33);
        when(bkngMock.getPrice(end)).thenReturn(29d);
        stocks.add(bkngMock);
        Portfolio portfolio = new Portfolio(stocks);

        // When calling portfolio profit
        double profit = portfolio.getAnnualizedProfit(start, end);

        //Then expected result should be -2.22
        assertEquals(-810.3, profit);
    }
}
