package com.example.androidplayground.common.data

object AppDatabase {

    fun getFakeItems(): List<Item> {
        val fakeItems = listOf(
            Item(
                id = 1,
                name = "Laptop Dell XPS 15",
                description = "High-performance laptop with 16GB RAM and 512GB SSD",
                stock = 75
            ),
            Item(
                id = 2,
                name = "Wireless Mouse",
                description = "Ergonomic wireless mouse with USB receiver",
                stock = 35
            ),
            Item(
                id = 3,
                name = "Mechanical Keyboard",
                description = "RGB mechanical keyboard with blue switches",
                stock = 5
            ),
            Item(
                id = 4,
                name = "Monitor 27 4K",
                description = "27-inch 4K UHD monitor with HDR support",
                stock = 0
            )
        )

        return fakeItems
    }

    fun fakeLoginUser(username: String, password: String): User? {
        return getFakeUsers().find {
            it.name == username && it.password == password
        }
    }

    fun isActiveSession() = false

    private fun getFakeUsers() = buildList {
        repeat(3) {
            add(
                User(
                    id = it,
                    name = "User$it",
                    email = "user$it@email.com",
                    password = "user$it"
                )
            )
        }
    }

    fun setActiveUser() {

    }
}
