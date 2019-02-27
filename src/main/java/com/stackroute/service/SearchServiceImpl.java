package com.stackroute.service;

import com.stackroute.domain.Question;
import com.stackroute.domain.Topic;
import com.stackroute.repository.SearchRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service

//implementation of  SearchService//

public class SearchServiceImpl implements SearchService {
    private SearchRepository searchRepository;

    @Autowired
    public SearchServiceImpl(SearchRepository searchRepository) {
        this.searchRepository = searchRepository;
    }

    //Overrided method for saving searched questions//
    @Override
    public void saveTopic(Topic topic) { searchRepository.save(topic); }

    //Overrided method for getAllTopics//
    @Override
    public List<Topic> getAllTopics() {
        return searchRepository.findAll();
    }

    //Overrided method for getQuestionsByTopic//
    @Override
    public List<Topic> getQuestionsByTopic(String topic)  {
        return searchRepository.findByTopic(topic);
    }

    //Overrided method for getQuestion//

    @Override
    public List<Topic> getQuestion(String topic){
        return searchRepository.findByQuestions(topic);
    }

    /*
    for getting question object based on topic and question
     */
    @Override
    public List<Question> questionOfTopic(String topic, String question) {
        Topic topics = searchRepository.findById(topic).get();
        List<Question> questionLists = topics.getQuestions();
        List<Question> questions = new ArrayList<Question>();
        for (Question questionList: questionLists) {
            if(questionList.getQuestion().contains(question.toString())){
                questions.add(questionList);
            }
        }

        return questions;
    }
}
