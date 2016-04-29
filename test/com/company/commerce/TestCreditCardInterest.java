package com.company.commerce;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestCreditCardInterest {

    Interest visaInterest;
    Interest masterCardInterest;
    Interest discoverInterest;

    CreditCard visaCreditCard;
    CreditCard masterCardCreditCard;
    CreditCard discoverCreditCard;

    @Before
    public void setUp() throws Exception {
        visaInterest = new SimpleInterest(new BigDecimal(".10"));
        masterCardInterest = new SimpleInterest(new BigDecimal(".05"));
        discoverInterest = new SimpleInterest(new BigDecimal(".01"));

        visaCreditCard = new UserCreditCard("Visa", visaInterest, new BigDecimal("100.00"));
        masterCardCreditCard = new UserCreditCard("MasterCard", masterCardInterest, new BigDecimal("100.00"));
        discoverCreditCard = new UserCreditCard("Discover", discoverInterest, new BigDecimal("100.00"));
    }

    @Test
    public void Test1Person1Wallet3DifferentCreditCards() {
        List<CreditCard> creditCards = new ArrayList<CreditCard>();
        creditCards.add(visaCreditCard);
        creditCards.add(masterCardCreditCard);
        creditCards.add(discoverCreditCard);

        CreditCardHolder wallet = new Wallet(creditCards);
        List<CreditCardHolder> wallets = new ArrayList<CreditCardHolder>();
        wallets.add(wallet);

        Person person = new Person(wallets);

        assertEquals(person.getTotalCreditCardInterest(), new BigDecimal("16.0000"));
        assertEquals(person.getWallets().get(0).getTotalCreditCardInterest(), new BigDecimal("16.0000"));
        assertEquals(person.getWallets().get(0).getCreditCards().get(0).getInterest().calculateInterest(visaCreditCard.getBalance()), new BigDecimal("10.0000"));
        assertEquals(person.getWallets().get(0).getCreditCards().get(1).getInterest().calculateInterest(masterCardCreditCard.getBalance()), new BigDecimal("5.0000"));
        assertEquals(person.getWallets().get(0).getCreditCards().get(2).getInterest().calculateInterest(discoverCreditCard.getBalance()), new BigDecimal("1.0000"));
    }

    @Test
    public void Test1Person2WalletsWithVariousCreditCards() {
        List<CreditCard> firstWalletCreditCards = new ArrayList<CreditCard>();
        firstWalletCreditCards.add(visaCreditCard);
        firstWalletCreditCards.add(discoverCreditCard);

        CreditCardHolder firstWallet = new Wallet(firstWalletCreditCards);

        List<CreditCard> secondWalletCreditCards = new ArrayList<CreditCard>();
        secondWalletCreditCards.add(masterCardCreditCard);

        CreditCardHolder secondWallet = new Wallet(secondWalletCreditCards);

        List<CreditCardHolder> wallets = new ArrayList<CreditCardHolder>();
        wallets.add(firstWallet);
        wallets.add(secondWallet);

        Person person = new Person(wallets);

        assertEquals(person.getTotalCreditCardInterest(), new BigDecimal("16.0000"));
        assertEquals(person.getWallets().get(0).getTotalCreditCardInterest(), new BigDecimal("11.0000"));
        assertEquals(person.getWallets().get(1).getTotalCreditCardInterest(), new BigDecimal("5.0000"));

    }

    @Test
    public void Test2PeopleWith1WalletEachButWithVariousCreditCards() {

        List<CreditCard> firstPersonWalletCreditCards = new ArrayList<CreditCard>();
        firstPersonWalletCreditCards.add(visaCreditCard);
        firstPersonWalletCreditCards.add(masterCardCreditCard);

        CreditCardHolder firstPersonWallet = new Wallet(firstPersonWalletCreditCards);

        List<CreditCardHolder> firstPersonWallets = new ArrayList<CreditCardHolder>();
        firstPersonWallets.add(firstPersonWallet);

        List<CreditCard> secondPersonWalletCreditCards = new ArrayList<CreditCard>();

        CreditCard secondPersonVisaCreditCard = new UserCreditCard("Visa", visaInterest, new BigDecimal("100.00"));
        CreditCard secondPersonMasterCardCreditCard = new UserCreditCard("MasterCard", masterCardInterest, new BigDecimal("100.00"));
        secondPersonWalletCreditCards.add(secondPersonVisaCreditCard);
        secondPersonWalletCreditCards.add(secondPersonMasterCardCreditCard);

        CreditCardHolder secondPersonWallet = new Wallet(secondPersonWalletCreditCards);

        List<CreditCardHolder> secondPersonWallets = new ArrayList<CreditCardHolder>();
        secondPersonWallets.add(secondPersonWallet);

        Person firstPerson = new Person(firstPersonWallets);
        Person secondPerson = new Person(secondPersonWallets);

        assertEquals(firstPerson.getTotalCreditCardInterest(), new BigDecimal("15.0000"));
        assertEquals(secondPerson.getTotalCreditCardInterest(), new BigDecimal("15.0000"));
        assertEquals(firstPerson.getWallets().get(0).getTotalCreditCardInterest(), new BigDecimal("15.0000"));
        assertEquals(secondPerson.getWallets().get(0).getTotalCreditCardInterest(), new BigDecimal("15.0000"));

    }

}
