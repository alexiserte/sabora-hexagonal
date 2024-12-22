package com.sabora.server.DTOs;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.sabora.server.Models.AnswerWritingQuestion;
import com.sabora.server.Models.MultipleAnswerQuestion;
import com.sabora.server.Models.RangeQuestion;
import com.sabora.server.Models.UniqueAnswerQuestion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = RangeQuestionDTO.class, name = "RANGE"),
        @JsonSubTypes.Type(value = MultipleAnswerQuestionDTO.class, name = "MULTIPLE_ANSWER"),
        @JsonSubTypes.Type(value = UniqueAnswerQuestionDTO.class, name = "UNIQUE_ANSWER"),
        @JsonSubTypes.Type(value = AnswerRedactionQuestionDTO.class, name = "REDACTION")
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class QuestionDTO {
    private int id;
    private String question;
}