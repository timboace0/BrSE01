package bussiness.dao;

import bussiness.model.Room;
import utils.ConnectionDB;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HotelDaoImpl implements IHotelDao {

    @Override
    public void bookRoom(int roomId, String customerName, Date startDate, Date endDate) {
        Connection conn = ConnectionDB.openConnection();

        try {
            conn.setAutoCommit(false);

            String checkRoomSql = "SELECT * FROM room WHERE id = ? FOR UPDATE";

            PreparedStatement checkRoom = conn.prepareStatement(checkRoomSql);
            checkRoom.setInt(1, roomId);

            ResultSet rs = checkRoom.executeQuery();

            if (!rs.next()) {
                throw new RuntimeException("Phòng không tồn tại!");
            }

            boolean isBooked = rs.getBoolean("is_booked");

            if (isBooked) {
                throw new RuntimeException("Phòng đã được đặt!");
            }

            String insertSql = """
                    INSERT INTO booking(room_id, customer_name, start_date, end_date)
                    VALUES (?, ?, ?, ?)
                    """;

            PreparedStatement insertBooking = conn.prepareStatement(insertSql);

            insertBooking.setInt(1, roomId);
            insertBooking.setString(2, customerName);
            insertBooking.setDate(3, startDate);
            insertBooking.setDate(4, endDate);

            insertBooking.executeUpdate();

            String updateRoomSql = """
                    UPDATE room
                    SET is_booked = TRUE
                    WHERE id = ?
                    """;

            PreparedStatement updateRoom = conn.prepareStatement(updateRoomSql);

            updateRoom.setInt(1, roomId);

            updateRoom.executeUpdate();

            conn.commit();

            System.out.println("Đặt phòng thành công!");

        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

            System.out.println(e.getMessage());

        } finally {
            ConnectionDB.closeConnection(conn);
        }
    }

    @Override
    public void cancelBooking(int bookingId) {
        Connection conn = ConnectionDB.openConnection();

        try {
            conn.setAutoCommit(false);

            String findBookingSql = """
                    SELECT room_id
                    FROM booking
                    WHERE id = ?
                    FOR UPDATE
                    """;

            PreparedStatement findBooking = conn.prepareStatement(findBookingSql);

            findBooking.setInt(1, bookingId);

            ResultSet rs = findBooking.executeQuery();

            if (!rs.next()) {
                throw new RuntimeException("Không tìm thấy booking!");
            }

            int roomId = rs.getInt("room_id");

            String deleteBookingSql = """
                    DELETE FROM booking
                    WHERE id = ?
                    """;

            PreparedStatement deleteBooking = conn.prepareStatement(deleteBookingSql);

            deleteBooking.setInt(1, bookingId);

            deleteBooking.executeUpdate();

            String updateRoomSql = """
                    UPDATE room
                    SET is_booked = FALSE
                    WHERE id = ?
                    """;

            PreparedStatement updateRoom = conn.prepareStatement(updateRoomSql);

            updateRoom.setInt(1, roomId);

            updateRoom.executeUpdate();

            conn.commit();

            System.out.println("Hủy đặt phòng thành công!");

        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

            System.out.println(e.getMessage());

        } finally {
            ConnectionDB.closeConnection(conn);
        }
    }

    @Override
    public List<Room> listAvailableRooms() {
        Connection conn = ConnectionDB.openConnection();

        List<Room> rooms = new ArrayList<>();

        try {
            String sql = """
                    SELECT *
                    FROM room
                    WHERE is_booked = FALSE
                    """;

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Room room = new Room(
                        rs.getInt("id"),
                        rs.getString("room_number"),
                        rs.getString("type"),
                        rs.getBigDecimal("price"),
                        rs.getBoolean("is_booked")
                );

                rooms.add(room);
            }

            return rooms;

        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            ConnectionDB.closeConnection(conn);
        }
    }
}