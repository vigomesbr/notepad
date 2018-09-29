package br.com.viniciusgomes.notepad.repository

import br.com.viniciusgomes.notepad.model.Note
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface NoteRepository : MongoRepository<Note, String> {
 fun findByTituloContainingIgnoreCase(titulo: String): List<Note>

}