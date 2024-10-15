
package DAO;

import java.sql.*;
import java.util.*;

import Model.DBConnect;
import Model.Allocation;
public class AllocationDAO {
    public List<Allocation> getAllocations(){
        List<Allocation> allocations = new ArrayList<>();
    
                try {
            Connection con = new DBConnect().getConnection();
            String sql = "SELECT * FROM Allocation";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Allocation allocation = new Allocation();
               allocation.setAllocation_id(rs.getInt("allocation_id"));
                allocation.setMember_id(rs.getInt("member_id"));
                allocation.setProject_id(rs.getInt("project_id"));
                allocation.setRole_setting_id(rs.getInt("role_setting_id"));
                allocation.setFrom_date(rs.getDate("from_date"));
                allocation.setTo_date(rs.getDate("to_date"));
                allocation.setRate(rs.getFloat("rate"));
                allocation.setDescription(rs.getString("description"));
                allocation.setCreated_at(rs.getTimestamp("created_at"));
                allocation.setCreated_by_id(rs.getInt("created_by_id"));
                allocation.setUpdated_at(rs.getTimestamp("updated_at"));
                allocation.setUpdated_by_id(rs.getInt("updated_by_id"));
                
                allocations.add(allocation);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return allocations;
}
    public void createAllocation(Allocation allocation) throws SQLException, ClassNotFoundException {
    Connection conn = new DBConnect().getConnection();
    String sql = "INSERT INTO Allocation (allocation_id, member_id, project_id, role_setting_id, " +
                 "from_date, to_date, rate, description, " +
                 "created_at, created_by_id, updated_at, updated_by_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    
    try {
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, allocation.getAllocation_id()); // Thiết lập allocation_id
        ps.setInt(2, allocation.getMember_id());
        ps.setInt(3, allocation.getProject_id());
        ps.setInt(4, allocation.getRole_setting_id());
        ps.setDate(5, allocation.getFrom_date());
        ps.setDate(6, allocation.getTo_date());
        ps.setFloat(7, allocation.getRate());
        ps.setString(8, allocation.getDescription());
        ps.setTimestamp(9, allocation.getCreated_at());
        ps.setInt(10, allocation.getCreated_by_id());
        ps.setTimestamp(11, allocation.getUpdated_at());
        ps.setInt(12, allocation.getUpdated_by_id());
        
        ps.executeUpdate();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    public void deleteAllocation(int id) throws SQLException, ClassNotFoundException {
    Connection conn = new DBConnect().getConnection();
    String sql = "DELETE FROM Allocation WHERE allocation_id = ?";
    try {
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
    AllocationDAO allocationDAO = new AllocationDAO();

     allocationDAO.deleteAllocation(5); // Xóa allocation với allocation_id là 1
    System.out.println("Phân bổ đã được xóa thành công.");

        // Lấy danh sách các phân bổ và in ra thông tin
        List<Allocation> allocations = allocationDAO.getAllocations();
        System.out.println("Danh sách các phân bổ:");
        for (Allocation allocation : allocations) {
            System.out.println(allocation.getAllocation_id() + " " +
                    allocation.getMember_id() + " " +
                    allocation.getProject_id() + " " +
                    allocation.getRole_setting_id() + " " +
                    allocation.getFrom_date() + " " +
                    allocation.getTo_date() + " " +
                    allocation.getRate() + " " +
                    allocation.getDescription() + " " +
                    allocation.getCreated_at() + " " +
                    allocation.getCreated_by_id() + " " +
                    allocation.getUpdated_at() + " " +
                    allocation.getUpdated_by_id());
        }
}
}
