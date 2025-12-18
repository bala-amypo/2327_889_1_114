import java.time.LocalDateTime;

public class TokenLog {

    private Long id;
    private Token token;
    private String logMessage;
    private LocalDateTime loggedAt;

    // Default Constructor
    public TokenLog() {
    }

    // Parameterized Constructor
    public TokenLog(Long id, Token token, String logMessage, LocalDateTime loggedAt) {
        this.id = id;
        this.token = token;
        this.logMessage = logMessage;
        this.loggedAt = loggedAt;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public String getLogMessage() {
        return logMessage;
    }

    public void setLogMessage(String logMessage) {
        this.logMessage = logMessage;
    }

    public LocalDateTime getLoggedAt() {
        return loggedAt;
    }

    public void setLoggedAt(LocalDateTime loggedAt) {
        this.loggedAt = loggedAt;
    }
}
