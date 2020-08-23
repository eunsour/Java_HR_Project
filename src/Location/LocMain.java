package Location;

import java.util.ArrayList;
import java.util.Scanner;

public class LocMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LocDAOImpl dao = new LocDAOImpl();
		Scanner sc = new Scanner(System.in);

		// ��ü ��ȸ
		SearchAllLoc(dao);

		// ���� �̸����� ��ȸ
		SearchCityName(dao, sc);

		// ���� ���� ����
		InsertLoc(dao, sc);
	}

	public static void SearchAllLoc(LocDAOImpl dao) {
		
		ArrayList<LocVO> list = dao.selectAll();
		for (LocVO vo : list) {
			System.out.println(vo.AllLoc());
		}
		System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");
	}

	public static void SearchCityName(LocDAOImpl dao, Scanner sc) {
		System.out.print("��  ���ø��� �Է����ּ��� : ");
		String city_name = sc.next();
		LocVO vo = dao.selectByCity(city_name);
		if (vo == null) {
			System.out.println("��������������������������������������������������������������������");
			System.out.println("��\t��  �������� �ʴ� �ٹ����Դϴ�." + "\n" + "��\t�ٽ� �Է����ּ��� :)" 
			+ "\n" + "��������������������������������������������������������������������");
			return;
		} else {
			System.out.println("����������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");
			System.out.println(vo);
			System.out.println("����������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");
		}
		System.out.println("\n" + "��  ���� Ȯ�� [1]" + "\t" + "���ư��� [2]");
		System.out.print("��  ");
		int select_num = sc.nextInt();
		if(select_num == 1) {
			System.out.print("\n" + "��  �ּҸ� �Է����ּ��� : ");
			Main main = new Main();
		}else if(select_num == 2) {
			return;
		}

	}

	public static void InsertLoc(LocDAOImpl dao, Scanner sc) {
		System.out.println("�� �ٹ��� ������ �Է��մϴ�.");
		System.out.print("�� ���� ��ȣ: ");
		int location_id = sc.nextInt();
		System.out.print("�� �ּ� : ");
		String street_address = sc.next();
		System.out.print("�� �����ȣ : ");
		String postal_code = sc.next();
		System.out.print("�� ���� : ");
		String city = sc.next();
		System.out.print("�� ���� �ڵ�: ");
		int country_country_id = sc.nextInt();

		LocVO vo1 = new LocVO(location_id, street_address, postal_code, city, country_country_id);

		int cnt = dao.InsertLoc(vo1);
		if (cnt > 0) {
			System.out.println("��  �ٹ��� ������ �����Ͽ����ϴ�." + "\n");
		} else {
			System.out.println("��  �ٹ��� ���� ���Կ� �����Ͽ����ϴ�." + "\n" + "   �ٽ� �Է����ּ��� :)" + "\n");
		}
	}

}
