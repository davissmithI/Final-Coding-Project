package app.helper;

public class Payment {
	
	private double Amount;
	private double Interest;
	
	public Payment(double Interest, double Principal) {
		this.Interest = Interest;
		this.Amount = Interest + Principal;
	}

	public double getAmount() {
		return Amount;
	}

	public double getInterest() {
		return Interest;
	}
	
}