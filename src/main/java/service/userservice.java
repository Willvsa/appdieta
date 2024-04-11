
import DAO.ClienteDAO;
import com.example.dao.UserDao; // Asegúrate de que UserDao esté adaptado para trabajar con UsuariosConf.
import com.example.appdieta.cliente;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.Date;

public class UserService {

    private ClienteDAO userDao = new ClienteDAO();

    // Método para autenticar al usuario
    public boolean authenticate(String username, String password) {
        // Busca al usuario por su nombre de usuario en la base de datos
        cliente usuario = userDao.findUserByUsername(username);

        // Comprueba si el usuario existe y si la contraseña proporcionada coincide con la contraseña almacenada (utilizando BCrypt)
        return usuario != null && BCrypt.checkpw(password, usuario.getPassword());
    }
    public void createUser(String username, String email, String plainPassword) {
        String hashedPassword = BCrypt.hashpw(plainPassword, BCrypt.gensalt());
        UsuariosConf newUser = new UsuariosConf();
        newUser.setUsername(username);
        newUser.setEmail(email);
        newUser.setPassword(hashedPassword); // Guarda la contraseña como un hash
        newUser.setCreationDate(new Date()); // Establece la fecha actual como fecha de creación

        userDao.save(newUser);
    }
}
