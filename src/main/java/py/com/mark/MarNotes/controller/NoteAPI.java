package py.com.mark.MarNotes.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import py.com.marce.commons.Note;
import py.com.mark.MarNotes.Utils.ApiException;

@RestController
public class NoteAPI {
    Logger log = LoggerFactory.getLogger(NoteAPI.class);
    @Autowired
    private py.com.mark.MarNotes.service.Note noteService;

    @RequestMapping(value = "/note",method = RequestMethod.POST)
    public void addNote(
            @RequestParam(value = "token",required = true) String token,
            @RequestBody Note note
            ) throws ApiException {
        log.debug(String.format("Starting request for add new note with at %s",token));

        noteService.addNote(note,token);


    }
}
