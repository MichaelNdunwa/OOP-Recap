package kotlin_files

enum class DownloadState {
    Idle,
    Starting,
    InProgress,
    Error,
    Success;
}

fun main() {
    Downloader().downloadData(
        "foo.com/bar",
        progress = { downloadState ->
            when (downloadState) {
                DownloadState.Idle -> println("Download has not yet started.")
                DownloadState.Starting -> println("Starting download...")
                DownloadState.InProgress -> println("Downloading data...")
                DownloadState.Error -> println("An error occurred. Download terminated")
                DownloadState.Success -> println("Download completed successfully.")
            }
        },
        completion = { error, list ->
//            error?.let { println("Got error: ${error.message}") }
//            list?.let { println("Got list with ${list.size} items") }
        })
}

class Downloader {
    fun downloadData(
        url: String,
        progress: (DownloadState) -> Unit,
        completion: (DownloadState, DownloadState) -> Unit
    ) {

    }
}
