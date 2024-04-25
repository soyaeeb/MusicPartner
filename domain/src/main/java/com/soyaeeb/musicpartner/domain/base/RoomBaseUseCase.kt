package com.soyaeeb.musicpartner.domain.base

import kotlinx.coroutines.flow.Flow

interface BaseUseCase

interface SuspendableUseCase<Params, Return> : BaseUseCase {
    suspend fun execute(params: Params) : Return
}

interface CollectableUseCase<Params, Return> : BaseUseCase {
    fun execute(params: Params) : Flow<Return>
}


