package network.blacktree.mc.sculpt.native

import network.blacktree.mc.sculpt.relfection.TargetBuilder

open class NativeLoader() : TargetBuilder<NativeLoader>()
{
    companion object
    {

    }

    fun call(functionName : String, vararg arguments : Any?) : Any?
    {
        return null
    }

    fun safetyCall(functionName: String, vararg  arguments: Any?) : Any?
    {
        return null
    }

    private lateinit var targetPlatform : Class<*>
    fun getTargetPlatform() : Class<*> = this.targetPlatform

    constructor(target : Class<*>) : this()
    {
        this.targetPlatform = target
    }

}