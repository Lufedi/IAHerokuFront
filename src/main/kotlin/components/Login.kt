package components

import kotlinx.css.marginTop
import kotlinx.css.pct
import kotlinx.html.ButtonType
import kotlinx.html.InputType
import kotlinx.html.js.onChangeFunction
import kotlinx.html.js.onSubmitFunction
import materialui.components.button.button
import materialui.components.button.enums.ButtonVariant
import materialui.components.circularprogress.circularProgress
import materialui.components.paper.enums.PaperStyle
import materialui.components.paper.paper
import materialui.components.textfield.textField
import materialui.components.typography.enums.TypographyColor
import materialui.components.typography.typography
import materialui.components.typography.typographyH4
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.events.Event
import react.*
import react.dom.*
import react.dom.div
import react.router.dom.navLink
import styled.css
import styled.styledDiv


class Login : RComponent<RProps, LoginState>() {
    override fun LoginState.init() {
        loading = false
    }

    private val login: (Event) -> Unit = {

    }

    override fun RBuilder.render() {
        main("layout") {
            div("paper") {
                paper(PaperStyle.elevation5 to "") {
                    attrs.elevation = 5
                    typographyH4 { +"AI Heroku" }
                    img("icon", "icon.png") {}
                    typography {
                        attrs.color = TypographyColor.error
                        attrs.gutterBottom = true
                        +(state.errorMessage ?: "")
                    }
                    form {
                        attrs.onSubmitFunction = login
                        textField {
                            attrs {
                                required = true
                                fullWidth = true
                                placeholder = "Username"
                                onChangeFunction = {
                                    val target = it.target as HTMLInputElement
                                    setState { username = target.value }
                                }
                            }
                        }
                        textField {
                            attrs {
                                required = true
                                fullWidth = true
                                type = InputType.password
                                placeholder = "Password"
                                onChangeFunction = {
                                    val target = it.target as HTMLInputElement
                                    setState { password = target.value }
                                }
                            }
                        }
                        br {}
                        button {
                            attrs {
                                type = ButtonType.submit
                                variant = ButtonVariant.contained
                                fullWidth = true
                                disabled = state.loading
                            }
                        }
                    }
                }
            }
            navLink<RProps>("/sing-in") { +"Sing in" }
            if (state.loading) styledDiv {
                css {
                    marginTop = 4.pct
                }
                circularProgress { }
            }
        }
    }
}

external interface LoginState : RState {
    var username: String
    var password: String
    var doRedirect: Boolean
    var errorMessage: String?
    var loading: Boolean
}