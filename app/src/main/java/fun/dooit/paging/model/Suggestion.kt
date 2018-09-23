package `fun`.dooit.paging.model


data class Suggestion(
    val code: Int,
    val data: List<Data>,
    val errId: String
) {

    data class Data(
        val id: String,
        val iPathId: String,
        val name: String,
        val area: String,
        val lat: Double,
        val lng: Double,
        val type: String,
        val parent: String
    )
}