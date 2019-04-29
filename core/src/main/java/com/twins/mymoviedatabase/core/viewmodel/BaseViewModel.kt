package com.twins.mymoviedatabase.core.viewmodel

import androidx.lifecycle.ViewModel
import com.twins.mymoviedatabase.core.netapi.Api

/**
 * Created by Yolanda-PC on 02/03/2018.
 */
open class BaseViewModel(protected val api: Api) : ViewModel()