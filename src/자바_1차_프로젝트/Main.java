package �ڹ�_1��_������Ʈ;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// ȸ������ - ������α��� - �����ڿ�α��� - ����
		// ��� ��ü��ȸ- ��� �̸�������ȸ- ��������- ����
		// ��� - �μ� - �ٹ��̷� - �ٹ���

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("�޴��� �Է��ϼ���");
			System.out.println("[1]ȸ������ [2]������ �α��� [3]�����ڿ� �α��� [4]����");

			int menu_select = sc.nextInt();

			switch (menu_select) {
			case 1: 
				// ȸ������
				break;
			case 2: 
				// ������ �α���
				break;
			case 3:
				// �����ڿ� �α���
				break;
			case 4:
				// ����
				break;
			}
		}
	}
}
