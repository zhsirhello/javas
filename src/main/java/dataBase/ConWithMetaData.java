package dataBase;


import java.sql.*;

/**
 * @author zhou
 * @Time 2019.1.3
 * @decribe 使用connection获取数据库中表的元数据。以下是获取所有列名,以及主键
 */
public class ConWithMetaData {
    public static void main(String[] args){
        Connection con;
       //驱动程序名
        String driver = "com.mysql.jdbc.Driver";
       //URL指向要访问的数据库名mydata
        String url = "jdbc:mysql://localhost:3306/test";
        //MySQL配置时的用户名
        String user = "root";
        //MySQL配置时的密码
        String password = "123456";
        try {
            //加载驱动程序
            Class.forName(driver);
            //1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url,user,password);
            if(!con.isClosed()) {
                System.out.println("Succeeded connecting to the Database!");
                DatabaseMetaData metaData = con.getMetaData();
                ResultSet resultSet = metaData.getColumns(null, null, "people", "%");
                while(resultSet.next()){
                    System.out.println(resultSet.getString("COLUMN_NAME"));
                }
                System.out.println("===============================");
                ResultSet PKset = metaData.getPrimaryKeys(null, "test", "people");
                while (PKset.next()){
                    System.out.println(PKset.getString("COLUMN_NAME"));
                }

            }
            /*//2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            //要执行的SQL语句
            String sql = "select * from department";
            //3.ResultSet类，用来存放获取的结果集！！
            ResultSet rs = statement.executeQuery(sql);
            System.out.println("-----------------");
            System.out.println("执行结果如下所示:");
            System.out.println("-----------------");
            System.out.println("姓名" + "\t" + "职称");
            System.out.println("-----------------");

            String job = null;
            String id = null;
            while(rs.next()){
                //获取stuname这列数据
                job = rs.getString("did");
                //获取stuid这列数据
                id = rs.getString("dtype");

                //输出结果
                System.out.println(id + "\t" + job);
            }
            rs.close();
            con.close();*/
        } catch(ClassNotFoundException e) {
            //数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        } catch(SQLException e) {
            //数据库连接失败异常处理
            e.printStackTrace();
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            System.out.println("结束");
        }
    }
}
