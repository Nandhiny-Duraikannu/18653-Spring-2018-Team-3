package UIForm;

public class Mashup {

    private String name;

    private String description;
    private String user_id;

    private String type;

    private String status;

    private String[] apiIds;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String[] getApiIds() {

        return apiIds;
    }

    public void setApiIds(String[] apiIds) {
        this.apiIds = apiIds;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Mashup{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", user_id='" + user_id + '\'' +
                ", apiIds='" + apiIds + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}