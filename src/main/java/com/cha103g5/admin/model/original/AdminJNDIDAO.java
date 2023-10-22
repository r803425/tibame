package com.cha103g5.admin.model.original;
//package com.cha103g5.admin.model.originalHibernate;
//
//import com.cha103g5.util.Util;
//
//import javax.naming.Context;
//import javax.naming.InitialContext;
//import javax.naming.NamingException;
//import javax.sql.DataSource;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//import java.sql.Timestamp;
//
//public class AdminJNDIDAO implements AdminDAOInterface{
//
//    private static DataSource ds = null;
//    static {
//        try {
//            Context ctx = new InitialContext();
//            ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB2");
//        } catch (NamingException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static final String INSERT_STMT =
//            "INSERT INTO admin (adminaccount,adminpassword,adminname,createddate,adminstat,adminemail,adminphone) VALUES (?, ?, ?, ?, ?, ?, ?)";
//    private static final String GET_ALL_STMT =
//            "SELECT adminno,adminaccount,adminpassword,adminname,createddate,adminstat,adminemail,adminphone FROM admin order by adminno";
//    private static final String GET_ONE_STMT =
//            "SELECT adminno,adminaccount,adminpassword,adminname,createddate,adminstat,adminemail,adminphone FROM admin where adminno = ?";
//    private static final String DELETE =
//            "DELETE FROM admin where adminno = ?";
//    private static final String UPDATE =
//            "UPDATE admin set adminno=?,adminaccount=?,adminpassword=?, adminname=?,createddate=?, adminstat=?, adminemail=?, adminphone=? where adminno = ?";
//
//    @Override
//    public void insert(AdminVO adminVO) {
//        Connection con = null;
//        PreparedStatement pstmt = null;
//
//        try {
//            con = Util.getConnection();
//            pstmt = con.prepareStatement(INSERT_STMT);
//
//            pstmt.setString(1, adminVO.getAdminAccount());
//            pstmt.setString(2, adminVO.getAdminPassword());
//            pstmt.setString(3, adminVO.getAdminName());
//            pstmt.setTimestamp(4, adminVO.getCreateDate());
//            pstmt.setInt(5, adminVO.getAdminStat());
//            pstmt.setString(6, adminVO.getAdminEmail());
//            pstmt.setString(7, adminVO.getAdminPhone());
//
//            pstmt.executeUpdate();
//
//        } catch (SQLException se) {
//            throw new RuntimeException("Database error occurred."
//                    + se.getMessage());
//        } finally {
//            Util.closeResources(con, pstmt, null);
//        }
//    }
//
//    @Override
//    public void update(AdminVO adminVO) {
//        Connection con = null;
//        PreparedStatement pstmt = null;
//
//        try {
//            con = Util.getConnection();
//            pstmt = con.prepareStatement(UPDATE);
//
//
//            pstmt.setInt(1, adminVO.getAdminNo());
//            pstmt.setString(2, adminVO.getAdminAccount());
//            pstmt.setString(3, adminVO.getAdminPassword());
//            pstmt.setString(4, adminVO.getAdminName());
//            pstmt.setTimestamp(5, adminVO.getCreateDate());
//            pstmt.setInt(6, adminVO.getAdminStat());
//            pstmt.setString(7, adminVO.getAdminEmail());
//            pstmt.setString(8, adminVO.getAdminPhone());
//            pstmt.setInt(9, adminVO.getAdminNo());
//
//            pstmt.executeUpdate();
//
//        } catch (SQLException se) {
//            throw new RuntimeException("Database error occurred."
//                    + se.getMessage());
//        } finally {
//            Util.closeResources(con, pstmt, null);
//        }
//    }
//
//
//    @Override
//    public void delete(Integer adminNo) {
//        Connection con = null;
//        PreparedStatement pstmt = null;
//
//        try {
//            con = Util.getConnection();
//            pstmt = con.prepareStatement(DELETE);
//
//            pstmt.setInt(1, adminNo);
//            pstmt.executeUpdate();
//
//        } catch (SQLException se) {
//            throw new RuntimeException("Database error occurred."
//                    + se.getMessage());
//        } finally {
//            Util.closeResources(con, pstmt, null);
//        }
//    }
//
//    @Override
//    public AdminVO findByPrimaryKey(Integer adminNo) {
//
//        AdminVO adminVO = null;
//        Connection con = null;
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//
//        try {
//            con = Util.getConnection();
//            pstmt = con.prepareStatement(GET_ONE_STMT);
//
//            pstmt.setInt(1, adminNo);
//            rs = pstmt.executeQuery();
//
//            while (rs.next()){
//                adminVO = new AdminVO();
//                adminVO.setAdminNo(rs.getInt("adminno"));
//                adminVO.setAdminAccount(rs.getString("adminaccount"));
//                adminVO.setAdminPassword(rs.getString("adminpassword"));
//                adminVO.setAdminName(rs.getString("adminname"));
//                adminVO.setCreateDate(rs.getTimestamp("createddate"));
//                adminVO.setAdminStat(rs.getInt("adminstat"));
//                adminVO.setAdminEmail(rs.getString("adminemail"));
//                adminVO.setAdminPhone(rs.getString("adminphone"));
//            }
//
//        } catch (SQLException se) {
//            throw new RuntimeException("Database error occurred."
//                    + se.getMessage());
//        } finally {
//            Util.closeResources(con, pstmt, rs);
//        }
//        return adminVO;
//    }
//
//    @Override
//    public List<AdminVO> getAll() {
//        List<AdminVO> list = new ArrayList<AdminVO>();
//        AdminVO adminVO = null;
//
//        Connection con = null;
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//
//        try {
//            con = Util.getConnection();
//            pstmt = con.prepareStatement(GET_ALL_STMT);
//            rs = pstmt.executeQuery();
//
//            while (rs.next()){
//                adminVO = new AdminVO();
//                adminVO.setAdminNo(rs.getInt("adminno"));
//                adminVO.setAdminAccount(rs.getString("adminaccount"));
//                adminVO.setAdminPassword(rs.getString("adminpassword"));
//                adminVO.setAdminName(rs.getString("adminname"));
//                adminVO.setCreateDate(rs.getTimestamp("createddate"));
//                adminVO.setAdminStat(rs.getInt("adminstat"));
//                adminVO.setAdminEmail(rs.getString("adminemail"));
//                adminVO.setAdminPhone(rs.getString("adminphone"));
//                list.add(adminVO);
//            }
//
//        } catch (SQLException se) {
//            throw new RuntimeException("Database error occurred."
//                    + se.getMessage());
//        } finally {
//            Util.closeResources(con, pstmt, rs);
//        }
//        return list;
//
//    }
//
//}
