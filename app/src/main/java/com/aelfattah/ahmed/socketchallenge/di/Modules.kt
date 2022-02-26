package com.aelfattah.ahmed.socketchallenge.di

import com.aelfattah.ahmed.socketchallenge.data.repositories.MainRepositoryImpl
import com.aelfattah.ahmed.socketchallenge.data.sources.remote.EndPoint
import com.aelfattah.ahmed.socketchallenge.data.sources.remote.FriendService
import com.aelfattah.ahmed.socketchallenge.ui.main.MainViewModel
import io.socket.client.IO
import io.socket.client.Socket
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val socketModule = module {
    fun provideSocketIO() = IO.socket(EndPoint.BASE_URL)
    single { provideSocketIO() }
}
val servicesModule = module {
    fun provideFriendService(socket: Socket) = FriendService(socket = socket)
    single {
        provideFriendService(socket = get())
    }
}

val repositoriesModule = module {
    fun provideFriendRepositoryImpl(friendService: FriendService) =
        MainRepositoryImpl(friendService = friendService)

    single { provideFriendRepositoryImpl(friendService = get()) }
}

val viewModelsModule = module {
    fun provideMainViewModel(mainRepositoryImpl: MainRepositoryImpl) =
        MainViewModel(mainRepositoryImpl = mainRepositoryImpl)

    viewModel { provideMainViewModel(mainRepositoryImpl = get()) }
}

val allModules = listOf(socketModule, servicesModule, repositoriesModule, viewModelsModule)