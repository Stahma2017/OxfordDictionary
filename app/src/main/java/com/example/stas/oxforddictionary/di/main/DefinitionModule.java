package com.example.stas.oxforddictionary.di.main;

import com.example.stas.oxforddictionary.data.mapper.definition.DefinitionEntityDataMapper;
import com.example.stas.oxforddictionary.data.mapper.example.ExampleEntityDataMapper;
import com.example.stas.oxforddictionary.data.mapper.synonym.SynonymEntityDataMapper;
import com.example.stas.oxforddictionary.data.network.OxfordApi;
import com.example.stas.oxforddictionary.data.repository.DefinitionRepositoryImp;
import com.example.stas.oxforddictionary.domain.DefinitionRepository;
import com.example.stas.oxforddictionary.domain.interactor.DefinitonInteractor;

import dagger.Module;
import dagger.Provides;

@Module
public class DefinitionModule {
    @Provides
    DefinitonInteractor provideDefinitionInteractor(DefinitionRepository repository){
        return new DefinitonInteractor(repository);
    }

    @Provides
    DefinitionRepository provideDefinitionRepository(OxfordApi oxfordApi,
                                                     DefinitionEntityDataMapper definitionEntityDataMapper,
                                                     SynonymEntityDataMapper synonymEntityDataMapper,
                                                     ExampleEntityDataMapper exampleEntityDataMapper){
        return new DefinitionRepositoryImp(oxfordApi, definitionEntityDataMapper,
                synonymEntityDataMapper,
                exampleEntityDataMapper);
    }

    //todo get sure about injecting inner classes of mapper
    @Provides
    DefinitionEntityDataMapper provideDefinitionMapper(){
        return new DefinitionEntityDataMapper();
    }

    @Provides
    SynonymEntityDataMapper provideSynonymMapper(){
        return new SynonymEntityDataMapper();
    }

    @Provides
    ExampleEntityDataMapper provideExampleMapper(){
        return new ExampleEntityDataMapper();
    }

}
