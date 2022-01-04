import java.io.Serializable;

public class Message implements Serializable {
    private Integer id;
    private String recipient;
    private final String sender;
    private String content;
    private boolean read;

    // Constructor
    public Message(Integer id, String recipient, String sender, String content, boolean read) {
        this.id = id;
        this.recipient = recipient;
        this.sender = sender;
        this.content = content;
        this.read = read;
    }
    // Setters
    public void setID(Integer id) {this.id = id;}
    public void setRecipient(String recipient) {this.recipient = recipient;}
    public void setContent(String content) {this.content = content;}
    public void setRead(boolean read) {this.read = read;}

    // Getters
    public Integer getID() {return id;}
    public String getRecipient() {return recipient;}
    public String getSender() {return sender;}
    public String getContent() {return content;}
    public boolean isRead() {return read;}
}
