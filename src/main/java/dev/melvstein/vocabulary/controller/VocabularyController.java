package dev.melvstein.vocabulary.controller;

import dev.melvstein.vocabulary.dto.SaveVocabularyReqeustDto;
import dev.melvstein.vocabulary.dto.VocabularyDto;
import dev.melvstein.vocabulary.entity.User;
import dev.melvstein.vocabulary.entity.Vocabulary;
import dev.melvstein.vocabulary.service.UserService;
import dev.melvstein.vocabulary.service.VocabularyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vocabularies")
@RequiredArgsConstructor
public class VocabularyController {
    private final VocabularyService vocabularyService;
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<VocabularyDto>> getAllVocabularies() {
        List<Vocabulary> vocabularies = vocabularyService.getAllVocabularies();

        if (!vocabularies.isEmpty()) {
            return ResponseEntity.ok(vocabularyService.toDtos(vocabularies));
        }

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<VocabularyDto>> getAllVocabulariesByUserId(@PathVariable Long userId) {
        List<Vocabulary> vocabularies = vocabularyService.getAllVocabulariesByUserId(userId);

        if (!vocabularies.isEmpty()) {
            return ResponseEntity.ok(vocabularyService.toDtos(vocabularies));
        }

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{userId}")
    public ResponseEntity<VocabularyDto> saveVocabulary(
            @PathVariable Long userId,
            @RequestBody SaveVocabularyReqeustDto dto
    ) {
        User user = userService.getUserById(userId);

        if (user == null) {
            return ResponseEntity.badRequest().build();
        }

        Vocabulary vocabulary = vocabularyService.toVocabulary(dto, user);
        Vocabulary savedVocabulary = vocabularyService.saveVocabulary(vocabulary);

        return ResponseEntity.ok(vocabularyService.toDto(savedVocabulary));
    }

    @DeleteMapping("/{vocabularyId}")
    public ResponseEntity<Void> deleteVocabularyById(@PathVariable Long vocabularyId) {
        Vocabulary vocabulary = vocabularyService.getVocabularyById(vocabularyId);

        if (vocabulary == null) {
            return ResponseEntity.notFound().build();
        }

        vocabularyService.deleteVocabularyById(vocabularyId);
        return ResponseEntity.noContent().build();
    }
}
