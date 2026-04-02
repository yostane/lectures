# Clean Architecture avec Kotlin + Gradle

Ce tutoriel présente une application de gestion de prêt de livres (bibliothèque) en Clean Architecture avec Kotlin et Gradle. Le thème est volontairement positionné autour d'un service de prêt/réservation de livres, pour varier par rapport à l'exemple TypeScript + Bun. L'objectif est de montrer l'organisation des couches et l'injection de dépendances sans frameworks lourds.

## Prérequis

- JDK 17+ installé.
- Gradle 8+ (ou Wrapper Gradle fourni).
- IDE Kotlin-friendly (IntelliJ IDEA recommandé).
- Notions de base sur Clean Architecture et DDD.

## Création du projetp

Créez un nouveau projet Gradle Kotlin:

```bash
graduate init --type kotlin-application --dsl kotlin --project-name clean-archi-kt-gradle
gradle wrapper
```

Structure du `build.gradle.kts`:

```kotlin
plugins {
    kotlin("jvm") version "1.9.20"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
}

application {
    mainClass.set("app.MainKt")
}

tasks.test {
    useJUnitPlatform()
}
```

## Architecture des dossiers

```
src/main/kotlin/
├── app/
│   └── Main.kt
├── domain/
│   ├── model/
│   │   └── Book.kt
│   └── repository/
│       └── LoanRepository.kt
├── usecase/
│   ├── input/
│   │   ├── LoanBookUseCase.kt
│   │   └── ReturnBookUseCase.kt
│   ├── output/
│   │   └── LoanPresenter.kt
│   └── impl/
│       ├── LoanBookUseCaseImpl.kt
│       └── ReturnBookUseCaseImpl.kt
└── infra/
    └── repository/
        └── InMemoryLoanRepository.kt

src/test/kotlin/
```

## 1) Domaine (entities/value objects)

`src/main/kotlin/domain/model/Book.kt`:

```kotlin
package domain.model

import java.time.LocalDate

data class Book(
    val id: String,
    val title: String,
    val author: String,
    val borrowedUntil: LocalDate? = null,
) {
    fun isAvailable() = borrowedUntil == null || borrowedUntil.isBefore(LocalDate.now())

    fun borrow(until: LocalDate): Book {
        require(isAvailable()) { "Livre déjà emprunté" }
        require(until.isAfter(LocalDate.now())) { "La date de retour doit être future" }

        return copy(borrowedUntil = until)
    }

    fun returned(): Book = copy(borrowedUntil = null)
}
```

## 2) Ports (interfaces de repository)

`src/main/kotlin/domain/repository/LoanRepository.kt`:

```kotlin
package domain.repository

import domain.model.Book

interface LoanRepository {
    suspend fun findById(id: String): Book?
    suspend fun save(book: Book)
}
```

## 3) Use cases

### `LoanBookUseCase`

`src/main/kotlin/usecase/input/LoanBookUseCase.kt`:

```kotlin
package usecase.input

import java.time.LocalDate

interface LoanBookUseCase {
    suspend fun execute(bookId: String, until: LocalDate): Result<String>
}
```

### `ReturnBookUseCase`

`src/main/kotlin/usecase/input/ReturnBookUseCase.kt`:

```kotlin
package usecase.input

interface ReturnBookUseCase {
    suspend fun execute(bookId: String): Result<String>
}
```

### Implémentations

`src/main/kotlin/usecase/impl/LoanBookUseCaseImpl.kt`:

```kotlin
package usecase.impl

import domain.repository.LoanRepository
import usecase.input.LoanBookUseCase
import java.time.LocalDate

class LoanBookUseCaseImpl(
    private val loanRepository: LoanRepository,
) : LoanBookUseCase {

    override suspend fun execute(bookId: String, until: LocalDate): Result<String> {
        val book = loanRepository.findById(bookId) ?: return Result.failure(IllegalArgumentException("Livre introuvable"))

        return try {
            val borrowed = book.borrow(until)
            loanRepository.save(borrowed)
            Result.success("$bookId emprunté jusqu'au $until")
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
```

`src/main/kotlin/usecase/impl/ReturnBookUseCaseImpl.kt`:

