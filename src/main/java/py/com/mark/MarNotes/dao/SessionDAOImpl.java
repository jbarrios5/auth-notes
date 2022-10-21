package py.com.mark.MarNotes.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import py.com.marce.commons.User;
import py.com.mark.MarNotes.bean.AccessToken;
import py.com.mark.MarNotes.bean.Session;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

@Repository
public class SessionDAOImpl implements SessionDAO {
    private static final String INSERT_SESSION = "INSERT INTO session (user_id,token,expiration) VALUES(?,?,?)";
    private static final String GET_SESSION = "SELECT * FROM session WHERE token = ?";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Session createSession(User user, AccessToken at, Timestamp expires) {
        Session  session = new Session();
        session.setSessionId(user.getId());
        session.setExpires(expires);
        session.setAccessToken(at.getValue());

        jdbcTemplate.update(INSERT_SESSION,new Object[]{
                session.getSessionId(),
                session.getAccessToken(),
                session.getExpires()
        });

        return findByAccessToken(session.getAccessToken());
    }

    @Override
    public Session findByAccessToken(String at) {


        try {

            return jdbcTemplate.queryForObject(GET_SESSION,new Object [] {at},
                    (rs,i)->{
                        Session session = new Session();
                        session.setSessionId(rs.getInt("user_id"));
                        session.setExpires(rs.getTimestamp("expiration"));
                        session.setAccessToken(rs.getString("token"));
                        return session;
                    });
        }catch (EmptyResultDataAccessException e){
            System.out.println(""+e.getMessage());

        }catch (Exception e){
            System.out.println(""+e.getMessage());
        }
        return null;
    }
}
