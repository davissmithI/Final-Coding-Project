package app.helper;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;

import org.apache.poi.ss.formula.functions.FinanceLib;

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
		this.dLoanAmount = dLoanAmount;
		this.dInterestRate = dInterestRate / 12;
		this.iTerm = iTerm;
		this.dExtraPayment = dExtraPayment;
		this.bInterestCalc = false;
	}
	
	public LinkedList<Payment> getLoanPayments() {
		return loanPayments;
	}
	
	public void calcLoan() {
		double Payment = Math.abs(FinanceLib.pmt(this.dInterestRate, this.iTerm * 12, this.dLoanAmount, 0, this.bInterestCalc));
		double interestPayment;
		double principalPayment;
		double balance = this.dLoanAmount;
		double totalPayment;
		
		while (balance > 0) {
			totalPayment = Payment + this.dExtraPayment;
			interestPayment = round(this.dInterestRate * balance, 2);
			principalPayment = totalPayment - interestPayment;
			balance -= principalPayment;
			Payment payment = new Payment(round(interestPayment, 2), round(principalPayment, 2));
			loanPayments.add(payment);
			}
		}
	
	public double calcTotalPayments() {
		double totalPayment = 0;
		for (Payment payment : this.loanPayments) {
			totalPayment += payment.getAmount();
			}
		return round(totalPayment, 2);
	}
	
	public double calcTotalInterest() {
		double totalInterest = 0;
		for (Payment payment : this.loanPayments) {
			totalInterest += payment.getInterest();
			}
		return round(totalInterest, 2);
	}
	
	public static double round(double value, int decimal) {
		BigDecimal bdValue = new BigDecimal(value);
		bdValue = bdValue.setScale(decimal, RoundingMode.HALF_DOWN);
		return bdValue.doubleValue();
	}
	
}