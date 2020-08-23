package Dept;

import java.util.ArrayList;


public interface DeptDAO {
     ArrayList<DeptVO1> selectAllDept();
     public int insertNewDept(DeptVO Dept);
     ArrayList<DeptVO1> selectByName(String name);

}