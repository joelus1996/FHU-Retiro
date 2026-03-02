package pe.com.intralot.loto.layer.model.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name = "PRIZE_PAYMENT_GET_SAVINGS_ACCOUNT",
		query = "{ call LOTOCARD.PRIZE_PAYMENT.GET_SAVINGS_ACCOUNT(?,?) }",
		callable = true,
		resultClass = PaymentPrizeProcedureGetSavingsAccount.class
		)
public class PaymentPrizeProcedureGetSavingsAccount {
	
	@Id
	@Column(name="o_id")	
	private String id;
	
	@Column(name="o_bank")	
	private String bank;
	
	@Column(name="o_account_number")	
	private String accountNumber;

	@Column(name="o_department")	
	private String department;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
}