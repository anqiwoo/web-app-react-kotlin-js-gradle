import kotlinx.browser.window
import react.*
import react.dom.*
import react.dom.html.ReactHTML.p

/**
 * The external modifier tells the compiler that
 * the interface's implementation is provided externally,
 * so it doesn't try to generate JavaScript code from the declaration.
 * */
external interface VideoListProps : Props {
    var videos: List<Video>
}

val VideoList = FC<VideoListProps> { props ->
    var selectedVideo: Video? by useState(null)
    for (video in props.videos) {
        p {
            key = video.id.toString()
            onClick = {
                selectedVideo = video
            }
            if (video == selectedVideo) {
                +"▶ "
            }
            +"${video.speaker}: ${video.title}"
        }
    }
}