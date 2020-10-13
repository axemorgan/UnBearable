package com.alex.morgan

import com.alex.morgan.bearlist.app.BearApplication
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import kotlin.reflect.KClass

class MockApplication : BearApplication() {

    val interceptingInjector: InterceptingAndroidInjector by lazy { InterceptingAndroidInjector(super.androidInjector) }

    override fun androidInjector(): AndroidInjector<Any> = interceptingInjector
}

class InterceptingAndroidInjector constructor(
    private val androidInjector: DispatchingAndroidInjector<Any>
) :
    AndroidInjector<Any> by androidInjector {

    private val customInjections = hashMapOf<Class<*>, (Any) -> Unit>()

    override fun inject(instance: Any) {
        @Suppress("TYPE_INFERENCE_ONLY_INPUT_TYPES_WARNING")
        if (customInjections.containsKey(instance::class.java)) {
            customInjections[instance::class.java]?.invoke(instance)
        } else {
            androidInjector.inject(instance)
        }
    }

    fun addCustomInjection(klazz: Class<*>, injection: (Any) -> Unit) {
        customInjections[klazz] = injection
    }

    fun addCustomInjection(klazz: KClass<*>, injection: (Any) -> Unit) {
        customInjections[klazz.java] = injection
    }
}