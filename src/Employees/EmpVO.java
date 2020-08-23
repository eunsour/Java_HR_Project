package Employees;

public class EmpVO {
	private int employee_id;
	private String employee_name;
	private String phone_number;
	private String hire_date;
	private String department_name;
	private String job_title;
	private int salary;
	private int commission;
	private String job_id;
	private int department_id;
	private String street_address;
	private String city;
	
	// 입력용 생성자
	public EmpVO(int employee_id, String employee_name, String phone_number, String hire_date, int department_id,
			int salary, int commission, String job_id) {
		super();
		this.employee_id = employee_id;
		this.employee_name = employee_name;
		this.phone_number = phone_number;
		this.hire_date = hire_date;
		this.department_id = department_id;
		this.salary = salary;
		this.commission = commission;
		this.job_id = job_id;
	}
	
	// 조회용 생성자
	public EmpVO(int employee_id, String employee_name, String phone_number, String hire_date,
			 int salary, int commission) {
		super();
		this.employee_id = employee_id;
		this.employee_name = employee_name;
		this.phone_number = phone_number;
		this.hire_date = hire_date;
		this.salary = salary;
		this.commission = commission;
	}
	
	// 기본 생성자
	public EmpVO() {
		super();
	}
	
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getHire_date() {
		return hire_date;
	}
	public void setHire_date(String hire_date) {
		this.hire_date = hire_date;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	public String getJob_title() {
		return job_title;
	}
	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getCommission() {
		return commission;
	}
	public void setCommission(int commission) {
		this.commission = commission;
	}
	public String getJob_id() {
		return job_id;
	}
	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}
	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	public String getStreet_address() {
		return street_address;
	}
	public void setStreet_address(String street_address) {
		this.street_address = street_address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Override
	public String toString() {
		return "사원번호 :  " + employee_id + "     사원 이름 :  " + employee_name + "     연락처 :  "
				+ phone_number + "     입사일 :  " + hire_date + "     부서이름 :  " + department_name + "     직종 :  "
				+ job_title + "      직종번호 :  " + job_id
				+ "    부서이름 :  " + department_id;
	}	
	
	public String Result() {
		return  "┃ " + employee_id +"\t\t" + employee_name + "\t\t" + phone_number +
				 "\t\t" + hire_date + "";
	}
}
