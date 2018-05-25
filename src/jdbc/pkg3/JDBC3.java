
package jdbc.pkg3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class JDBC3 {

    
    public static void main(String[] args) {
     
     
        

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/depotakipvt","root","199144");
            
            
            if(con.isClosed())
                System.out.println("Kapalı");
            else
                System.out.println("Acık");
                
            String sorgu = "SELECT * FROM Ogrenci";
            stmt = con.createStatement();
            
            rs = stmt.executeQuery(sorgu);
            
            if(!rs.next())
            {
                System.out.println("KAYIT YOK");
                return;
            }else{
                do{
                System.out.println(rs.getString("Numara") + "- "+rs.getString("Adi")+" - "+rs.getString("Bolum"));
                }while(rs.next());
            }
            
            
        }catch(Exception ew){
        
            System.out.println("HATA : "+ew);
        }finally{
                
            if((stmt != null) || rs != null || con != null){
                
                try{
                    stmt.close();
                    rs.close();
                    con.close();
                }catch(Exception go){
                
                }
            }
        }
        
    }
    
}
