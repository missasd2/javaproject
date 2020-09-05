package CoreVolumeTow.chp4.jdbc;

import netscape.security.UserTarget;

import java.io.IOException;
import java.sql.*;
import java.util.List;

public class JdbcTest {

    private static Connection getConnection(){
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/corejava";
        String username = "root";
        String password = "123456";
        Connection conn = null;
        try {
            Class.forName(driver); // 加载驱动
            conn = DriverManager.getConnection(url, username, password);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }

    // 增
    private static int insert(Student student){
        Connection conn = getConnection();
        int i = 0;
        String sql = "INSERT INTO students (name, sex, age) values(?,?,?)";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getSex());
            pstmt.setString(3, student.getAge().toString());
            i = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return i;
    }

    // 改
    private static int update(Student student){
        Connection conn = getConnection();
        int i = 0;
        String sql = "update students set age='" + student.getAge() +"' where id='" + student.getId() + "'";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(sql);
            i = pstmt.executeUpdate();
            System.out.println("result: " + i);
            pstmt.close();
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return i;
    }

    // 查
    private static Integer getAll(){
        Connection conn = getConnection();
        String sql = "select * from students";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(sql);
            ResultSet resultSet = pstmt.executeQuery();
            int col = resultSet.getMetaData().getColumnCount();
            System.out.println("=================");
            while (resultSet.next()){
                for (int i = 1; i <= col ; i++) {
                    System.out.println(resultSet.getString(i) + "\t");
                    if ( (i == 2) && (resultSet.getString(i).length() < 3)){
                        System.out.println("\t");
                    }
                }
                System.out.println(" ");
            }
            System.out.println(" ");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    // 删
    private static int delete(Integer id){
        Connection conn = getConnection();
        int i = 0;
        String sql = "delete from students where id='" + id + "'";
        PreparedStatement psmt;
        try {
            psmt = conn.prepareStatement(sql);
            i = psmt.executeUpdate();
            System.out.println("result: " + i);
            psmt.close();
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return i;
    }


    public static void main(String[] args) {
//        Student DaMing = new Student();
//        DaMing.setAge(13);
//        DaMing.setName("Daming");
//        DaMing.setSex("Male");
//        int insert = JdbcTest.insert(DaMing);
//        // 1
//        System.out.println(insert);
//
//        DaMing.setAge(31);
//        int udpate = JdbcTest.update(DaMing);
//        // result: 0
//        //0
//        System.out.println(udpate);
        JdbcTest.getAll();
        JdbcTest.delete(1);
        System.out.println("After Delete ");
        JdbcTest.getAll();


    }
}
