package components

import react.dom.*
import react.*


class Home : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        h1 {
            +"Home page"
        }
    }

}