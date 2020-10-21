import components.CreateAccount
import components.Home
import components.Login
import components.ModelService
import kotlinx.browser.document
import kotlinx.browser.localStorage
import react.*
import react.dom.render
import react.router.dom.browserRouter
import react.router.dom.route
import react.router.dom.switch

class App : RComponent<RProps, AppState>() {
    override fun AppState.init() {
        isLoggedIn = localStorage.getItem("isLoggedIn").toBoolean()
    }

    override fun RBuilder.render() {
        browserRouter {
            if (state.isLoggedIn) switch {
                route("/") {
                    child(Home::class) {}
                }
                route("/models") {
                    child(ModelService::class) {}
                }
            }
            else switch {
                route("/", Login::class, exact = true)
                route("/sing-in", CreateAccount::class, exact = true)
            }
        }
    }
}

external interface AppState : RState {
    var isLoggedIn: Boolean
}

fun main() {
    render(document.getElementById("root")) {
        child(App::class) {}
    }
}