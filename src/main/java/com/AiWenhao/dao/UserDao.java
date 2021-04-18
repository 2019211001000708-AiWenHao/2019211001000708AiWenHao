package com.AiWenhao.dao;

import com.AiWenhao.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class UserDao implements IUserDao {
    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
//        insert .. into usertable --- write coded yourself
        return false;
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        //delete .... where id=?
        return 0;
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        //update .... where id=?
        //TODO 5.1 - write update sqZ where id =?
        //TODO 5.2 - create prepared statement
        //TODO 5.3 - executeUpdate()
        //TODO 5.4 return int

        String sql="update Usertable set username=?,password=?,email=?,gender=?,birthdate=? where id=?";
        PreparedStatement pstmt= con.prepareStatement(sql);
        pstmt.setString(1,user.getUsername());
        pstmt.setString(2,user.getPassword());
        pstmt.setString(3,user.getEmail());
        pstmt.setString(4,user.getGender());
        pstmt.setDate(5,new java.sql.Date(user.getBirthdate().getTime()));
        pstmt.setInt(6,user.getId());
        return pstmt.executeUpdate();
    }

    @Override
    public User findById(Connection con, Integer id) throws SQLException {
    return null;
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        //use for login
        ///select .... where id=? and password=?
        String sql = "select * from Usertable where username=? and password=?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,username);
        st.setString(2,password);
        ResultSet rs = st.executeQuery();
        User user=null;
        if (rs.next()) {

            //get from rs and set into user model
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));

            //done

        }
        return user;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        return null;
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        return null;
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        return null;
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        return null;
    }

    @Override
    public List<User> findByBirthdate(Connection con, Date birthDate) throws SQLException {
        return null;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        return null;
    }
}
