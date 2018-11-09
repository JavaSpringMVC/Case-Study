var deleteNote = function (id) {
    if (confirm("Dou you delete Note?")) {
        window.location.href = "/delete-note/" + id;
    }
}

var deleteNoteType = function (id) {
    if (confirm("Dou you delete Note Type?")) {
        window.location.href = "/noteType/delete-note-type/" + id;
    }
}