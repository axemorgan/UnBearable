package com.alex.morgan.bearlist.app

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule

@Component(modules = [AppModule::class, AndroidInjectionModule::class, AndroidSupportInjectionModule::class])
interface AppComponent {

    fun inject(app: BearApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun bindContext(context: Context): Builder

        fun build(): AppComponent
    }
}
