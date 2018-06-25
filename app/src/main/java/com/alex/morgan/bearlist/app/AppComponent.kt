package com.alex.morgan.bearlist.app

import android.content.Context
import dagger.BindsInstance
import dagger.Component

@Component(modules = [(AppModule::class)])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun bindContext(context: Context): Builder

        fun build(): AppComponent
    }
}
