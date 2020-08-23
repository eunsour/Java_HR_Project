package Employees;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmpDAOImpl implements EmpDAO {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// Oracle Database Connection
	private Connection getConnection() {
		Connection conn = null;
		String URL = "jdbc:oracle:thin:@localhost:1521:xe";
		String ID = "scott";
		String PW = "tiger";
		try {
			conn = DriverManager.getConnection(URL, ID, PW);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
		return conn;
	}

	// Insert Employees Information
	@Override
	public int InsertEmp(EmpVO vo) {
		System.out.println(vo);
		String SQL = "insert into employees values(?, ?, ?, ?, ?, ?, ?, ?)";
		Connection conn = getConnection();
		int cnt = -1;

		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setInt(1, vo.getEmployee_id());
			ps.setString(2, vo.getEmployee_name());
			ps.setString(3, vo.getPhone_number());
			ps.setString(4, vo.getHire_date());
			ps.setString(5, vo.getJob_id());
			ps.setInt(6, vo.getSalary());
			ps.setInt(7, vo.getCommission());
			ps.setInt(8, vo.getDepartment_id());
			cnt = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	// Delete Employees Information by employee_id
	@Override
	public int DeleteEmp(int num) {
		String SQL = "delete from employees where employee_id = ?";
		Connection conn = getConnection();
		int cnt = -1;

		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setInt(1, num);
			cnt = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	// Select All Employees
	@Override
	public ArrayList<EmpVO> selectAll() {
		String SQL = "select * from employees order by employee_id";
		Connection conn = getConnection();
		System.out.println("┏━사원번호" + " ━━━━━━━ " + "사원이름" + " ━━━━━━━━━ " + 
				"연락처" + " ━━━━━━━━━━━━━━━━━━━ " + "입사일" + " ━━━━━━┓");
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
					   
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int employee_id = rs.getInt("employee_id");
				String employee_name = rs.getNString("employee_name");
				String phone_number = rs.getNString("phone_number");
				String hire_date = rs.getNString("hire_date");
				int salary = rs.getInt("salary");
				int commission = rs.getInt("commission");

				EmpVO vo = new EmpVO(employee_id, employee_name, phone_number, hire_date, salary, commission);
				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// Select Employee by Employee_name
	@Override
	public ArrayList<EmpVO> selectByName(String name) {
		String SQL = "select * from employees where employee_name like ? order by employee_id";
		Connection conn = getConnection();
		
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();

		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, '%' + name + '%');
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int employee_id = rs.getInt("employee_id");
				String employee_name = rs.getNString("employee_name");
				String phone_number = rs.getNString("phone_number");
				String hire_date = rs.getNString("hire_date");
				int salary = rs.getInt("salary");
				int commission = rs.getInt("commission");

				EmpVO vo = new EmpVO(employee_id, employee_name, phone_number, hire_date, salary, commission);
				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}