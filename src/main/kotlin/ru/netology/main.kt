package ru.netology

fun main() {
    val service = NotesService()
    val note = service.addNote("Test")
    List(10) {
        service.addComment(note.id, "Comment №$it")
    }

    val comments = service.getComments(noteId = note.id, commentsCount = 3, lastComment = 3)

    println(comments)
}
