package me.waterarchery.abmf.handlers;

public class KafkaHandler {

    private static KafkaHandler instance;

    public static synchronized KafkaHandler getInstance() {
        if (instance == null)
            instance = new KafkaHandler();
        return instance;
    }

    private KafkaHandler() { }

    public void getMessage() {
        // TODO GET MESSAGE FROM KAFKA AND REDIRECT IT TO ORACLE
    }

}
