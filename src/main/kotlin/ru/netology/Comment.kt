package ru.netology

data class Comment(
    override val id: Int = 0,
    val text: String,
    val noteId: Int = 0,
) : CrudItem<Comment> {

    override fun copy(id: Int): Comment =
        copy(id = id, text = text)
}
