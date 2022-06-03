package ru.netology

interface CrudItem<Self> {
    val id: Int
    fun copy(id: Int): Self
}

class CrudRepository<T : CrudItem<T>> {
    private var items = listOf<T>()

    fun add(item: T) {
        val copy = item.copy(items.lastOrNull()?.id?.plus(1) ?: 0)
        items = items + copy
    }

    fun getLast(): T = items.last()

    fun getById(id: Int): T? =
        items.find { it.id == id }

    fun deleteById(id: Int) {
        items = items.filter { it.id != id }
    }

    fun update(item: T) {
        items = items.map {
            if (it.id == item.id) {
                item
            } else {
                it
            }
        }
    }
}