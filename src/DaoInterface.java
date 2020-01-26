
import java.io.IOException;
import java.sql.SQLException;


public interface DaoInterface {
    void outputTable() throws SQLException, ClassNotFoundException;
    void getById(int id) throws SQLException, ClassNotFoundException;
    void insertInto(String[] value) throws SQLException, ClassNotFoundException;
    void deleteByID(int id) throws SQLException, ClassNotFoundException, IOException;
}
