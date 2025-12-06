package dev.melvstein.vocabulary.mapper;

import dev.melvstein.vocabulary.dto.SaveVocabularyReqeustDto;
import dev.melvstein.vocabulary.dto.VocabularyDto;
import dev.melvstein.vocabulary.entity.User;
import dev.melvstein.vocabulary.entity.Vocabulary;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class VocabularyMapper {
    private final UserMapper userMapper;

    public VocabularyDto toDto(Vocabulary vocabulary) {
        if (vocabulary == null) {
            return null;
        }

        return VocabularyDto.builder()
                .id(vocabulary.getId())
                .word(vocabulary.getWord())
                .partOfSpeech(vocabulary.getPartOfSpeech())
                .englishDefinition(vocabulary.getEnglishDefinition())
                .tagalogDefinition(vocabulary.getTagalogDefinition())
                .englishSynonyms(vocabulary.getEnglishSynonyms())
                .tagalogSynonyms(vocabulary.getTagalogSynonyms())
                .englishAntonyms(vocabulary.getEnglishAntonyms())
                .tagalogAntonyms(vocabulary.getTagalogAntonyms())
                .exampleSentence(vocabulary.getExampleSentence())
                .createdAt(vocabulary.getCreatedAt())
                .updatedAt(vocabulary.getUpdatedAt())
                .build();
    }

    public Vocabulary toEntity(VocabularyDto dto) {
        if (dto == null) {
            return null;
        }

        return Vocabulary.builder()
                .id(dto.id())
                .word(dto.word())
                .partOfSpeech(dto.partOfSpeech())
                .englishDefinition(dto.englishDefinition())
                .tagalogDefinition(dto.tagalogDefinition())
                .englishSynonyms(dto.englishSynonyms())
                .tagalogSynonyms(dto.tagalogSynonyms())
                .englishAntonyms(dto.englishAntonyms())
                .tagalogAntonyms(dto.tagalogAntonyms())
                .exampleSentence(dto.exampleSentence())
                .createdAt(dto.createdAt())
                .updatedAt(dto.updatedAt())
                .build();
    }

    public List<VocabularyDto> toDtos(List<Vocabulary> vocabularies) {
        if (vocabularies == null) {
            return null;
        }

        return vocabularies.stream()
                .map(this::toDto)
                .toList();
    }

    public List<Vocabulary> toEntities(List<VocabularyDto> dtos) {
        if (dtos == null) {
            return null;
        }

        return dtos.stream()
                .map(this::toEntity)
                .toList();
    }

    public Vocabulary toVocabulary(SaveVocabularyReqeustDto dto, User user) {
        if (dto == null) {
            return null;
        }

        return Vocabulary.builder()
                .user(user)
                .word(dto.word())
                .partOfSpeech(dto.partOfSpeech())
                .englishDefinition(dto.englishDefinition())
                .tagalogDefinition(dto.tagalogDefinition())
                .englishSynonyms(dto.englishSynonyms())
                .tagalogSynonyms(dto.tagalogSynonyms())
                .englishAntonyms(dto.englishAntonyms())
                .tagalogAntonyms(dto.tagalogAntonyms())
                .exampleSentence(dto.exampleSentence())
                .build();
    }
}
