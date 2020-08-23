package Employees;

import java.util.ArrayList;
import java.util.Scanner;

public class EmpMain {

	public static void main(String[] args) {

		EmpDAOImpl dao = new EmpDAOImpl();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println();
			System.out.println("[1] �μ� �Է�  [2] �μ�  ��ü ��ȸ  [3] �μ� �̸����� ��ȸ  [4] �����޴��� ���ư���");
			System.out.print("�޴� >>  ");
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
		System.out.println("�� ��ü ��� �����Դϴ�.");
		System.out.println();
		int emlployee_num = 0;
		ArrayList<EmpVO> list = dao.selectAll();
		for (EmpVO vo1 : list) {
			System.out.println(vo1.Result());
			emlployee_num++;
		}
		System.out.println("�� �� ��� �� : " + emlployee_num + " ��							  ����");
		System.out.println("����������������������������������������������������������������������������������������������������������������������������������������");
		System.out.println();
	}

	public static EmpDAOImpl searchEmp(Scanner sc) {
		System.out.print("�� �˻��� ����� �̸��� �Է����ּ��� : ");
		String name = sc.next();
		EmpDAOImpl dao = new EmpDAOImpl();
		ArrayList<EmpVO> list = dao.selectByName(name);

		if (name.equals(list)) {
			System.out.println("\n" + "\t\t\t��  �߸� �Է��ϼ̽��ϴ�  ��  ");
			System.out.println("\t\t\t   �ٽ� �Է����ּ��� :)" + "\n");
			return searchEmp(sc);
		} else {
			System.out.println("���������ȣ" + " �������������� " + "����̸�" + " ������������������ " + 
					"����ó" + " �������������������������������������� " + "�Ի���" + " ��������������");
			for (EmpVO test : list) {
				System.out.println(test.Result());
			}
		}
		System.out.println("����������������������������������������������������������������������������������������������������������������������������������������"  + "\n");
		return dao;

	}

	public static void DeleteEmp(Scanner sc) {
		EmpDAO idao = new EmpDAOImpl();
		System.out.print("��  ������ ����� ��ȣ�� �Է��ϼ��� : ");
		int num = sc.nextInt();
		int cnt = idao.DeleteEmp(num);

		if (cnt > 0) {
			System.out.println("��  ��� ������ �����Ǿ����ϴ�." + "\n");
		} else {
			System.out.println("��  ���� �����Ͽ����ϴ�." + "\n");
		}
	}

	static void InsertEmp(Scanner sc, EmpDAOImpl dao) {

		System.out.println("�� ������� ������ �Է��մϴ�");
		System.out.print("�� ��� ��ȣ : ");
		int employee_id = sc.nextInt();
		System.out.print("�� �޴��� ��ȣ : ");
		String phone_number = sc.next();
		System.out.print("�� �Ի��� : ");
		String hire_date = sc.next();
		System.out.print("�� ���� ��ȣ : ");
		String job_id = sc.next();
		System.out.print("�� ���� : ");
		int salary = sc.nextInt();
		System.out.print("�� ���ʽ� : ");
		int commission = sc.nextInt();
		System.out.print("�� �μ� ��ȣ : ");
		int department_id = sc.nextInt();
		System.out.print("�� ��� �̸� : ");
		String employee_name = sc.next();

		EmpVO vo = new EmpVO(employee_id, employee_name, phone_number, hire_date, department_id, salary, commission,
				job_id);

		int cnt = dao.InsertEmp(vo);
		if (cnt > 0) {
			System.out.println("��  " + employee_name + " ����� ������ �����Ͽ����ϴ�" + "\n");
		} else {
			System.out.println("��  ���Կ� �����Ͽ����ϴ�");
		}
	}
}