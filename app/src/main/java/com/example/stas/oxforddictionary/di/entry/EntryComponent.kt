package com.example.stas.oxforddictionary.di.entry

import com.example.stas.oxforddictionary.domain.DefinitionRepository
import com.example.stas.oxforddictionary.domain.usecase.DefinitonInteractor
import com.example.stas.oxforddictionary.domain.usecase.definition.SaveWordUseCase
import com.example.stas.oxforddictionary.presentation.presenter.entry.EntryPresenter
import com.example.stas.oxforddictionary.presentation.view.base.ErrorHandler
import com.example.stas.oxforddictionary.presentation.view.entry.EntryContract
import com.example.stas.oxforddictionary.presentation.view.entry.EntryFragment
import com.example.stas.oxforddictionary.presentation.view.entry.adapter.DefinitionAdapter
import com.example.stas.oxforddictionary.presentation.view.entry.adapter.DefinitionExportVisitor
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import io.reactivex.disposables.CompositeDisposable

@Subcomponent(modules = [EntryModule::class])
interface EntryComponent {
    fun injectEntryFragment(entryFragment: EntryFragment)
}

@Module
class EntryModule{
    @Provides
    fun provideDefinitionAdapter(definitionExporter: DefinitionExportVisitor): DefinitionAdapter =
        DefinitionAdapter(definitionExporter)

    @Provides
    fun provideDefinitionVisitor(): DefinitionExportVisitor =
            DefinitionExportVisitor()

    @Provides
    fun provideEntryPresenter(interactor: DefinitonInteractor, compositeDisposable: CompositeDisposable,
                              errorHandler: ErrorHandler, saveWordUseCase: SaveWordUseCase): EntryContract.Presenter{
        return EntryPresenter(interactor, compositeDisposable, errorHandler, saveWordUseCase)
    }

    @Provides
    fun provideSaveWordUseCase(definitionRepository: DefinitionRepository): SaveWordUseCase{
        return SaveWordUseCase(definitionRepository)
    }
}