package py.com.mark.MarNotes.service;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class EncryptServiceImpl implements EncryptService{
    @Override
    public String encryptPassword(String password) {
        return BCrypt.hashpw(password,BCrypt.gensalt());
    }
}
