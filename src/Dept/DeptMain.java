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
			System.out.println("[1] �μ� �Է�  [2] �μ�  ��ü ��ȸ  [3] �μ� �̸����� ��ȸ  [4] �����޴��� ���ư���");
			System.out.print("�޴� >>  ");
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
		System.out.println("���������������������������������� �μ� �̸����� �˻� ����������������������������������");
		System.out.print("�μ� �̸� : ");
		String name = sc.next();
		ArrayList<DeptVO1> list = dao.selectByName(name);
		for (int i = 0; i < list.size(); i++) {
			DeptVO1 vo1 = list.get(i);
			System.out.println(vo1);

		}
	}

	public static void dept_insert(Scanner sc, DeptDAOimpl dao) {
		System.out.println("�������������μ� �߰�����������");
		System.out.print("�μ� ��ȣ: ");
		int department_id = sc.nextInt();
		System.out.print("�μ���: ");
		String department_name = sc.next();
		System.out.print("���� �ڵ�: ");
		int location_location_id = sc.nextInt();
		// �����ֱ�
		DeptVO vo = new DeptVO(department_id, department_name, location_location_id);
		int cnt = dao.insertNewDept(vo);
		if (cnt > 0) {
			System.out.println("�������������μ� �߰� ��������������");
		} else {
			System.out.println("�������������μ� �߰� ���Ц���������");
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