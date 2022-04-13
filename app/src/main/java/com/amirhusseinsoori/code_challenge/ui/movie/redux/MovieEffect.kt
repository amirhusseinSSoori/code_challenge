package com.amirhusseinsoori.code_challenge.ui.movie.redux

import com.amirhusseinsoori.common.Constant.NoError
import com.amirhusseinsoori.domain.redux.Effect

data class MovieEffect  (
    val messageError: String = NoError
): Effect