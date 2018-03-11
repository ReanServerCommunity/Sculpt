package network.blacktree.mc.sculpt.relfection

/**
 * TargetBuilder is a class that gets all the values of the fields to which the TargetReference is
 * attached. The class can not be used alone but can be inherited from the class. <br>The child class
 * overrides {@link #onInit (Object)} and handles it automatically if you pass the value to this class.<br>
 * Here is an example of the code:<br>
 * <pre>
 * <code>
 * public void subClass extends TargetBuilder<subClass>
 * {
 *     &#064;TypeReference
 *     private Label referLabel;
 *
 *     ...
 *     &#064;Override
 *     public Object onInit(Object handleInstance)
 *     {
 *         super.onInit(this);
 *         ...
 *         // return this;
 *         // return null;
 *     }
 * }
 * </code>
 * </pre>
 * The package that can take advantage of this is JavaFX.
 * It can be very useful when indirectly referring to static variables with FXML type.
 * @param <E> The type of sub-class
 * @author ruskonert
 */
abstract class TargetBuilder<E> : GenericHolder<TargetBuilder<E>>(), Handle
{
    private val targetInstance : Any? = null
    fun getTargetInstance() : Any? = this.targetInstance

    override fun onInit(handleInstance: Any?): Any?
    {
        return this
    }
}