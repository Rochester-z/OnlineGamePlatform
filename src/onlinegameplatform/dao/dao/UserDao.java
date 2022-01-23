package onlinegameplatform.dao.dao;

import java.sql.SQLException;

public interface UserDao {

    /**定义操作数据库的方法
     * 查询所有
     */
    void findAll() throws SQLException;


    //增
    void insert(String userName, String password);

    //查
    void delete(int id);

    //更新,改

    /**
     * 根据ID去更新具体的用户名
     */
    void update(int id, String name);




    /**
     * 登录方法
     * @param username
     * @param password
     */

    boolean login(String username, String password);

}
