package py.com.mark.MarNotes.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import py.com.marce.commons.User;

@Repository
public class UserDAOImpl implements UserDAO{
    Logger log = LoggerFactory.getLogger(UserDAOImpl.class);
    private static final String GET_USER_DOCUMENT = "SELECT * FROM users WHERE document = ? ";
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public User getUserByDocument(String document) {
        log.info(String.format("Getting user with docuemnt: %s",document));
        return jdbcTemplate.queryForObject(
                GET_USER_DOCUMENT,
                new Object []{document},
                (rs,i)->{
                    User user = new User();
                    user.setDocument(rs.getString("document"));
                    user.setName(rs.getString("user_name"));
                    user.setPassword(rs.getString("password"));
                     return user;
            }
        );

    }
}
