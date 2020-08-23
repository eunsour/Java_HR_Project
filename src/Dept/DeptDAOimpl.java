package Dept;

import java.sql.*;
import java.util.ArrayList;


public class DeptDAOimpl implements DeptDAO {
   // 초기화 블럭
   static {
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   public final static String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
   public final static String id = "scott";
   public final static String pw = "tiger";



   @Override
   public ArrayList<DeptVO1> selectAllDept() {
      Connection conn = null;      
      ArrayList<DeptVO1> list = new ArrayList<DeptVO1>();
      	System.out.println("사원 이름" + "\t\t"+"직종"+"\t\t\t"+"부서이름" );
      try {
         conn = DriverManager.getConnection(url,id,pw);
         String sql = "select e.employee_name, j.job_title, d.department_name from employees e, jobs j, department d where e.jobs_job_id = j.job_id and e.department_department_id = d.department_id \r\n" + 
         		"	order by  job_title";
         PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery();
         while(rs.next()) {
            String employee_name = rs.getString(1);
            String job_title = rs.getString(2);
            String department_name = rs.getString(3);
            
            DeptVO1 vo1 = new DeptVO1(employee_name, job_title, department_name);
            list.add(vo1);
         }
         
      } catch (Exception e) {
         e.printStackTrace();
      }
      return list;
   }

   @Override
   public int insertNewDept(DeptVO Dept) {
      // 새로운 부서 입력
      Connection conn = null;
      int cnt = -1;
      try {
         String sql = "insert into department values(?,?,?)";
         conn = DriverManager.getConnection(url, id, pw);
         PreparedStatement ps = conn.prepareStatement(sql);
         ps.setInt(1, Dept.getDepartment_id());
         ps.setString(2, Dept.getDepartment_name());
         ps.setInt(3, Dept.getLocation_location_id());
         cnt = ps.executeUpdate();
      } catch (Exception e) {
         e.printStackTrace();
      }
      return cnt;
   }

   @Override
   public ArrayList<DeptVO1> selectByName(String name) {
      Connection conn = null;
      ArrayList<DeptVO1> list = new ArrayList<DeptVO1>();
      System.out.println("사원이름"+"\t\t"+"직종명"+"\t\t\t"+"부서명");
      try {
         conn = DriverManager.getConnection(url,id,pw);
         String sql = "select e.employee_name, j.job_title, d.department_name from employees e, jobs j, department d \r\n" + 
               "where e.jobs_job_id = j.job_id and e.department_department_id = d.department_id and d.department_name = ?";
         PreparedStatement ps = conn.prepareStatement(sql);
         ps.setString(1, name);
         ResultSet rs = ps.executeQuery();
         while(rs.next()) {
            String employee_name = rs.getString(1);
            String job_title = rs.getString(2);
            String department_name = rs.getString(3);
            
            DeptVO1 vo1 = new DeptVO1(employee_name, job_title, department_name);
            list.add(vo1);
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
      
      return list;
   }
}