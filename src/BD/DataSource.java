
package BD;

import java.sql.Connection;
import java.util.ArrayList;

public interface DataSource {
    
    public Object ejecutarConsulta(String consulta);
    
    public int ejecutarActualizacion(String consulta);
    
    public Connection getConnection();
    
    public void cerrarConexion();
    
    public ArrayList crearArreglo(String consulta, String tipo);
    
}
