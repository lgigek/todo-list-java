package com.github.lgigek.models;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = Task.COLLECTION_NAME)
public class Task {

    public static final String COLLECTION_NAME = "tasks";

    @Id
    private ObjectId _id;
    @Indexed(unique = true)
    private String name;
    private String description;
    private String status;

}
