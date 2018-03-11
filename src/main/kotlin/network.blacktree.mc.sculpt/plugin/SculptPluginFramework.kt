@file:JvmName("SculptPluginFramework")
package network.blacktree.mc.sculpt.plugin

import network.blacktree.mc.sculpt.native.SafetyCall
import network.blacktree.mc.sculpt.relfection.Handle

import java.io.File

abstract class SculptPluginFramework : SpigotNativeLoader("sculpt_main"), Handle, SculptPlugin
{
    // Do not touch this variable attribute if you don't know its purpose.
    // This's required for file validation from the external library.
    @Volatile @Transient
    private var CHECKSUM_UNIQUE_ID: PLUGIN_HASH_TYPE = 0xEFFFFFFF
    @SafetyCall private external fun checkAuthenticatedPlatform(verifyPath : String) : Long
    @SafetyCall private external fun winApiHook() : Boolean
    
    companion object
    {
        fun getProtectionTargetName(clazz : Class<*>) : String? = File(clazz.protectionDomain.codeSource.location.path).name
    }

    fun getProtectionSourceName() : String = File(this.javaClass.protectionDomain.codeSource.location.path).name

    override fun onInit(handleInstance: Any?): Any?
    {
        this.pluginInstance = handleInstance as SculptPlugin
        CHECKSUM_UNIQUE_ID = this.getNativeLoader().call("checkAuthenticatedPlatform", this.getProtectionSourceName()) as PLUGIN_HASH_TYPE
        return this
    }

    private var pluginInstance : SculptPlugin? = null
    override fun getPluginBase() : SculptPlugin? = this.pluginInstance



    final fun onEnable()
    {
        this.onInit(null)
    }

    final fun onDisable()
    {

    }


}