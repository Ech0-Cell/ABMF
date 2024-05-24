package me.waterarchery.abmf;

import me.waterarchery.abmf.handlers.OracleHandler;
import me.waterarchery.abmf.logger.Logger;

public class ABMF {

    private static final Logger logger = new Logger(true);

    public static void main(String[] args) {
        // Updating balance of user with ID 0
        // for test purposes
        OracleHandler.getInstance().updateBalance(0, 1000);
    }

    public static Logger getLogger() {
        return logger;
    }

}