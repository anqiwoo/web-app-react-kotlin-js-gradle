import csstype.Color
import csstype.FontFamily
import kotlinx.coroutines.async
import react.*
import react.dom.*
import kotlinx.browser.window
import kotlinx.coroutines.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import emotion.react.css
import csstype.Position
import csstype.px
import react.dom.html.ReactHTML.h1
import react.dom.html.ReactHTML.h3
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.p
import react.dom.html.ReactHTML.img

val App = FC<Props> {
    var currentVideo: Video? by useState(null)

    // typesafe HTML goes here
    div {
        css {
            fontFamily = FontFamily.monospace
            color = Color("darkblue")
        }
        h1 {
            +"KotlinConf Explorer"
        }
        div {
            h3 {
                +"Videos to watch"
            }
            VideoList {
                videos = unwatchedVideos
                selectedVideo = currentVideo
                onSelectVideo = { video ->
                   currentVideo = video
                }
            }
            h3 {
                +"Videos watched"
            }
            VideoList {
                videos = watchedVideos
                selectedVideo = currentVideo
                onSelectVideo = { video ->
                    currentVideo = video
                }
            }
        }
        /*
        * The let scope function ensures that
        * the VideoPlayer component is only added
        * when state.currentVideo is not null.
        * */
        currentVideo?.let { curr ->
            VideoPlayer {
                video = curr
            }
        }
    }
}