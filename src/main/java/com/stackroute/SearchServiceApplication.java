//package com.stackroute;
//
//import com.google.gson.Gson;
//import com.stackroute.domain.Question;
//import com.stackroute.domain.Topic;
//import com.stackroute.domain.User;
//import com.stackroute.repository.SearchRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.nio.charset.StandardCharsets;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//import java.util.List;
//import java.io.IOException;
//
//@SpringBootApplication
//public class SearchServiceApplication implements CommandLineRunner{
//	@Autowired
//	SearchRepository searchRepository;
//
//	public static void main(String[] args) {
//		SpringApplication.run(SearchServiceApplication.class, args);
//	}
//
//	@Override
//	public void run(String... args) throws Exception {
//		BufferedReader br = null;
//		Gson gson = new Gson();
//
//		try {
//			br = new BufferedReader(new FileReader(("./Search.json")));
//			// convert json string to object
//			Topic topic = gson.fromJson(br, Topic.class);
//			searchRepository.save(topic);
//			System.out.println("Question Name: " + topic.getTopic());
//			System.out.println(topic.getQuestions());
//
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//
//		}
//	}
//}

//---------------------------------------------------------
//public class SearchServiceApplication implements CommandLineRunner {
//	@Autowired
//	SearchRepository  searchRepository;
//
//	public static void main(String[] args) {
//		SpringApplication.run(SearchServiceApplication.class, args);
//	}
//
//	@Override
//	public void run(String...args) throws Exception{
//		List<Topic> topics= readQuestionsFromCSV("Questions.txt");
//		for (Topic q : topics) {
//			System.out.println(searchRepository.save(q));
//		}
//	}
//
//	public static List<Topic> readQuestionsFromCSV(String fileName){
//		List<Topic> topics = new ArrayList<>();
//		Path pathToFile = Paths.get(fileName);
//		// create an instance of BufferedReader
//		// using try with resource, Java 7 feature to close resources
//		try (BufferedReader br = Files.newBufferedReader(pathToFile,
//				StandardCharsets.US_ASCII)) {
//
//			// read the first line from the text file
//			String line = br.readLine();
//
//			// loop until all lines are read
//			while (line != null) {
//
//				// use string.split to load a string array with the values from
//				// each line of
//				// the file, using a comma as the delimiter
//				String[] attributes = line.split(",");
//
//				Topic topic = createTopic(attributes);
//
//				// adding book into ArrayList
//				topics.add(topic);
//
//				// read next line before looping
//				// if end of file reached, line would be null
//				line = br.readLine();
//			}
//
//		} catch (IOException ioe) {
//			System.out.println(ioe);
//		}
//
//		return topics;
//	}
//
//	private static Topic createTopic(String[] metadata) throws NullPointerException{
//		String question = metadata[0];
//		String topics=metadata[1];
//            if(metadata[1].contains("$")){
//                String topic[]=metadata[1].split("$");
//                topics = Arrays.asList(topic);
//            }
//            else {
//                topics = new ArrayList<>();
//                topics.add(metadata[1]);
//            }
//		long timestamp = Long.parseLong(metadata[2]);
//		User user = new User(metadata[3],metadata[4],metadata[5]);
//        int price = Integer.parseInt(metadata[1]);
//        String author = metadata[2];
//    public Question(final String question, final String description, final List<String> topics, final int upvotes, final long timestamp, final int downvotes, final User user, final List<Comment> comment, final List<Answer> answer) {
//		Question questions=new Question(question,null,0,timestamp,0,null,null);
//		// create and return question of this metadata
//            private String question;
//            private String description;
//            private int upvotes;
//            private long timestamp;
//            private int downvotes;
//            List<Answers> answers;
//            List<Comments> comments;
//		List<Question> questionList=new ArrayList<>();
//		questionList.add(questions);
//		return new Topic(topics,questionList);
//	}
//}
//-------------------------------------------------------
package com.stackroute;

import com.stackroute.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import com.google.gson.GsonBuilder;

@SpringBootApplication
public class SearchServiceApplication {
    @Autowired
    SearchRepository searchRepository;

    public static void main(String[] args) {
        SpringApplication.run(SearchServiceApplication.class, args);
    }

//	@Override
//	public void run(String... args) throws Exception {
//		BufferedReader br = null;
//		Gson gson = new Gson();
//
//		try {
//			br = new BufferedReader(new FileReader(("./Search.json")));
//			// convert json string to object
//			Topic topic = gson.fromJson(br, Topic.class);
////			searchRepository.save(topic);
//			System.out.println("Question Name: " + topic.getTopic());
//			System.out.println(topic.getQuestions());
//
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//
//		}
//	}
}


