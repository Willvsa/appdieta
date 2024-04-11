package DAO;

import com.example.appdieta.cliente;
import database.DatabaseManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    // Método para insertar un nuevo cliente en la base de datos
    public static void insertCliente(cliente cliente) throws SQLException {
        String query = "INSERT INTO clientes (nombre, edad, peso, altura) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, cliente.getNombre());
            statement.setInt(2, cliente.getEdad());
            statement.setFloat(3, cliente.getPeso());
            statement.setFloat(4, cliente.getAltura());
            statement.executeUpdate();
        }
    }

    // Método para obtener todos los clientes de la base de datos
    public static List<cliente> getAllClientes() throws SQLException {
        List<cliente> clientes = new ArrayList<>();
        String query = "SELECT * FROM clientes";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement statement = conn.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                int edad = resultSet.getInt("edad");
                float peso = resultSet.getFloat("peso");
                float altura = resultSet.getFloat("altura");
                cliente cliente = new cliente(id, nombre, edad, peso, altura);
                clientes.add(cliente);
            }
        }
        return clientes;
    }

    // Método para actualizar un cliente en la base de datos
    public static void updateCliente(cliente cliente) throws SQLException {
        String query = "UPDATE clientes SET nombre=?, edad=?, peso=?, altura=? WHERE id=?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, cliente.getNombre());
            statement.setInt(2, cliente.getEdad());
            statement.setFloat(3, cliente.getPeso());
            statement.setFloat(4, cliente.getAltura());
            statement.setInt(5, cliente.getId());
            statement.executeUpdate();
        }
    }

    // Método para eliminar un cliente de la base de datos
    public static void deleteCliente(int id) throws SQLException {
        String query = "DELETE FROM clientes WHERE id=?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    // Método para buscar un cliente por ID en la base de datos
    public static cliente findClienteById(int id) throws SQLException {
        String query = "SELECT * FROM clientes WHERE id=?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String nombre = resultSet.getString("nombre");
                    int edad = resultSet.getInt("edad");
                    float peso = resultSet.getFloat("peso");
                    float altura = resultSet.getFloat("altura");
                    return new cliente(id, nombre, edad, peso, altura);
                }
            }
        }
        return null; // Si no se encuentra ningún cliente con el ID especificado
    }

}
