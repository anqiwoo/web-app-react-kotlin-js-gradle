@file:JsModule("react-player")
@file:JsNonModule

import react.*

/**
 * When the compiler sees an external declaration like ReactPlayer,
 * it assumes that the implementation for the corresponding class
 * is provided by the dependency and doesn't generate code for it.
 * */
@JsName("default")
external val ReactPlayer: ComponentClass<ReactPlayerProps>

external interface ReactPlayerProps: Props {
    var url: String
    var controls: Boolean
}