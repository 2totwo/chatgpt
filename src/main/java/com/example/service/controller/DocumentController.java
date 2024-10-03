package com.example.service.controller;


import com.example.service.service.DocumentService;
import org.springframework.ai.document.Document;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @GetMapping("/documents")
    public String getDocuments(Model model) {
        // Spring AI Document 리스트를 가져와 모델에 추가
        List<Document> documents = documentService.getAllDocumentsForAi();
        model.addAttribute("documents", documents);
        return "doc";
    }
}
