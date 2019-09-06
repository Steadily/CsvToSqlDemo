import org.apache.log4j.Logger;

import java.io.*;

/**
 * CsvToSqlFile
 * 将csv文件转为sql文件
 * @version 1.0.0
 * @author: maoxu
 * @date: 2019/9/5
 */
public class CsvToSqlFile {

    private static Logger logger = Logger.getLogger(CsvToSqlFile.class);

    /**
     * 导出sql文件
     * @param fileName
     * @param exportSqlPath
     * @throws IOException
     */
    public static void exportSqlFile(String fileName,String exportSqlPath) throws IOException {

        if(CsvToSqlFile.isEmpty(fileName) || CsvToSqlFile.isEmpty(exportSqlPath)){
            logger.error("文件名称，导出路径不能为空");
            return;
        }

        String tableName = fileName.substring(0, fileName.lastIndexOf("."));
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(CsvToSqlFile.class.getClassLoader().getResource(fileName).getFile()));
             OutputStreamWriter bw = new OutputStreamWriter(new FileOutputStream(exportSqlPath), "utf-8")) {

            br.readLine();
            while ((line = br.readLine()) != null) {
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
            logger.info("文件转换完成，sql文件路径：" + exportSqlPath);
        } catch (NullPointerException e){
            logger.error("文件未找到，请检查", e);
            throw e;
        } catch (FileNotFoundException e){
            logger.error("文件未找到或路径错误，请检查", e);
            throw e;
        } catch (IOException e) {
            logger.error("文件读取出错", e);
            throw e;
        }
    }

    public static boolean isEmpty(String str) {
        if (null == str || str.trim().length() == 0) {
            return true;
        }
        return false;
    }
}
