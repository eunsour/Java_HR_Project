package Location;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LocDAOImpl implements LocDAO {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Oracle Database Connection
	private Connection getConnection() {
		Connection conn = null;
		String URL = "jdbc:oracle:thin:@localhost:1521:xe";
		String ID = "scott";
		String PW = "tiger";
		try {
			conn = DriverManager.getConnection(URL, ID, PW);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
		return conn;
	}

	// Insert Location Information
	@Override
	public int InsertLoc(LocVO vo) {
		System.out.println(vo.InsertResult());
		String SQL = "insert into location values(?, ?, ?, ?, ?)";
		Connection conn = getConnection();
		int cnt = -1;

		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setInt(1, vo.getLocation_id());
			ps.setString(2, vo.getStreet_address());
			ps.setString(3, vo.getPostal_code());
			ps.setString(4, vo.getCity());
			ps.setInt(5, vo.getCountry_country_id());
			cnt = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	// Select All Location
	@Override
	public ArrayList<LocVO> selectAll() {
		String SQL = "select * from location l, country c where l.country_country_id = c.country_id order by location_id";
		Connection conn = getConnection();
		System.out.println("▼ 전체 근무지 정보입니다.");
		System.out.println("┏━지역번호 ━━━━━━━━ 주        소 ━━━━━━━━━━━━━━━ 우편번호 ━━━━ 도시 ━━━━━━"
				+ " 국가코드 ━━━━ 국가명 ━━━━━━━━━━━━━━━┓");
		ArrayList<LocVO> list = new ArrayList<LocVO>();

		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int location_id = rs.getInt("location_id");
				String street_address = rs.getNString("street_address");
				String postal_code = rs.getNString("postal_code");
				String city = rs.getNString("city");
				int country_country_id = rs.getInt("country_country_id");
				String country_name = rs.getString("country_name");

				LocVO vo = new LocVO(location_id, street_address, postal_code, city, country_country_id, country_name);
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// Select Location by city_name
	@Override
	public LocVO selectByCity(String city_name) {
		String SQL = "select * from location l, country c where l.country_country_id = c.country_id and l.city = ?";
		Connection conn = getConnection();
		LocVO vo = null;

		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, city_name);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int location_id = rs.getInt("location_id");
				String street_address = rs.getNString("street_address");
				String postal_code = rs.getNString("postal_code");
				String city = rs.getNString("city");
				int country_country_id = rs.getInt("country_country_id");
				String country_name = rs.getString("country_name");

				vo = new LocVO(location_id, street_address, postal_code, city, country_country_id, country_name);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
}