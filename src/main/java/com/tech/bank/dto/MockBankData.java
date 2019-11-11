package com.tech.bank.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.tech.bank.model.User;

public class MockBankData {

	private static HashMap<Bank, List<User>> bankMap = new HashMap<>();

	public static void main(String[] args) {

		for (Bank bank : allBankData()) {
			System.out.println(bank);
		}
	}

	public static Set<Bank> allBankData() {
		Set<Bank> banks = new HashSet<>();
		banks.add(setBankData("SBI", "John", "31"));

		banks.add(setBankData("ICICI", "John", "31"));

		banks.add(setBankData("HDFC", "John", "31"));

		banks.add(setBankData("SBI", "John", "32"));

		banks.add(setBankData("SBI", "John", "33"));

		banks.add(setBankData("SBI", "Admin", "pass"));

		banks.add(setBankData("DBC", "xxxx", "xxxx"));

		banks.add(setBankData("DBC", "xxx", "xxx"));

		banks.add(setBankData("DBC", "xxx", "xxx"));

		return banks;
	}

	private static Bank setBankData(String bankName, String string2, String string3) {
		Bank bank = new Bank();
		bank.setBankName(bankName);
		for (Bank bankkey : bankMap.keySet()) {
			if (bank.equals(bankkey)) {
				bank = bankkey;
			}
		}

		List<User> list = bankMap.get(bank);
		if (list == null) {
			list = new ArrayList<>();
			User user = new User();
			user.setName(string2);
			user.setPassword(string3);
			bank.getUsers().add(user);
			list.add(user);
			bankMap.put(bank, list);
		} else {
			User user = new User();
			user.setName(string2);
			user.setPassword(string3);
			bank.getUsers().add(user);
			list.add(user);
			bankMap.put(bank, list);
		}

		return bank;
	}
}
