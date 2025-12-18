import java.time.LocalDateTime;

public class QueuePosition {

    private Long id;
    private Token token;
    private Integer position;
    private LocalDateTime updatedAt;

    // Default Constructor
    public QueuePosition() {
    }

    // Parameterized Constructor
    public QueuePosition(Long id, Token token, Integer position, LocalDateTime updatedAt) {
        this.id = id;
        this.token = token;
        this.position = position;
        this.updatedAt = updatedAt;
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

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
