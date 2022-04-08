package com.floriv.capstone.di

import com.floriv.capstone.home.HomeViewModel
import com.floriv.capstone.core.domain.usecase.GameInteractor
import com.floriv.capstone.core.domain.usecase.GameUseCase
import com.floriv.capstone.core.ui.detail.DetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<GameUseCase> { GameInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}