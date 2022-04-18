import java.sql.Statement;
import java.sql.*;
import java.io.BufferedReader;
import java.io.FileReader;
public class Data {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/Registration";
        String user="root";
        String password="Mehul@1234";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(url, user, password);
            Statement st=con.createStatement();
            st.execute("CREATE TABLE home(Sell int,List int,Livings int,Rooms int,Beds int,Baths int,Age int,Acres float,Taxes int);");
            String sql ="INSERT INTO home VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stm = con.prepareStatement(sql);                                               
            String line;
            BufferedReader br =new BufferedReader(new FileReader("homes.csv"));
            br.readLine();
            while((line = br.readLine()) != null){
                String[] data=line.split(",");
                stm.setInt(1, Integer.parseInt(data[0].trim()));
                stm.setInt(2, Integer.parseInt(data[1].trim()));
                stm.setInt(3, Integer.parseInt(data[2].trim()));
                stm.setInt(4, Integer.parseInt(data[3].trim()));
                stm.setInt(5, Integer.parseInt(data[4].trim()));
                stm.setInt(6, Integer.parseInt(data[5].trim()));
                stm.setInt(7, Integer.parseInt(data[6].trim()));
                stm.setFloat(8, Float.parseFloat(data[7].trim()));
                stm.setInt(9, Integer.parseInt(data[8].trim()));
                stm.addBatch();
            }
            stm.executeBatch();                     
            con.close();
            System.out.println("Data Inserted Successfully");
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}