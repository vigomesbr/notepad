package br.com.viniciusgomes.notepad.controller

import br.com.viniciusgomes.notepad.model.Note
import br.com.viniciusgomes.notepad.service.NoteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/note")
class  NoteController {

    @Autowired
    lateinit var noteService: NoteService


    @GetMapping("/check")
    fun checkHealth(): String {
        return "OK"
    }

    @GetMapping
    fun buscarTodos(): List<Note>{
        return noteService.findAll()
    }

    @PostMapping
    fun salvar(@RequestBody note: Note): Note{
        return noteService.salvar(note)
    }

    @DeleteMapping("/{id}")
    fun apagar(@PathVariable("id")id: String){
        noteService.apagar(id)
    }

    @GetMapping("/titulo/{titulo}")
    fun buscarPorTitulo(@PathVariable("titulo")titulo: String): List<Note>{
        return noteService.buscarPorTirulo(titulo)
    }


}