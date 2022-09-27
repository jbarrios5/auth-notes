package py.com.mark.MarNotes.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import py.com.mark.MarNotes.bean.AccessToken;

import java.util.Date;

@Repository
public class LoginDAOImpl implements LoginDAO{
    Logger log = LoggerFactory.getLogger(LoginDAOImpl.class);
    private static final String GET_TOKEN = "SELECT * FROM logins WHERE access_token = ?";
    private static final String ADD_TOKEN = "INSERT INTO logins" +
            "(created,expiration,access_token)" +
            " values (?,?,?)";
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public AccessToken getAccessToken(String at) {
        log.info(String.format("Buscamos  el token: %s",at));
        return jdbcTemplate.queryForObject(GET_TOKEN,
                new Object [] {at},
                (rs,index) ->{
                    AccessToken accessToken = new AccessToken();
                    accessToken.setExpiration(rs.getTimestamp("expiration"));
                    accessToken.setValue(rs.getString("access_token"));
                return accessToken;
        });

    }

    @Override
    public void addAccessToken(Date created, Date expiration, String at) {
        log.info(String.format("Registraremos el token: %s",at));
        jdbcTemplate.update(
                ADD_TOKEN,
                created,
                expiration,
                at
        );
        log.info("Token registrado");

    }
}
