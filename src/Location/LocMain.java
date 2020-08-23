package Location;

import java.util.ArrayList;
import java.util.Scanner;

public class LocMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LocDAOImpl dao = new LocDAOImpl();
		Scanner sc = new Scanner(System.in);

		// 전체 조회
		SearchAllLoc(dao);

		// 도시 이름으로 조회
		SearchCityName(dao, sc);

		// 지역 정보 삽입
		InsertLoc(dao, sc);
	}

	public static void SearchAllLoc(LocDAOImpl dao) {
		
		ArrayList<LocVO> list = dao.selectAll();
		for (LocVO vo : list) {
			System.out.println(vo.AllLoc());
		}
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
	}

	public static void SearchCityName(LocDAOImpl dao, Scanner sc) {
		System.out.print("▶  도시명을 입력해주세요 : ");
		String city_name = sc.next();
		LocVO vo = dao.selectByCity(city_name);
		if (vo == null) {
			System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
			System.out.println("┃\t▶  존재하지 않는 근무지입니다." + "\n" + "┃\t다시 입력해주세요 :)" 
			+ "\n" + "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
			return;
		} else {
			System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
			System.out.println(vo);
			System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		}
		System.out.println("\n" + "▶  지도 확인 [1]" + "\t" + "돌아가기 [2]");
		System.out.print("▶  ");
		int select_num = sc.nextInt();
		if(select_num == 1) {
			System.out.print("\n" + "▶  주소를 입력해주세요 : ");
			Main main = new Main();
		}else if(select_num == 2) {
			return;
		}

	}

	public static void InsertLoc(LocDAOImpl dao, Scanner sc) {
		System.out.println("▼ 근무지 정보를 입력합니다.");
		System.out.print("┏ 지역 번호: ");
		int location_id = sc.nextInt();
		System.out.print("┃ 주소 : ");
		String street_address = sc.next();
		System.out.print("┃ 우편번호 : ");
		String postal_code = sc.next();
		System.out.print("┃ 도시 : ");
		String city = sc.next();
		System.out.print("┃ 국가 코드: ");
		int country_country_id = sc.nextInt();

		LocVO vo1 = new LocVO(location_id, street_address, postal_code, city, country_country_id);

		int cnt = dao.InsertLoc(vo1);
		if (cnt > 0) {
			System.out.println("▶  근무지 정보를 삽입하였습니다." + "\n");
		} else {
			System.out.println("▶  근무지 정보 삽입에 실패하였습니다." + "\n" + "   다시 입력해주세요 :)" + "\n");
		}
	}

}
