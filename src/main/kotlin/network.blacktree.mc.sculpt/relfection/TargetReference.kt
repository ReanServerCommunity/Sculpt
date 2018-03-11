package network.blacktree.mc.sculpt.relfection

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.FIELD, AnnotationTarget.LOCAL_VARIABLE)
annotation class TargetReference(val target : String, val value : String)