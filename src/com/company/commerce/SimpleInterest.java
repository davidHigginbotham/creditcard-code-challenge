package com.company.commerce;

import java.math.BigDecimal;

public class SimpleInterest implements Interest {

    private BigDecimal rate;

    public SimpleInterest(BigDecimal rate) {
        this.rate = rate;
    }

    @Override
    public BigDecimal getRate() {
        return rate;
    }

    @Override
    public BigDecimal calculateInterest(BigDecimal amount) {
        return amount.multiply(rate);
    }

}
