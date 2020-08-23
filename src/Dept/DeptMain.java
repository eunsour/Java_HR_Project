package Dept;

import java.util.ArrayList;
import java.util.Scanner;

import Employees.EmpDAOImpl;
import Employees.EmpMain;

public class DeptMain {
	public static void main(String[] args) {
		dept_menu();
	}

	public static void dept_menu() {
		Scanner sc = new Scanner(System.in);
		DeptDAOimpl dao = new DeptDAOimpl();

		while (true) {
			System.out.println();
			System.out.println("[1] 부서 입력  [2] 부서  전체 조회  [3] 부서 이름으로 조회  [4] 이전메뉴로 돌아가기");
			System.out.print("메뉴 >>  ");
			int menu = sc.nextInt();

			if (menu == 1) {
				dept_insert(sc, dao);
			} else if (menu == 2) {
				dept_all(dao);
			} else if (menu == 3) {
				dept_search(sc, dao);
			} else if (menu == 4) {

			}
		}
	}

	public static void dept_search(Scanner sc, DeptDAOimpl dao) {
		System.out.println();
		System.out.println("───────────────── 부서 이름으로 검색 ─────────────────");
		System.out.print("부서 이름 : ");
		String name = sc.next();
		ArrayList<DeptVO1> list = dao.selectByName(name);
		for (int i = 0; i < list.size(); i++) {
			DeptVO1 vo1 = list.get(i);
			System.out.println(vo1);

		}
	}

	public static void dept_insert(Scanner sc, DeptDAOimpl dao) {
		System.out.println("──────부서 추가─────");
		System.out.print("부서 번호: ");
		int department_id = sc.nextInt();
		System.out.print("부서명: ");
		String department_name = sc.next();
		System.out.print("지역 코드: ");
		int location_location_id = sc.nextInt();
		// 묶어주기
		DeptVO vo = new DeptVO(department_id, department_name, location_location_id);
		int cnt = dao.insertNewDept(vo);
		if (cnt > 0) {
			System.out.println("──────부서 추가 성공─────");
		} else {
			System.out.println("──────부서 추가 실패─────");
		}
	}

	public static void dept_all(DeptDAOimpl dao) {
		ArrayList<DeptVO1> list = dao.selectAllDept();
		for (int i = 0; i < list.size(); i++) {
			DeptVO1 vo1 = list.get(i);
			System.out.println(vo1);
		}
	}
}