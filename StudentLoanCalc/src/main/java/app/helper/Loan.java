package app.helper;

import java.util.LinkedList;

public class Loan {
	
	double dLoanAmount;
	double dInterestRate;
	double iTerm;
	double dFutureValue;
	boolean bInterestCalc;
	double dExtraPayment;
	
	private LinkedList<Payment> loanPayments = new LinkedList<Payment>();
	
	public Loan(double dLoanAmount, double dInterestRate, double iTerm, double dExtraPayment) {
		super();
	}
	
}
