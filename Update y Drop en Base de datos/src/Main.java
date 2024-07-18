import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/estudiates2024";
        String user = "root";
        String password = "123456";
        Connection conexion = null;
        PreparedStatement pstmt = null;

        try {
            // ESTABLECER LA CONEXION
            conexion = DriverManager.getConnection(url, user, password);

            // PREPARAR LA SENTENCIA SQL
            String sql = "UPDATE estudiantes SET b1=?  WHERE cedula=?";
            pstmt = conexion.prepareStatement(sql);

            //SETEAMOS LOS VALORES DE LA SENTENCIA PREVIA
            pstmt.setInt(1, 9);   // SE LE ASIGNA EL VALOR QUE SE DESEA CAMBIAR DE LA PRIMERA CONDICION SET b1=?
            pstmt.setString(2, "0094098135");  // SE LE COLOCA LE CEDULA DEL QUE SE DESEA CAMBIAR

            //IMPRIMER EL ENUNCIADO
            System.out.println(sql);
            int result = pstmt.executeUpdate();
            System.out.println("se modificaron: " + result + "filas");

        } catch (SQLException e) {
            // throw new RuntimeException(e);
            System.out.println(e.getMessage());  // MENSAJE DE ERRO SI SE LLEGA A PRODUCIR

            /// CIERRE DE LA CONECCION
        } finally {
            try {

                // cerramos la conexion
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}