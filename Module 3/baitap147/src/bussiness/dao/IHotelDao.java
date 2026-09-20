package bussiness.dao;

import bussiness.model.Room;

import java.sql.Date;
import java.util.List;

public interface IHotelDao {
    void bookRoom(int roomId, String customerName, Date startDate, Date endDate);
    void cancelBooking(int bookingId);
    List<Room> listAvailableRooms();
}