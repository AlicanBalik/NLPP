package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import configuration.MysqlConnection;
import models.ListResult;

public class ReservationDAO extends MysqlConnection {

	public static List<ListResult> showAccommodations(List<Object> keywords) {
		makeJDBCConnection();
		
		List<ListResult> list = new ArrayList<ListResult>();
		
		try {
			// city, room, checkin, checkout.
			String city = keywords.get(0).toString();
			int room = (Integer) keywords.get(1);
			String checkin = keywords.get(2).toString();
			String checkout = keywords.get(3).toString();			
			
			String getQueryStatement = "SELECT count(r.room_name) as totalNumber, r.id, r.room_name, r.room_size, r.room_capacity, a.name, a.address, a.rank "
					+ "FROM accommodation_rooms r "
					+ "join accommodation a on r.accommodation = a.id "
					+ "join cb_cities c on a.city = c.id "
					+ "where c.city_name = ? GROUP by r.room_name;"; 
					

			ribaPrepareStat = ribaConn.prepareStatement(getQueryStatement);
			ribaPrepareStat.setString(1, city);


			ResultSet rs = ribaPrepareStat.executeQuery();

			int i = 0;
			while (rs.next()) {
				
				Integer roomId = rs.getInt("id");
				Integer count = rs.getInt("totalNumber");
				String roomName = rs.getString("room_name");
				Integer price = rs.getInt("room_size");
				Integer capacity = rs.getInt("room_capacity");
				String name = rs.getString("name");
				String address = rs.getString("address");
				int rank = rs.getInt("rank");
				
				ListResult obj = new ListResult(roomId, count, roomName, price, capacity, name, address, rank);
				
				list.add(obj);
						
				i++;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
