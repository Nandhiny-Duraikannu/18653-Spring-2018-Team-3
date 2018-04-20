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

public class TopicsDAO {

    ApiDAO apiDAO = new ApiDAO();

    public String getAllTopics (int userId) {
        
        String parent = "./mallet-2.0.8/topics/";//my-data folder containes all the text files of API's containing individual descriptions
        String extension = ".txt";
        int count = 1;
        List<Api> apis = apiDAO.searchAPIs(userId);
        List<JsonNode> apisJson = new ArrayList<>();
        Iterator<Api> iterator = apis.iterator();
        while (iterator.hasNext()) {
            //apisJson.add(iterator.next().toJson());
            JsonNode api = iterator.next().toJson();
            String content = api.get("description").toString();
            String apiName = api.get("name").toString();
            //Create .txt files
            File newFile = new File(parent, apiName + extension);
              if(!newFile.exists()) {
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

        String LDACommand1 = "/Users/arihanth/Desktop/Assignments/18653-SAD/Team-Project/18653-Spring-2018-Team-3/backend/mallet-2.0.8/bin/mallet import-dir --input ./mallet-2.0.8/topics/ --output tutorial_new.mallet --keep-sequence --remove-stopwords";
        String LDACommand2 = "/Users/arihanth/Desktop/Assignments/18653-SAD/Team-Project/18653-Spring-2018-Team-3/backend/mallet-2.0.8/bin/mallet train-topics  --input tutorial_new.mallet --num-topics 20 --optimize-interval 20 --output-state topic-state.gz --output-topic-keys tutorial_keys.txt --output-doc-topics tutorial_compostion.csv";

        try{
            Runtime rt = Runtime.getRuntime();
            Process pr1 = rt.exec(LDACommand1);
            Process pr2 = rt.exec(LDACommand2);
            int exitVal = pr2.waitFor();
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

    public void LoadComposition (int userId) {
        String csvFile = "./mallet-2.0.8/apiLDAtutorial_compostion.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = "\t";// use tab as separator
        int c = 0;
        try {
            
              br = new BufferedReader(new FileReader(csvFile));
              while ((line = br.readLine()) != null) {
                  String[] apiCombo = line.split(cvsSplitBy);
                  c++;
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
                Topics topic = new Topics();
                topic.setParameters(userId, apiCombo[1], topicNumber);
                topic.save();
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
}
