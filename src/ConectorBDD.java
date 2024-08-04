
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ConectorBDD {

    private Connection conexion;
    private Statement sentencia;
    
      private static final String SERVIDOR = "localhost";
      private static final String PUERTO = "3306";
      private static final String BD = "registro_estudiantes";
      private static final String USUARIO = "root";
      private static final String CLAVE = "santiago**23"; // borrar al a salir y dejar en ""
      private static final String URL = "jdbc:mysql://" + SERVIDOR + ":" + PUERTO + "/" + BD ; 
            
    public ConectorBDD(){
        this.conexion = null;
        this.sentencia = null;
    }
    
    
    public boolean conectar(){
        boolean estado = false;
        try{
          Class.forName("com.mysql.cj.jdbc.Driver");
          try{  
              conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
              estado = true;
            } catch (SQLException ex) {
            System.err.println("ERROR: ConectorBDD.conectar()");
            System.out.println("Al intentar la conexion con la BD");
            System.out.println(ex.getMessage());
          }
        } catch ( ClassNotFoundException cex ) {
            System.err.println("ERROR: ConectorBDD.conectar()");
            System.out.println("No se encontro el Driver de Conexion con MySQL");
            System.out.println(cex.getMessage());
        }
        return estado;
    }

    public ResultSet seleccionar(String sql){
        ResultSet resultado  = null;
        try{
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sql);
        } catch(SQLException sqle){
            System.err.println( "ERROR: ConectorBDD.seleccionar(sql)" );
            System.err.println( sqle.getMessage() );
        }
        return resultado;
    }
    
    public boolean ejecutar(String sql){
        boolean estado  = false;
        try{
            sentencia = conexion.createStatement();
            sentencia.execute(sql);
            sentencia.close();
            estado = true;
        } catch(SQLException sqle){
            System.err.println( "ERROR: ConectorBDD.seleccionar(sql)" );
            System.err.println( sqle.getMessage() );
        }
        return estado;
    }
    
    public void desconectar(){
        try{
            if( conexion != null ){
                conexion.close();
                conexion = null;
            }
        } catch(SQLException sqle){
            System.err.println( "ERROR: ConectorBDD.seleccionar(sql)" );
            System.err.println( sqle.getMessage() );
        }
    }
    
    public Connection getConnection(){
            return conexion;
    }   
    
}
 