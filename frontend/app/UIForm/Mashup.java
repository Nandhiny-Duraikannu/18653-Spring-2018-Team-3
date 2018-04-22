package UIForm;

public class Mashup {

    private int id;
    private String name;
    private String description;
    private String user_id;
    private String type;
    private String status;
    private String homepage;
    private String endpoint;
    private String email;
    private String scope;
    private String version;

    private String[] apiIds;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
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