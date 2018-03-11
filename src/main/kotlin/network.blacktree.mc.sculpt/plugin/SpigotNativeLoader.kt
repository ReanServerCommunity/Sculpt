package network.blacktree.mc.sculpt.plugin

import network.blacktree.mc.sculpt.native.NativeLoader

typealias PLUGIN_HASH_TYPE = Long
open class SpigotNativeLoader(vararg libname: String)
{
    init
    {

    }

    private val nativeLoader : NativeLoader = NativeLoader(this.javaClass)
    fun getNativeLoader() : NativeLoader = this.nativeLoader
}