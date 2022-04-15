package DAO;
import Planet.Planet;
import Planet.Sputnik;
import org.apache.log4j.BasicConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Request {
    Connection connection = null;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(String.valueOf(Request.class));

    public Request(Connection connection) {
        this.connection = connection;
    }

    public ResultSet SendRequest(String strSql) {
        try {
            var query = connection.createStatement();
            ResultSet rs = query.executeQuery(strSql);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void getPlanetsWithLife() throws SQLException {
        var rs = SendRequest("select *\n" +
                "from Планеты join Спутники\n" +
                "on Планеты.Спутники = Спутники.Название \n" +
                "and Планеты.Наличие_жизни = 1\n");
        Statement statement = connection.createStatement();
        while (rs.next()) {
            Planet planet = new Planet();
            Sputnik sputnik = new Sputnik();
            planet.setName(rs.getString(1));
            planet.setRadius(rs.getFloat(2));
            planet.setTemperature(rs.getFloat(3));
            planet.setAtmosphere(rs.getBoolean(4));
            planet.setLife(rs.getBoolean(5));
            planet.setSputnik(rs.getString(6));
            System.out.println("\n" + planet + "\n" + sputnik + "\n");
        }
        System.out.println();
        logger.info("SQl request done");
    }

    public void getPlanetsWithMinRadius() throws SQLException {
        var rs = SendRequest("select top(1) * \n" +
                "from Планеты join Спутники \n" +
                "on Планеты.Спутники = Спутники.Название \n" +
                "order by Планеты.Радиус asc\n");
        Statement statement = connection.createStatement();
        ArrayList<Sputnik> sputniks = new ArrayList<>();
        Planet planet = new Planet();
        while (rs.next()) {
            Sputnik sputnik = new Sputnik();
            planet.setName(rs.getString(1));
            planet.setRadius(rs.getFloat(2));
            planet.setTemperature(rs.getFloat(3));
            planet.setAtmosphere(rs.getBoolean(4));
            planet.setLife(rs.getBoolean(5));
            planet.setSputnik(rs.getString(6));

            sputnik.setName(rs.getString(7));
            sputnik.setRadius(rs.getFloat(8));
            sputnik.setDistance(rs.getString(9));
            sputniks.add(sputnik);
            System.out.println(planet + "\n" + sputnik + "\n");
        }
        System.out.println();
        logger.info("SQl request done");
    }

    public void getSputnicsWithMaxRadius() throws SQLException {
        var rs = SendRequest("select top(1) *\n" +
                "from Планеты join Спутники \n" +
                "on Планеты.Спутники = Спутники.Название \n" +
                "order by Спутники.Радиус desc\n");
        Statement statement = connection.createStatement();
        while (rs.next()) {
            Planet planet = new Planet();
            planet.setName(rs.getString(1));
            planet.setRadius(rs.getFloat(2));
            planet.setTemperature(rs.getFloat(3));
            planet.setAtmosphere(rs.getBoolean(4));
            planet.setLife(rs.getBoolean(5));
            planet.setSputnik(rs.getString(6));
            System.out.println(planet + "\n");
        }
        System.out.println();
        logger.info("SQl request done");
    }

    public void req(String Name, float num) throws SQLException {
        var allSP = new ArrayList<String>();
        var rs = SendRequest("SELECT * from Спутники");
        while (rs.next()) {
            allSP.add(rs.getString(1));
        }
        var st = connection.prepareStatement("insert into Спутники VALUES(?, ?, ?)");

            st.setFloat(3, num);
            st.setFloat(2, num);
            st.setString(1, Name);
            st.executeUpdate();

        logger.info("SQl request done");
    }

}
