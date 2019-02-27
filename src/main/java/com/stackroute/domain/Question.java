package com.stackroute.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties()

public class Question {
    private String question;
    private String description;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    @JsonProperty
    private int upvotes;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    @JsonProperty
    private long timestamp;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    @JsonProperty
    private int downvote;
    List<Comments> comments;
    List<Answer> answers;

}
