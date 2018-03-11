package network.blacktree.mc

import network.blacktree.mc.sculpt.Sculpt

object SculptMain
{
    @JvmStatic
    fun main(args : Array<String>)
    {
        var sculpt = Sculpt()
        sculpt.onEnable()
    }
}