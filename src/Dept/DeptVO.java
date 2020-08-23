package Dept;


public class DeptVO {
   public int department_id;
   public String department_name;
   public int location_location_id;
   public String job_title;
   public String city;
   
   
   
 
   
   public DeptVO() {};
   public DeptVO(String department_name, String job_title, String city) {
      super();
      this.department_name = department_name;
      this.job_title = job_title;
      this.city = city;
   }
   public String getJob_title() {
      return job_title;
   }
   public void setJob_title(String job_title) {
      this.job_title = job_title;
   }
   public String getCity() {
      return city;
   }
   public void setCity(String city) {
      this.city = city;
   }
   public DeptVO(int department_id, String department_name, int location_location_id) {
      super();
      this.department_id = department_id;
      this.department_name = department_name;
      this.location_location_id = location_location_id;
   }
   public int getDepartment_id() {
      return department_id;
   }
   public void setDepartment_id(int department_id) {
      this.department_id = department_id;
   }
   public String getDepartment_name() {
      return department_name;
   }
   public void setDepartment_name(String department_name) {
      this.department_name = department_name;
   }
   public int getLocation_location_id() {
      return location_location_id;
   }
   public void setLocation_location_id(int location_location_id) {
      this.location_location_id = location_location_id;
   }
   
   

	@Override
	public String toString() {
		return "부서번호 :    " + department_id + " 부서이름 :    " + department_name
				+ "근무지번호 :" + location_location_id ;
	}

}
