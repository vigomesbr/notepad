package br.com.viniciusgomes.notepad.service

import br.com.viniciusgomes.notepad.model.Note
import br.com.viniciusgomes.notepad.repository.NoteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping

@Service
class NoteService {

    @Autowired
    lateinit var noteRepository: NoteRepository

    fun salvar(note: Note): Note{
        return noteRepository.save(note)
    }

    fun findAll(): List<Note> {
        return noteRepository.findAll()
    }

    fun apagar(id: String){
        noteRepository.deleteById(id)
    }

    fun buscarPorTirulo(titulo: String): List<Note>{
        return noteRepository.findByTituloContainingIgnoreCase(titulo)
    }

}