package com.company;
import DAO.DAOConnect;
import DAO.Request;
import java.sql.SQLException;


public class Main {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(String.valueOf(Main.class));

    public static void main(String[] args) throws SQLException {
        logger.info("Started main");
        var manager = new DAOConnect();
        var connection = manager.Connect();
        var requests = new Request(connection);

        requests.getPlanetsWithLife();
        requests.getPlanetsWithMinRadius();
        requests.getSputnicsWithMaxRadius();
        requests.req("lsklf",853);
        manager.Disconnect(connection);
    }
}
