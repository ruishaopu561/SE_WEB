package rsp.demo1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//@Controller
//@ResponseBody
public class DBHelper {

    //保存查询到的实体集合
    List list = null;


    private Statement openDB(){
        String DRIVER = "com.mysql.jdbc.Driver";
        String URL = "jdbc:mysql://localhost:3306/web";
        //  Database credentials
        String USER = "root";
        String PASSWORD = "Rsp1415!";

        //结果集
        try {
            Class.forName(DRIVER);
            System.out.println("Connecting to a selected database...");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected database successfully...");

            System.out.println("Creating statement...");
            Statement pst = conn.createStatement();
            return pst;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void closeDB(Statement st, ResultSet rs)
    {
        try {
            if (rs != null)
                rs.close();
            if (st != null)
                st.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

//    @GetMapping(value = "/books/{operation}")
    public List getBooks(){
        Statement pst = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM books";
        list = new ArrayList<Book>();

        try {
            pst = openDB();
            rs = pst.executeQuery(sql);

            while (rs.next()) {
                Book book = new Book();
                book.setName(rs.getString(1));
                book.setWriter(rs.getString(2));
                book.setPrice(rs.getInt(3));
                book.setIsbn((rs.getString(4)));
                book.setInventory(rs.getString(5));
                list.add(book);
//                System.out.println("name: "+book.name);
//                System.out.println("writer: " + book.writer);
//                System.out.println("price: "+book.price);
//                System.out.println("ISBN: "+book.isbn);
//                System.out.println("image: "+book.image);
            }
            System.out.println("Get books successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            closeDB(pst, rs);
        }
        return list;
    }

    public boolean login(String email, String password){
        String sql = "select * from unpw where email= '"+ email+"'";
        Statement st = openDB();
        ResultSet rs = null;
        try {
            rs = st.executeQuery(sql);
            System.out.println(rs);
            if(rs.equals(null)){
                return false;
            }
            while (rs.next())
            {
                if(!password.equals(rs.getString(4)))
                {
                    System.out.println("User don't exist!");
                    return false;
                }else{
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            closeDB(st, rs);
        }
        return true;
    }

    public boolean add(User user) {
        Statement pst = null;
        String sql = "insert into unpw values('" + user.getFirstname()+ "', '"+
                        user.getLastname()+"', '"+user.getEmail()+ "', '"+ user.getPassword()+"');";
        System.out.println(sql);
        try {
            pst = openDB();
            boolean rs = pst.execute(sql);
            System.out.println("User register successfully!");
            return rs;
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("User registeration fail!");
            return false;
        } finally {
            closeDB(pst, null);
        }
    }
}
