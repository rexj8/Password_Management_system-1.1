package classes;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Pswrd {
    Encryption enc = new Encryption();

    public void addPswrd(String pswrd) {

        String hashtext = enc.ceaserCypherEncode(pswrd);

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pms?autoReconnect=true&useSSL=false", "root", "root");
            String qry = "INSERT INTO CREDENTIALS(PSWD) VALUES(?);";
            PreparedStatement pstmt = con.prepareStatement(qry);

            pstmt.setString(1, hashtext);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void delPswrd(String pswrd) {

    }

    public void showPswrd(String pswrd) {

    }

}
