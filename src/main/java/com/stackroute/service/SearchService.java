package com.stackroute.service;

import com.stackroute.domain.Question;
import com.stackroute.domain.Topic;

import java.util.List;

public interface SearchService {
    public void saveTopic(Topic topic) ;
    public List<Topic> getAllTopics();
    public List<Topic> getQuestionsByTopic(String topic);
    public List<Topic> getQuestion(String topic);
    public List<Question> questionOfTopic(String topic,String question);
}
