package com.example.androidplayground.common.data

object AppDatabase {

    fun getFakeItems(): List<Item> {
        val fakeItems = listOf(
            Item(id = 1, name = "Item 1", description = "This is the item 1"),
            Item(id = 2, name = "Item 2", description = "This is the item 2"),
            Item(id = 3, name = "Item 3", description = "This is the item 3"),
            Item(id = 4, name = "Item 4", description = "This is the item 4"),
            Item(id = 5, name = "Item 5", description = "This is the item 5"),
            Item(id = 6, name = "Item 6", description = "This is the item 6")
        )

        return fakeItems
    }
}
