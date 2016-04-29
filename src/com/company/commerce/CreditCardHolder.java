package com.company.commerce;

import java.math.BigDecimal;
import java.util.List;

public interface CreditCardHolder {

    List<CreditCard> getCreditCards();

    BigDecimal getTotalCreditCardInterest();

}
