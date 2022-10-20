package py.com.mark.MarNotes.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import py.com.marce.commons.Note;
import py.com.mark.MarNotes.exception.ApiException;
import py.com.mark.MarNotes.bean.Session;
import py.com.mark.MarNotes.service.SessionService;

import java.util.List;

@RestController
public class NoteAPI {
    Logger log = LoggerFactory.getLogger(NoteAPI.class);
    @Autowired
    private py.com.mark.MarNotes.service.Note noteService;

    @Autowired
    private SessionService sessionService;
    @RequestMapping(value = "/note",method = RequestMethod.POST)
    public void addNote(
            @RequestParam(value = "token",required = true) String token,
            @RequestBody Note note
            ) throws ApiException {
        log.info(String.format("Starting request for add new note with at %s",token));
        //Get session
        Session session = sessionService.getSessionFromAccessToken(token);
        //todo to make the function better I should to check with a service if sessin is expires
        noteService.addNote(note,session);


    }
    @RequestMapping(value = "/note",method = RequestMethod.GET)
    public List<Note> getNoteByUserId (
            @RequestParam(value = "id",required = true) Integer id,
            @RequestParam(value = "token",required = true) String token
    ) throws ApiException{
        log.info(String.format("Starting request for get all  note with at %s",token));

        Session session = sessionService.getSessionFromAccessToken(token);
        return noteService.getAllNotes(id);
    }
    @RequestMapping(value = "/",method = RequestMethod.DELETE)
    public void removeNote(
            @RequestParam(value = "id",required = true) Integer id,
            @RequestParam(value = "token",required = true)String token){

    }
}
