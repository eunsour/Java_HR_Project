package Employees;

import java.util.ArrayList;
import java.util.Scanner;

public class EmpMain {

	public static void main(String[] args) {

		EmpDAOImpl dao = new EmpDAOImpl();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println();
			System.out.println("[1] 부서 입력  [2] 부서  전체 조회  [3] 부서 이름으로 조회  [4] 이전메뉴로 돌아가기");
			System.out.print("메뉴 >>  ");
			int menu = sc.nextInt();

			if (menu == 1) {
				InsertEmp(sc, dao);
			} else if (menu == 2) {
				SearchAllEmp(dao);
			} else if (menu == 3) {
				searchEmp(sc);
			} else if (menu == 4) {
				DeleteEmp(sc);
			}
		}
	}

	public static void SearchAllEmp(EmpDAOImpl dao) {
		System.out.println("▼ 전체 사원 정보입니다.");
		System.out.println();
		int emlployee_num = 0;
		ArrayList<EmpVO> list = dao.selectAll();
		for (EmpVO vo1 : list) {
			System.out.println(vo1.Result());
			emlployee_num++;
		}
		System.out.println("┏ 총 사원 수 : " + emlployee_num + " 명							  ━┓");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.println();
	}

	public static EmpDAOImpl searchEmp(Scanner sc) {
		System.out.print("▶ 검색할 사원의 이름을 입력해주세요 : ");
		String name = sc.next();
		EmpDAOImpl dao = new EmpDAOImpl();
		ArrayList<EmpVO> list = dao.selectByName(name);

		if (name.equals(list)) {
			System.out.println("\n" + "\t\t\t▶  잘못 입력하셨습니다  ◀  ");
			System.out.println("\t\t\t   다시 입력해주세요 :)" + "\n");
			return searchEmp(sc);
		} else {
			System.out.println("┏━사원번호" + " ━━━━━━━ " + "사원이름" + " ━━━━━━━━━ " + 
					"연락처" + " ━━━━━━━━━━━━━━━━━━━ " + "입사일" + " ━━━━━━┓");
			for (EmpVO test : list) {
				System.out.println(test.Result());
			}
		}
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛"  + "\n");
		return dao;

	}

	public static void DeleteEmp(Scanner sc) {
		EmpDAO idao = new EmpDAOImpl();
		System.out.print("▶  삭제할 사원의 번호를 입력하세요 : ");
		int num = sc.nextInt();
		int cnt = idao.DeleteEmp(num);

		if (cnt > 0) {
			System.out.println("▶  사원 정보가 삭제되었습니다." + "\n");
		} else {
			System.out.println("▶  삭제 실패하였습니다." + "\n");
		}
	}

	static void InsertEmp(Scanner sc, EmpDAOImpl dao) {

		System.out.println("▼ 사원들의 정보를 입력합니다");
		System.out.print("┏ 사원 번호 : ");
		int employee_id = sc.nextInt();
		System.out.print("┃ 휴대폰 번호 : ");
		String phone_number = sc.next();
		System.out.print("┃ 입사일 : ");
		String hire_date = sc.next();
		System.out.print("┃ 직업 번호 : ");
		String job_id = sc.next();
		System.out.print("┃ 연봉 : ");
		int salary = sc.nextInt();
		System.out.print("┃ 보너스 : ");
		int commission = sc.nextInt();
		System.out.print("┃ 부서 번호 : ");
		int department_id = sc.nextInt();
		System.out.print("┗ 사원 이름 : ");
		String employee_name = sc.next();

		EmpVO vo = new EmpVO(employee_id, employee_name, phone_number, hire_date, department_id, salary, commission,
				job_id);

		int cnt = dao.InsertEmp(vo);
		if (cnt > 0) {
			System.out.println("▶  " + employee_name + " 사원의 정보를 삽입하였습니다" + "\n");
		} else {
			System.out.println("▶  삽입에 실패하였습니다");
		}
	}
}