package ru.netology

data class Note(
    override val id: Int = 0,
    val comments: List<Comment> = emptyList(),
) : CrudItem<Note> {
    override fun copy(id: Int): Note =
        copy(id = id, comments = comments)
}
