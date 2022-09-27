package py.com.mark.MarNotes.service;

import py.com.mark.MarNotes.Utils.ApiException;

import java.util.List;

public interface Note {
    public void addNote(py.com.marce.commons.Note  note,String accessToken) throws ApiException;


    public List<py.com.marce.commons.Note> getAllNotes(String userId);
}
