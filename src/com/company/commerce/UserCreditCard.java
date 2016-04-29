package com.company.commerce;

import java.math.BigDecimal;

public class UserCreditCard implements CreditCard {

    String cardType;
    Interest interest;
    BigDecimal balance;

    public UserCreditCard(String cardType, Interest interest, BigDecimal balance) {
        this.cardType = cardType;
        this.interest = interest;
        this.balance = balance;
    }

    @Override
    public String getCardType() {
        return cardType;
    }

    @Override
    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public Interest getInterest() {
        return interest;
    }

}
