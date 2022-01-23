package onlinegameplatform.dao.impl;

import onlinegameplatform.dao.dao.UserDao;
import onlinegameplatform.util.JDBCUtil;

import java.sql.*;

public class daoimp implements UserDao {


    @Override
    public void findAll() throws SQLException {
        //模板代码
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            //1.获取连接对象
            conn = JDBCUtil.getConn();

            //2.创建statement对象
            st = conn.createStatement();

            String sql = "select * from wemeet";
            rs = st.executeQuery(sql);

            while (rs.next()){
               String username = rs.getString("username");
               String password = rs.getString("password");

               System.out.println(username + "=" + password);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.release(conn,st,rs);
        }

    }

    @Override
    public void insert(String userName, String password) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtil.getConn();
            String sql = "insert into wemeet values(?, ?)";
            ps = conn.prepareStatement(sql);
            //给占位符赋值,从左到右数过来,1代表第一个问好,永远是从1开始
            ps.setString(1, userName);
            ps.setString(2, password);

            int result = ps.executeUpdate();
            if(result>0){
                System.out.println("注册成功");
            }else{
                System.out.println("注册失败");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.release(conn,ps);
        }
    }

    @Override
    public void delete(int id) {

        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtil.getConn();
            String sql = "delete from t_user where id = ?";
            ps = conn.prepareStatement(sql);
            //给占位符赋值,从左到右数过来,1代表第一个问好,永远是从1开始
            ps.setInt(1, id);

            int result = ps.executeUpdate();
            if(result>0){
                System.out.println("删除成功");
            }else{
                System.out.println("删除失败");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.release(conn,ps);
        }

    }

    @Override
    public void update(int id, String name) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtil.getConn();
            String sql = "update t_user set username = ? where id = ?";
            ps = conn.prepareStatement(sql);
            //给占位符赋值,从左到右数过来,1代表第一个问好,永远是从1开始
            ps.setString(1, name);
            ps.setInt(2,id);

            int result = ps.executeUpdate();
            if(result>0){
                System.out.println("更新成功");
            }else{
                System.out.println("更新失败");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.release(conn,ps);
        }

    }


    @Override
//    public void login(String username, String password) {//实现时自动传入参数
//
//        //模板代码
//        Connection conn = null;
//        Statement st = null;
//        ResultSet rs = null;
//
//        try {
//            //1.获取连接对象
//            conn = JDBCUtil.getConn();
//
//            //2.创建statement对象
//            st = conn.createStatement();
//
//            //"和"匹配
//            String sql = "select * from t_user where username = '"+username+"'and password = '"+password+"'";
//            rs = st.executeQuery(sql);
//
//            if(rs.next()){
//                System.out.println("登陆成功");
//            }else{
//                System.out.println("登陆失败");
//            }
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }finally {
//            JDBCUtil.release(conn,st,rs);
//        }
//
//
//    }


    public boolean login(String username, String password) {//实现时自动传入参数

        //模板代码
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            //1.获取连接对象
            conn = JDBCUtil.getConn();

            //2.创建preparestatement对象

            //区别,先写sql语句,再创建prestatement对象同时检查sql语句 ?对应的内容,后面不管传递什么进来,都把它看成是字符串
            String sql = "select * from wemeet where username = ? and password = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            //?对应的索引从1开始
            System.out.println("ps"+ps);
            ps.setString(1,username);       //?对应内容
            ps.setString(2,password);
            rs = ps.executeQuery();

            //"和"匹配

            //区别,先创建st对象,在写sql语句,没有检查sql语句
//            st = conn.createStatement();
//            String sql2 = "select * from t_user where username = '"+username+"'and password = '"+password+"'";
//            rs = st.executeQuery(sql);

            if(rs.next()){
                return true;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.release(conn,st,rs);
        }
        return false;

    }


}
