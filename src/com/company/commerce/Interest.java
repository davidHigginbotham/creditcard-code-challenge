package com.company.commerce;

import java.math.BigDecimal;

public interface Interest {

    BigDecimal getRate();

    BigDecimal calculateInterest(BigDecimal amount);

}
