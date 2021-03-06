package UIForm;

import java.util.ArrayList;
import java.util.List;

public class ApiForm {

    private int id;
    private String name;
    private String type;
    private String apiIds;
    private String homepage;
    private String endpoint;
    private String version;
    private String scope;
    private String description;
    private String email;
    private String user_id;
    private String status;
    private List<Comment> comments = new ArrayList<Comment>();

    public int getId() { return id; }

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

    public String getApiIds() {
        return apiIds;
    }

    public void setApiIds(String apiIds) {
        this.apiIds = apiIds;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    public void addComment (Comment newComment) {
        comments.add(newComment);
    }

    public List<Comment> getComments () { return comments; }

    @Override
    public String toString() {
        return "ApiForm{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", apiIds='" + apiIds + '\'' +
                ", homepage='" + homepage + '\'' +
                ", endpoint='" + endpoint + '\'' +
                ", version='" + version + '\'' +
                ", scope='" + scope + '\'' +
                ", description='" + description + '\'' +
                ", email='" + email + '\'' +
                ", user_id='" + user_id + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}