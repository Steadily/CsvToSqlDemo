import java.io.IOException;

/**
 * Main
 * 入口
 * @version 1.0.0
 * @author: Tommao
 * @date: 2019/9/5
 */
public class Main {
    public static void main(String[] args) throws IOException {
        String exportSqlPath=Main.class.getClassLoader().getResource("").getPath()+"t_log_0.sql";
        CsvToSqlFile.exportSqlFile("t_log_0.csv",exportSqlPath);
    }
}
