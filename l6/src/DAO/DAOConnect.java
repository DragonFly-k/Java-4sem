package DAO;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOConnect {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(String.valueOf(DAOConnect.class));

    public java.sql.Connection Connect() {
        java.sql.Connection con = null;

        try {
            String dbURL = "jdbc:sqlserver://DESKTOP-M01CN9D;databaseName=Planet;integratedSecurity=false;"
                    + "encrypt=false;trustServerCertificate=true";

            con = DriverManager.getConnection(dbURL, "sa", "123456");
            logger.info("ESTABLISHED CONNECTION WITH MSSQL");

        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return con;

    }

    public void Disconnect(java.sql.Connection con) {
        try
        {
            con.close();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        logger.info("Disconnected from mssql");
    }
}
