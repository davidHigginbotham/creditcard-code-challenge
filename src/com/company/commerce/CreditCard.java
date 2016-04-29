package com.company.commerce;

import java.math.BigDecimal;

public interface CreditCard {

    String getCardType();

    BigDecimal getBalance();

    Interest getInterest();

}
