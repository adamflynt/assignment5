package com.meritamerica.assignment5.models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MeritBank {

	private static AccountHolder[] accountHolders = new AccountHolder[0];
	private static CDOffering[] cdOfferings = new CDOffering[0];
	static long masterAccountNumber = 000000000;

	public static void addAccountHolder(AccountHolder accountHolder) {
		AccountHolder[] newArray = new AccountHolder[accountHolders.length + 1];
		int i = 0;
		for (i = 0; i < accountHolders.length; i++) {
			newArray[i] = accountHolders[i];
		}
		newArray[i] = accountHolder;
		accountHolders = newArray;
	}

	public static AccountHolder[] getAccountHolders() {
		return accountHolders;
	}

	public static CDOffering[] getCDOfferings() {

		return cdOfferings;
	}
	
	public static void addCDOfferings(CDOffering offering) {
		CDOffering[] offerings = Arrays.copyOf(MeritBank.cdOfferings, MeritBank.cdOfferings.length + 1);
		offerings[offerings.length - 1] = offering;
		MeritBank.cdOfferings = offerings;
	}

	public static CDOffering getBestCDOffering(double depositAmount) {
		CDOffering offering = new CDOffering();
		return offering;
	}

	public static CDOffering getSecondBestCDOffering(double depositAmount) {
		CDOffering offering = new CDOffering();

		return offering;
	}

	public static void clearCDOfferings() {

		cdOfferings = new CDOffering[0];

	}

	public static void setCDOfferings(CDOffering[] offerings) {
		cdOfferings = new CDOffering[5];
		cdOfferings[0] = new CDOffering(1, 1.8 / 100);
		cdOfferings[1] = new CDOffering(2, 1.9 / 100);
		cdOfferings[2] = new CDOffering(3, 2.0 / 100);
		cdOfferings[3] = new CDOffering(5, 2.5 / 100);
		cdOfferings[4] = new CDOffering(10, 2.2 / 100);
	}

	static long getNextAccountNumber() {
		return masterAccountNumber++;
	}

	public static double totalBalances() {
		double totalBalance = 0;

		return totalBalance;
	}

	public static AccountHolder[] sortAccountHolders() {

		Arrays.sort(accountHolders);
		return accountHolders;

	}

	public static void setNextAccountNumber(long nextAccountNumber) {
		masterAccountNumber = nextAccountNumber;
	}
	
	public static AccountHolder getAccountHolderById(long id) {
		for (AccountHolder account : accountHolders)  {
			if(account.getId() == id) {
				return account;
			}
		}
		return null;
	}

	// Existing futureValue methods that used to call Math.pow() should now call
	// this method
	public static double recursiveFutureValue(double amount, int years, double interestRate) {
		double total = amount;
		for (int i = years; i > 0; i--) {
			total *= (1 + interestRate);
		}
		return total;
	}

	// Return null if account not found
	public static BankAccount getBankAccount(long accountId) {
		for (int i = 0; i < getAccountHolders().length; i++) {
			for (int j = 0; j < getAccountHolders()[i].getNumberOfCheckingAccounts(); j++) {
				if (getAccountHolders()[i].getCheckingAccounts()[j].getAccountNumber() == accountId) {
					return getAccountHolders()[i].getCheckingAccounts()[j];
				}
			}
			for (int j = 0; j < getAccountHolders()[i].getNumberOfSavingsAccounts(); j++) {
				if (getAccountHolders()[i].getSavingsAccounts()[j].getAccountNumber() == accountId) {
					return getAccountHolders()[i].getSavingsAccounts()[j];
				}
			}
			for (int j = 0; j < getAccountHolders()[i].getNumberOfCDAccounts(); j++) {
				if (getAccountHolders()[i].getCDAccounts()[j].getAccountNumber() == accountId) {
					return getAccountHolders()[i].getCDAccounts()[j];
				}
			}
		}
		return null;
	}
}