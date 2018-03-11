package network.blacktree.mc.sculpt.relfection

import java.lang.reflect.ParameterizedType

/**
 *
 */
@Suppress("UNCHECKED_CAST")
open class GenericHolder<out GenericType> protected constructor()
{
    private val genericType : Class<GenericType> = (this.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0]
            as Class<GenericType>

    fun getGenericType() : Class<out GenericType> = this.genericType

    fun gerGenericInstance() : GenericType = this.genericType.newInstance()

}