```kotlin
package usecase.impl

import domain.repository.LoanRepository
import usecase.input.ReturnBookUseCase

class ReturnBookUseCaseImpl(
    private val loanRepository: LoanRepository,
) : ReturnBookUseCase {

    override suspend fun execute(bookId: String): Result<String> {
        val book = loanRepository.findById(bookId) ?: return Result.failure(IllegalArgumentException("Livre introuvable"))

        return try {
            val returned = book.returned()
            loanRepository.save(returned)
            Result.success("$bookId retourné")
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
```

## 4) Infrastructure (implémentation concrète)

`src/main/kotlin/infra/repository/InMemoryLoanRepository.kt`:

```kotlin
package infra.repository

import domain.model.Book
import domain.repository.LoanRepository

class InMemoryLoanRepository : LoanRepository {

    private val storage = mutableMapOf<String, Book>()

    override suspend fun findById(id: String): Book? = storage[id]

    override suspend fun save(book: Book) {
        storage[book.id] = book
    }

    // API de test / référence
    fun seed(vararg books: Book) {
        books.forEach { storage[it.id] = it }
    }
}
```

## 5) Point d'entrée et composition des dépendances

`src/main/kotlin/app/Main.kt`:

```kotlin
package app

import domain.model.Book
import infra.repository.InMemoryLoanRepository
import usecase.impl.LoanBookUseCaseImpl
import usecase.impl.ReturnBookUseCaseImpl
import usecase.input.LoanBookUseCase
import usecase.input.ReturnBookUseCase
import java.time.LocalDate

suspend fun main() {
    val repo = InMemoryLoanRepository()
    repo.seed(
        Book("1", "Clean Code", "Robert C. Martin"),
        Book("2", "Domain-Driven Design", "Eric Evans"),
    )

    val loanUseCase: LoanBookUseCase = LoanBookUseCaseImpl(repo)
    val returnUseCase: ReturnBookUseCase = ReturnBookUseCaseImpl(repo)

    println(loanUseCase.execute("1", LocalDate.now().plusDays(14)))
    println(returnUseCase.execute("1"))
    println(loanUseCase.execute("2", LocalDate.now().minusDays(1))) // date passée, erreur
}
```

> Note : la fonction `main` utilise `suspend`; exécuter via `gradle run --no-daemon` ou config IDE avec coroutines.

## 6) Tests unitaires (optionnel mais recommandé)

`src/test/kotlin/app/LoanUseCaseTest.kt`:

```kotlin
package app

import domain.model.Book
import infra.repository.InMemoryLoanRepository
import usecase.impl.LoanBookUseCaseImpl
import kotlin.test.Test
import kotlin.test.assertTrue
import kotlin.test.assertFailsWith
import java.time.LocalDate

class LoanUseCaseTest {

    @Test
    fun `peut emprunter livre disponible`() = runBlocking {
        val repo = InMemoryLoanRepository().apply {
            seed(Book("1", "Clean Architecture", "R. Martin"))
        }
        val useCase = LoanBookUseCaseImpl(repo)
        val result = useCase.execute("1", LocalDate.now().plusDays(7))
        assertTrue(result.isSuccess)
    }

    @Test
    fun `n emprunte pas livre déjà emprunte`() = runBlocking {
        val repo = InMemoryLoanRepository().apply {
            seed(Book("1", "Clean Architecture", "R. Martin", LocalDate.now().plusDays(3)))
        }
        val useCase = LoanBookUseCaseImpl(repo)
        val result = useCase.execute("1", LocalDate.now().plusDays(7))
        assertTrue(result.isFailure)
    }
}
```

## Exécution

```bash
gradle run
gradle test
```

## Extensions possibles

- Exposer une API REST avec Ktor ou Spring Boot (couche `interface` - contrôleurs).
- Persister dans une base SQL (repository DAO) en remplacement de la mémoire volatile.
- Ajouter un adaptateur de sortie (presenter) pour transformer les `Result` en DTO JSON.
- Implémenter des use cases supplémentaires : `SearchBooksUseCase`, `ReserveBookUseCase`, `ListOverdueBooks`.
- Externaliser la configuration de dépendances dans un conteneur DI (Koin, Dagger).

## Conclusion

Ce tutoriel montre une Clean Architecture Kotlin + Gradle dans une application de prêt de livres. Chaque couche est découplée pour faciliter la maintenabilité, les tests et l'évolution, tout en se basant sur le même esprit que l'exemple TypeScript + Bun.
