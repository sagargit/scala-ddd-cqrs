package command

/**
 * Created by roshan on 6/18/15.
 *
 * This provides an interface to create concrete handlers providers.
 *
 * example: [[DefaultHandlersProvider]] is based on Scala Immutable Map.
 */
trait HandlersProvider {

  /**
   * Lookup [[CommandHandler]] for [[Command]]
   *
   * @param command
   * @return
   */
  def getHandler[C <: Command](command: C): Option[CommandHandler[C]]

  /**
   * Register [[CommandHandler]] for a [[Command]]
   *
   * @param command
   * @param commandHandler
   */
  def register[C <: Command, H <: CommandHandler[C]](command: Class[C], commandHandler: H): Unit

  /**
   * Unregister [[Command]] and its [[CommandHandler]]
   *
   * @param command
   * @param commandHandler
   */
  def unRegister[C <: Command, H <: CommandHandler[C]](command: Class[C], commandHandler: H): Unit
}
