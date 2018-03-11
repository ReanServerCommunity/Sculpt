package network.blacktree.mc.sculpt.native

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class SafetyCall(val syncMode : Boolean = false, val modifierCanValid: Boolean = true)