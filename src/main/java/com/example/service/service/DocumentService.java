package com.example.service.service;


import com.example.service.entiry.DocumentConverter;
import com.example.service.entiry.DocumentEntity;
import com.example.service.repository.DocumentRepository;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    public List<Document> getAllDocumentsForAi() {
        // 데이터베이스에서 모든 DocumentEntity를 가져옴
        List<DocumentEntity> entities = documentRepository.findAll();

    // DocumentEntity를 Spring AI Document로 변환
        return entities.stream()
                .map(DocumentConverter::convertToAiDocument)  // 변환 메서드 호출
                .collect(Collectors.toList());
    }
}
