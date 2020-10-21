package components

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.h1

class ModelService : RComponent<RProps, ModelServiceState>() {
    override fun RBuilder.render() {
        h1 { +"model" }
    }

}

external interface ModelServiceState : RState {
}