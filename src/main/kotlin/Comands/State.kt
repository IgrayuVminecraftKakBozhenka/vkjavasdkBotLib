package Comands


abstract class BaseState(open val name: String) {
}

data class InitialState(override val name: String = "initial") : BaseState(name = name)

object State {
    var actualState: BaseState = InitialState()
        private set

    fun setNewState(newState: BaseState) {
        actualState = newState
    }
}



