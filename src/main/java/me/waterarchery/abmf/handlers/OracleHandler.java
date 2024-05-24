package me.waterarchery.abmf.handlers;

import me.waterarchery.abmf.ABMF;
import me.waterarchery.abmf.logger.Logger;
import me.waterarchery.abmf.models.DatabaseInfo;
import org.jetbrains.annotations.Nullable;

import java.sql.*;

public class OracleHandler {

    private static OracleHandler instance;
    private Connection con;

    public static synchronized OracleHandler getInstance() {
        if (instance == null)
            instance = new OracleHandler();
        return instance;
    }

    private OracleHandler() { }

    public void updateBalance(long userID, double newBalance) {
        Logger logger = ABMF.getLogger();
        try {
            Connection con = getConnection();
            String query = "UPDATE UserCredentials SET balance = ? WHERE user_id = ?";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setDouble(1, newBalance);
            statement.setLong(2, userID);
            statement.executeUpdate();
            logger.log("Balance of " + userID + " is successfully updated!");
        }
        catch (SQLException ex) {
            logger.error("Error happened while updating user balance of: " + userID);
        }
    }

    public @Nullable Connection getConnection() {
        try{
            if (con != null && !con.isClosed())
                return con;
            String service = "FREEPDB1";
            con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@//" + DatabaseInfo.HOST + ":1521/" + service, DatabaseInfo.USERNAME,DatabaseInfo.PASSWORD);
            return con;
        }catch(SQLException e){
            e.printStackTrace();
        }

        return null;
    }

}
