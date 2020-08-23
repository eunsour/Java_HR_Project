package 자바_1차_프로젝트;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// 회원가입 - 직원용로그인 - 관리자용로그인 - 종료
		// 사원 전체조회- 사원 이름으로조회- 이전으로- 종료
		// 사원 - 부서 - 근무이력 - 근무지

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("메뉴를 입력하세요");
			System.out.println("[1]회원가입 [2]직원용 로그인 [3]관리자용 로그인 [4]종료");

			int menu_select = sc.nextInt();

			switch (menu_select) {
			case 1: 
				// 회원가입
				break;
			case 2: 
				// 직원용 로그인
				break;
			case 3:
				// 관리자용 로그인
				break;
			case 4:
				// 종료
				break;
			}
		}
	}
}
