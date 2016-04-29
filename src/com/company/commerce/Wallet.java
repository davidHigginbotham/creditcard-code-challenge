package com.company.commerce;

import java.math.BigDecimal;
import java.util.List;

public class Wallet implements CreditCardHolder {

    private List<CreditCard> creditCards;

    public Wallet(List<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

    @Override
    public List<CreditCard> getCreditCards() {
        return creditCards;
    }

    @Override
    public BigDecimal getTotalCreditCardInterest() {
        BigDecimal totalInterest = BigDecimal.ZERO;
        if (getCreditCards() != null) {
            for (CreditCard creditCard : getCreditCards()) {
                totalInterest = totalInterest.add(creditCard.getInterest().calculateInterest(creditCard.getBalance()));
            }
        }
        return totalInterest;
    }
}
