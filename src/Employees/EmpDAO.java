package Employees;


import java.util.ArrayList;

public interface EmpDAO {
	public int InsertEmp(EmpVO vo); 					// Insert Employees Information
	public int DeleteEmp(int num);						// Delete Employees Information
	public ArrayList<EmpVO> selectAll();				// Select All Employees
	public ArrayList<EmpVO> selectByName(String name) ;	// Select Employee by Employee_name
}