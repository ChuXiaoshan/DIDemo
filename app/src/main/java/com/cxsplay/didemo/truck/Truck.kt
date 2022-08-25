package com.cxsplay.didemo.truck

import javax.inject.Inject
import javax.inject.Qualifier

/**
 * Created by xiaoshanchu on 2022/8/25
 *
 * Description:
 */
class Truck @Inject constructor(val driver: Driver) {

    @BindGasEngine
    @Inject
    lateinit var gasEngine: Engine

    @BindElectricEngine
    @Inject
    lateinit var electricEngine: Engine

    fun deliver() {
        gasEngine.start()
        electricEngine.start()
        println("Truck is delivering cargo. Driven by $driver")
        gasEngine.shutDown()
        electricEngine.shutDown()
    }
}

class Driver @Inject constructor() {
    var name: String? = null
}

interface Engine {
    fun start()
    fun shutDown()
}

class GasEngine @Inject constructor() : Engine {
    override fun start() {
        println("Gas engine start.")
    }

    override fun shutDown() {
        println("Gas engine shutdown.")
    }
}

class ElectricEngine @Inject constructor() : Engine {
    override fun start() {
        println("Electric engine start.")
    }

    override fun shutDown() {
        println("Electric engine shutdown.")
    }
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BindGasEngine

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BindElectricEngine