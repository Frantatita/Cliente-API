package mybatis;

import java.io.IOException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.Reader;


/**
 *
 * @author reyes
 */

public class MybatisUtil {
    
    private static final String RESOURCE = "mybatis/mybatis-confi.xml";
    private static final String ENVIROMENT ="development"; 
    
    public static SqlSession obtencionConexion(){
        SqlSession conexionBD = null;
        try {
            Reader reader = Resources.getResourceAsReader(RESOURCE);
            SqlSessionFactory abrirSesion = new SqlSessionFactoryBuilder().build(reader);
            conexionBD = abrirSesion.openSession();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
     return conexionBD;   
    }
    
}
