package com.stackroute.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Topic {

    @Id
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private String topic;
    List<Question> questions;
}
