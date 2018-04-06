package UIForm;

public class UserForm {
    private int id;
    private String name;
    private String username;
    private String email;
    private String phoneNumber;
    private String notificationMethod;

    public String getName() {
        if (this.name != null)
           return name;
        else {
            return this.username;
        }
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public void setName(String name) { this.name = name; }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNotificationMethod() {
        return notificationMethod;
    }

    public void setNotificationMethod(String notificationMethod) {
        this.notificationMethod = notificationMethod;
    }

    @Override
    public String toString() {
        return "UserForm{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", notificationMethod='" + notificationMethod + '\'' +
                '}';
    }
}
