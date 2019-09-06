import org.junit.Test;

import java.io.IOException;

/**
 * CsvToSqlFileTest
 * 测试
 * @version 1.0.0
 * @author: Tommao
 * @date: 2019/9/5
 */
public class CsvToSqlFileTest {

    @Test
    public void csvToSqlFileNotFoundTest() throws IOException {
        CsvToSqlFile.exportSqlFile("","");
    }

    @Test
    public void csvNotFoundTest() throws IOException {
        CsvToSqlFile.exportSqlFile("t_log_2.csv",CsvToSqlFileTest.class.getClassLoader().getResource("").getPath()+"t_log_0.sql");
    }

    @Test
    public void sqlPathNotFoundTest() throws IOException {
        CsvToSqlFile.exportSqlFile("t_log_0.csv","H:\\Users\\Administrator\\Desktop\\t_log_0.sql");
    }
}
