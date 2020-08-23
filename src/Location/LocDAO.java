package Location;
import java.util.ArrayList;

public interface LocDAO {
	public int InsertLoc(LocVO vo);					// Insert Location Information
	public ArrayList<LocVO> selectAll();			// Select All Location
	public LocVO selectByCity(String city_name);	// Select Location by city_name
}