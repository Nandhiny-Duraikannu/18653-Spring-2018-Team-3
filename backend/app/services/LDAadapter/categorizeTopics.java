package services.LDAadapter;
import DAO.*;

public class categorizeTopics implements categorize{
    private TopicsDAO topicsDAO;


    public categorizeTopics() {
        this.topicsDAO = new TopicsDAO();

    }

    @Override
    public String adaptLDA(int userId) {
        String topics = topicsDAO.getAllTopics(userId);
       return (topics);


    }
}
