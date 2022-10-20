package py.com.mark.MarNotes.service;

import py.com.mark.MarNotes.exception.ApiException;
import py.com.mark.MarNotes.bean.Session;

import java.util.List;

public interface Note {
    public void addNote(py.com.marce.commons.Note  note, Session session) throws ApiException;




    List<py.com.marce.commons.Note> getAllNotes(Integer userId);
}
