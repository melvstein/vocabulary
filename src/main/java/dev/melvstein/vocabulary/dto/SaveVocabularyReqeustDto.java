package dev.melvstein.vocabulary.dto;

public record SaveVocabularyReqeustDto(
        String word,
        String partOfSpeech,
        String englishDefinition,
        String tagalogDefinition,
        String englishSynonyms,
        String tagalogSynonyms,
        String englishAntonyms,
        String tagalogAntonyms,
        String exampleSentence) {
}
