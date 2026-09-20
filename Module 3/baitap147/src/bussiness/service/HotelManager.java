package bussiness.service;

import bussiness.dao.HotelDaoImpl;
import bussiness.dao.IHotelDao;
import bussiness.model.Room;

import java.sql.Date;
import java.util.List;

public class HotelManager {

    private IHotelDao hotelDao = new HotelDaoImpl();

    public void bookRoom(int roomId, String customerName, Date startDate, Date endDate) {
        if (startDate.after(endDate)) {
            System.out.println("Ngày bắt đầu không được sau ngày kết thúc!");
            return;
        }

        hotelDao.bookRoom(roomId, customerName, startDate, endDate);
    }

    public void cancelBooking(int bookingId) {
        hotelDao.cancelBooking(bookingId);
    }

    public void listAvailableRooms() {
        List<Room> rooms = hotelDao.listAvailableRooms();

        if (rooms.isEmpty()) {
            System.out.println("Không còn phòng trống!");
            return;
        }

        System.out.println("""
                
                ========== PHÒNG CÒN TRỐNG ==========
                """);

        for (Room room : rooms) {
            System.out.println(room);
        }
    }
}