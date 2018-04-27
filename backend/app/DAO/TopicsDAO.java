package DAO;

import models.*;
import DAO.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.*;
import java.io.BufferedWriter;
import java.io.*;

import java.lang.Object;
import java.lang.Runtime;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import services.apiStates.ApiState;
import services.apiStates.ApprovedApi;

import java.util.List;
import play.libs.Json;

public class TopicsDAO implements DAOInterface{

    ApiDAO apiDAO = new ApiDAO();

    public String getAllTopics (int userId) {
        
        String parent = "./mallet-2.0.8/topics/";//my-data folder containes all the text files of API's containing individual descriptions
        String extension = ".txt";
        try{
            File file = new File(parent);
            deleteFiles(file);  
        }catch(IOException e){
            e.printStackTrace();
        }
        List<Api> apis = apiDAO.searchAPIs(userId);
        List<JsonNode> apisJson = new ArrayList<>();
        Iterator<Api> iterator = apis.iterator();
        while (iterator.hasNext()) {
            //apisJson.add(iterator.next().toJson());
            JsonNode api = iterator.next().toJson();
            String content = api.get("description").toString();
            String apiName = api.get("name").toString();
            //Create .txt files
            File newFile = new File(parent + apiName + extension);
             System.out.println(newFile + " file created in local!333!");
              if(!newFile.exists()) {
                System.out.println(newFile + " file created in local!!");
                 try {
                  FileWriter fw = new FileWriter(newFile.getAbsoluteFile());
                  BufferedWriter bw = new BufferedWriter(fw);
                  bw.write(content);
                  bw.close();
                  System.out.println(newFile + " file created in local!!");
                 }catch (IOException e){
                   System.out.println("IO Exception Thrown!!");
                   e.printStackTrace();
                  }
            }
        }

        //Run LDA

        String LDACommand1 = "./mallet-2.0.8/bin/mallet import-dir --input ./mallet-2.0.8/topics/ --output ./mallet-2.0.8/tutorial_new.mallet --keep-sequence --remove-stopwords";
        String LDACommand2 = "./mallet-2.0.8/bin/mallet train-topics  --input ./mallet-2.0.8/tutorial_new.mallet --num-topics 20 --optimize-interval 20 --output-state ./mallet-2.0.8/topic-state.gz --output-topic-keys ./mallet-2.0.8/tutorial_keys.txt --output-doc-topics ./mallet-2.0.8/tutorial_compostion.csv";

        try{
            Runtime rt = Runtime.getRuntime();
            Process pr1 = rt.exec(LDACommand1);
            Process pr2 = rt.exec(LDACommand2);
            int exitVal = pr1.waitFor();
            System.out.println("Process exitValue: " + exitVal);
        } catch(Throwable t){
            t.printStackTrace();
        }
        

        //Load data into topics table
        LoadComposition (userId);

        Topics topicsDB = new Topics();
        List<Topics> topics = Topics.find.query().where().eq("id", userId).findList();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");

        String comma = "";

        Iterator<Topics> topicIterator = topics.iterator();
        while (topicIterator.hasNext()) {
            Topics currentTopic = topicIterator.next();
            stringBuffer.append(comma);
            comma = ", ";
            stringBuffer.append(currentTopic.toJSON());
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public void deleteFiles(File file) throws IOException {
      try{
          if (file.isDirectory())
              for (File f : file.listFiles())
                deleteFiles(f);
          else
              file.delete();
      } catch(IOException e){
          e.printStackTrace();
      }
      
    }

    public void LoadComposition (int userId) {
        String csvFile = "./mallet-2.0.8/tutorial_compostion.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = "\t";// use tab as separator
        try {

              Topics topics = new Topics();
              topics.deleteUser(userId);            
              br = new BufferedReader(new FileReader(csvFile));
              while ((line = br.readLine()) != null) {
                  String[] apiCombo = line.split(cvsSplitBy);
                  String apiName = apiCombo[1];
                  int r1 = apiName.lastIndexOf( '/' );
                  int r2 = apiName.lastIndexOf( '.' );
                  String newApiName = apiName.substring(r1+1, r2-1);
                  newApiName = newApiName.replace("%20", " ");
                  newApiName = newApiName.replace("%22", "");
                  newApiName = newApiName.replace("%2", "");
                  System.out.println("API Names : "+newApiName);
                  //Get corresponding topic of each API
                  int topicNum = 0;
                  double probValFinal = Double.parseDouble(apiCombo[2]);
                  for (int i = 3; i < apiCombo.length; i++) {
                      double probVal = Double.parseDouble(apiCombo[i]);
                      if(probVal>probValFinal) {
                          topicNum = i-2;
                          probValFinal = probVal;
                      }
                  }
                String topicNumber = "Topic "+ topicNum;
                    //Inserting values into database table
                if(newApiName.length()>0){
                  Topics topic = new Topics();
                  topic.setParameters(userId, newApiName, topicNumber);
                  topic.save();
                }
            }
            
         } catch (Exception e) {
             e.printStackTrace();
         } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //USER DAO
  public String getAllUsers(){
    return null;
  }

  public User getUserByUserId(int userId){
    return null;
  }
  public User updateUserProfile(int userId, String name, String email, String phoneNumber, String notificationMethod){
    return null;
  }
  public User getUserByUsername(String username){
    return null;
  }
  public void ensureOneAdmin(){
  }

  //API DAO 
  public List<Api> getVersionsForApi(int apiId){
    return null;
  }
  public void approveApi(int apiId){
  }
  public Api getById(int apiID){
    return null;
  }
  public List<Api> getAll(){
    return null;
  }
  public List<Api> searchAPIs(int userId){
    return null;
  }
  public List<Api> searchAPIs(String searchParam, String type){
    return null;
  }
  public Api getApiById(int id){
    return null;
  }

  //Log Message DAO
  public void writeSubmitApiLogMessage(String username, String name){
  }
  public List<LogMessage> getAllLogMessages(){
    return null;
  }
  public User createNewUser(String username, String password, String securityQuestion, String answer){
    return null;
  }
  public void writeSearchApiLogMessage(String username, String searchParam){
  }
  public void writeViewApiLogMessage(String username, String apiname){
    
  }
  public List<Mashup> getAllMashups(){
    return null;
  }
}
