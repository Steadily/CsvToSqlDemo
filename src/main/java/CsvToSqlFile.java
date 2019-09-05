import java.io.*;

/**
 * CsvToSqlFile
 * 将csv文件转为sql文件
 * @version 1.0.0
 * @author: maoxu
 * @date: 2019/9/5
 */
public class CsvToSqlFile {

    private static final String cvsSplit = ",";

    /**
     * 导出sql文件
     * @param fileName
     * @param exportSqlPath
     * @throws IOException
     */
    public static void exportSqlFile(String fileName,String exportSqlPath) throws IOException {
        String tableName = fileName.substring(0, fileName.lastIndexOf("."));
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(CsvToSqlFile.class.getClassLoader().getResource(fileName).getFile()));
            BufferedWriter  bw = new BufferedWriter(new FileWriter(exportSqlPath, true));
            int a = 0;
            while ((line = br.readLine()) != null) {
                if(a == 0){
                    a = 1;
                    continue;
                }
                String[] dataArray = line.split(cvsSplit);
                bw.append("INSERT INTO ")
                        .append(tableName)
                        .append(" VALUES ")
                        .append(" (")
                        .append(line)
                        .append(")")
                        .append(";")
                        .append("\r\n");
                bw.flush();
            }
        } catch (FileNotFoundException e){
            System.out.println("文件未找到，请检查");
            throw e;
        } catch (IOException e) {
            System.out.println("文件读取出错");
            throw e;
        }
    }
}
