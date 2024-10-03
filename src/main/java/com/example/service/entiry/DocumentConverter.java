package com.example.service.entiry;


import org.springframework.ai.document.Document;

import java.util.HashMap;
import java.util.Map;

public class DocumentConverter {

    public static Document convertToAiDocument(DocumentEntity entity) {
        // Initialize the Map and add metadata
        Map<String, Object> data = new HashMap<>();
        data.put("title", entity.getTitle());  // title도 metadata에 추가
        data.put("content", entity.getContent());

        // Create Document with id, content, and metadata
        Document doc = new Document(String.valueOf(entity.getId()), entity.getContent(), data);
        return doc;
    }


}
