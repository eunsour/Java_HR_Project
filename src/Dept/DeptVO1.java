package Dept;

public class DeptVO1 {
   public String employee_name;
   public String job_title;
   public String department_name;
   public DeptVO1(String employee_name, String job_title, String department_name) {
      super();
      this.employee_name = employee_name;
      this.job_title = job_title;
      this.department_name = department_name;
   }
   public String getEmployee_name() {
      return employee_name;
   }
   public void setEmployee_name(String employee_name) {
      this.employee_name = employee_name;
   }
   public String getJob_title() {
      return job_title;
   }
   public void setJob_title(String job_title) {
      this.job_title = job_title;
   }
   public String getDepartment_name() {
      return department_name;
   }
   public void setDepartment_name(String department_name) {
      this.department_name = department_name;
   }
   @Override
   public String toString() {
      return   employee_name + "\t\t"+ job_title +"\t\t"+ department_name ;
   }
   
   
}