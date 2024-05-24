package me.waterarchery.abmf.logger;

public class Logger {

    private boolean debugMessages;

    public Logger(boolean debugMessages) {
        this.debugMessages = debugMessages;
    }

    public void log(String mes, LogSeverity severity) {
        if (severity == LogSeverity.NORMAL)
            log(mes);
        else if (severity == LogSeverity.WARN)
            warn(mes);
        else if (severity == LogSeverity.ERROR)
            error(mes);
        else if (severity == LogSeverity.DEBUG)
            debug(mes);
    }

    public void log(String mes) {
        System.out.println(mes);
    }

    public void debug(String mes) {
        if (debugMessages) {
            System.out.println("[DEBUG] " + mes);
        }
    }

    public void error(String mes) {
        System.out.println("[ERROR] " + mes);
    }

    public void warn(String mes) {
        System.out.println("[WARN] " + mes);
    }

    public void setDebugMessages(boolean debugMessages) {
        this.debugMessages = debugMessages;
    }

}
