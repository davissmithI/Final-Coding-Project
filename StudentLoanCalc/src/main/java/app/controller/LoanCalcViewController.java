package app.controller;

import app.StudentCalc;
import app.helper.Loan;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;

public class LoanCalcViewController implements Initializable   {

	private StudentCalc SC = null;
	
	@FXML
	private TextField LoanAmount;
	
	@FXML
	private TextField InterestRate;
	
	@FXML
	private TextField NbrOfYears;

	@FXML
	private TextField AdditionalPayment;
	
	@FXML
	private Label lblTotalPayemnts;
	
	@FXML
	private Label lblTotalInterest;
	
	@FXML
	private DatePicker PaymentStartDate;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	public void setMainApp(StudentCalc sc) {
		this.SC = sc;
	}
	
	/**
	 * btnCalcLoan - Fire this event when the button clicks
	 * 
	 * @version 1.0
	 * @param event
	 */
	@FXML
	private void btnCalcLoan(ActionEvent event) {
		double dLoanAmount = Double.parseDouble(LoanAmount.getText());
		double dInterestRate = Double.parseDouble(InterestRate.getText());
		double iTerm = Double.parseDouble(NbrOfYears.getText());
		double dExtraPayment = Double.parseDouble(AdditionalPayment.getText());
		
		Loan iLoan = new Loan(dLoanAmount, dInterestRate, iTerm, dExtraPayment);
		iLoan.calcLoan();
		
		lblTotalPayemnts.setText(Double.toString(iLoan.calcTotalPayments()));
		
		lblTotalInterest.setText(Double.toString(iLoan.calcTotalInterest()));
	}
}