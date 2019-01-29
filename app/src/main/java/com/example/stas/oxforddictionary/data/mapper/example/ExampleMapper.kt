package com.example.stas.oxforddictionary.data.mapper.example

import com.example.stas.oxforddictionary.data.entity.example.ExampleResponseEntity
import com.example.stas.oxforddictionary.data.entity.example.LexicalEntryEntity
import com.example.stas.oxforddictionary.domain.model.example.ExampleResult
import com.example.stas.oxforddictionary.domain.model.example.LexicalEntry

fun ExampleResponseEntity.toModel(): ExampleResult {
    val from = results.get(0)
   return ExampleResult(
            id = from.id,
            language = from.language,
            lexicalEntries = mapLexicalEntries(from.lexicalEntries),
            type = from.type,
            word = from.word)
}

fun mapLexicalEntries(fromList: List<LexicalEntryEntity> ) {
    val lexicalEntries = listOf<LexicalEntry>()
    fromList.forEach{

    }

}

fun LexicalEntryEntity.mapLexicalEntry() = {


}

        LexicalEntry(
        language = this.language,
        lexicalCategory = this.lexicalCategory,
        senteces = this.sentences,
        text = this.text

)


