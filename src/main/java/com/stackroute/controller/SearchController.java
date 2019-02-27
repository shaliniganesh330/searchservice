package com.stackroute.controller;

import com.stackroute.domain.Question;
import com.stackroute.domain.Topic;
import com.stackroute.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1")
@CrossOrigin(origins = "*")

public class SearchController {

    private SearchService searchService;

    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }


    //Displaying saved topic information.//

    @GetMapping("topics")
    public ResponseEntity<?> getAllTopics() {
        ResponseEntity responseEntity;
        try {
            responseEntity = new ResponseEntity<List<Topic>>(searchService.getAllTopics(), HttpStatus.OK);
        } catch (Exception ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("topic/{topic}")
    public ResponseEntity<?> getQuestion(@PathVariable String topic) {
        ResponseEntity responseEntity;
        try {

            responseEntity = new ResponseEntity<List<Topic>>(searchService.getQuestion(topic), HttpStatus.OK);

        } catch (Exception ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }


    @RequestMapping(path="/topicz/{topic}/{question}", method = RequestMethod.GET)
    public ResponseEntity<?> getQuestionInside(@PathVariable String topic,@PathVariable String question) {
        ResponseEntity responseEntity;
        try {

             return new ResponseEntity<List<Question>>(searchService.questionOfTopic(topic,question), HttpStatus.OK);

        } catch (Exception ex) {
            return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}