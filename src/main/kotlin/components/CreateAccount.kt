package components

import materialui.components.paper.enums.PaperStyle
import materialui.components.paper.paper
import materialui.components.typography.typographyH4
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState

class CreateAccount : RComponent<RProps, CreateAccountState>() {
    override fun RBuilder.render() {
        paper(PaperStyle.elevation5 to "") {
            typographyH4 {
                +"Sing in"
            }
        }
    }
}

external interface CreateAccountState : RState {
    var username: String
    var password: String
    var confirmPassword: String
    var doRedirect: Boolean
}