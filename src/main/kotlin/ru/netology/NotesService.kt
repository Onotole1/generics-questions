package ru.netology

class NotesService {
    private val commentsRepository = CrudRepository<Comment>()
    private val notesRepository = CrudRepository<Note>()

    fun addNote(commentText: String): Note {
        val comment = Comment(text = commentText)
        val note = Note()
        commentsRepository.add(comment)
        val savedComment = commentsRepository.getLast()
        notesRepository.add(
            note.copy(
                comments = listOf(savedComment)
            )
        )
        return notesRepository.getLast()
    }

    fun addComment(noteId: Int, commentText: String) {
        val comment = Comment(text = commentText)
        commentsRepository.add(comment)
        val savedComment = commentsRepository.getLast()
        val note = notesRepository.getById(noteId) ?: return
        notesRepository.update(
            note.copy(
                comments = note.comments + savedComment
            )
        )
    }

    fun getComments(noteId: Int, lastComment: Int, commentsCount: Int): List<Comment> {
        val note = notesRepository.getById(noteId) ?: return listOf()

        return note.comments.sortedBy {
            it.id
        }
            .dropWhile {
                it.id < lastComment
            }
            .take(commentsCount)
    }
}