package com.tap.vaccine.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="register_table")
public class RegisterEntity {
	
	@Id
	@Column(name="REGISTER_ID")
	private int registerID;
	
	@Column(name="USERNAME")
	private String userName;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="MOBILE_NO")
	private String mobileNo;
	
	@Column(name="GENDER")
	private String gender;
	
	@Column(name="DOB")
	private String dob;
	
	
	@Column(name="LOGIN_ATTEMPTS")
	private int loginAttempts;
	
	
	public RegisterEntity(String userName, String password, String email, String mobileNo, String gender, String dob) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.mobileNo = mobileNo;
		this.gender = gender;
		this.dob = dob;
	}

	public RegisterEntity(int registerID, String userName, String password, String email, String mobileNo, String gender,
			String dob) {
		super();
		this.registerID = registerID;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.mobileNo = mobileNo;
		this.gender = gender;
		this.dob = dob;
	}

	public RegisterEntity() {
		super();

	}


	public int getRegisterID() {
		return registerID;
	}

	public void setRegisterID(int registerID) {
		this.registerID = registerID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public int getLoginAttempts() {
		return loginAttempts;
	}

	public void setLoginAttempts(int loginAttempts) {
		this.loginAttempts = loginAttempts;
	}

	@Override
	public String toString() {
		return "RegisterEntity [registerID=" + registerID + ", userName=" + userName + ", password=" + password
				+ ", email=" + email + ", mobileNo=" + mobileNo + ", gender=" + gender + ", dob=" + dob + "]";
	}
	
	
	
}
