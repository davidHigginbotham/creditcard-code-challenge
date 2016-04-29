package com.company.commerce;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Person implements CreditCardHolder {

    private List<CreditCardHolder> wallets;

    public Person(List<CreditCardHolder> wallets) {
        this.wallets = wallets;
    }

    public List<CreditCardHolder> getWallets() {
        return wallets;
    }

    @Override
    public BigDecimal getTotalCreditCardInterest() {
        BigDecimal totalInterest = BigDecimal.ZERO;
        if (wallets != null) {
            for (CreditCardHolder wallet : getWallets()) {
                totalInterest = totalInterest.add(wallet.getTotalCreditCardInterest());
            }
        }
        return totalInterest;
    }

    @Override
    public List<CreditCard> getCreditCards() {
        List<CreditCard> creditCards = new ArrayList<CreditCard>();
        for (CreditCardHolder wallet : getWallets()) {
            creditCards.addAll(wallet.getCreditCards());
        }
        return creditCards;
    }

}
