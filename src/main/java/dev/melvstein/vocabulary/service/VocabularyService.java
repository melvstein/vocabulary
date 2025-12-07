package dev.melvstein.vocabulary.service;

import dev.melvstein.vocabulary.dto.SaveVocabularyReqeustDto;
import dev.melvstein.vocabulary.dto.VocabularyDto;
import dev.melvstein.vocabulary.entity.User;
import dev.melvstein.vocabulary.entity.Vocabulary;
import dev.melvstein.vocabulary.mapper.VocabularyMapper;
import dev.melvstein.vocabulary.repository.VocabularyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VocabularyService {
    private final VocabularyRepository vocabularyRepository;
    private final VocabularyMapper vocabularyMapper;

    public List<Vocabulary> getAllVocabularies() {
        return vocabularyRepository.findAll();
    }

    public Vocabulary getVocabularyById(Long id) {
        return vocabularyRepository.findById(id).orElse(null);
    }

    public List<Vocabulary> getAllVocabulariesByUserId(Long id) {
        return vocabularyRepository.findAllByUserId(id);
    }

    public Vocabulary saveVocabulary(Vocabulary vocabulary) {
        return vocabularyRepository.save(vocabulary);
    }

    public void deleteVocabularyById(Long id) {
        vocabularyRepository.deleteById(id);
    }

    public Vocabulary toEntity(VocabularyDto dto) {
        return vocabularyMapper.toEntity(dto);
    }

    public VocabularyDto toDto(Vocabulary entity) {
        return vocabularyMapper.toDto(entity);
    }

    public List<VocabularyDto> toDtos(List<Vocabulary> entities) {
        return vocabularyMapper.toDtos(entities);
    }

    public Vocabulary toVocabulary(SaveVocabularyReqeustDto dto, User user) {
        return vocabularyMapper.toVocabulary(dto, user);
    }
}
