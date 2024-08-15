import csstype.*
import react.*
import emotion.react.css
import react.dom.html.ReactHTML.button
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.h3
import react.dom.html.ReactHTML.img

external interface VideoPlayerProps : Props {
    var video: Video
    var onWatchButtonPressed: (Video) -> Unit
    var isWatchedVideo: Boolean
}

val VideoPlayer = FC<VideoPlayerProps> { props ->
    div {
        css {
            position = Position.absolute
            top = 10.px
            right = 10.px
        }
        h3 {
            +"${props.video.speaker}: ${props.video.title}"
        }
        button {
            css {
                display = Display.block
                backgroundColor = if (props.isWatchedVideo) NamedColor.orangered else NamedColor.lightgreen
            }
            onClick = {
                props.onWatchButtonPressed(props.video)
            }
            if (props.isWatchedVideo) {
                +"Mark as unwatched"
            } else {
                +"Mark as watched"
            }
        }
        img {
            src = "https://via.placeholder.com/640x360.png?text=Video+Player+Placeholder"
        }
    }
}