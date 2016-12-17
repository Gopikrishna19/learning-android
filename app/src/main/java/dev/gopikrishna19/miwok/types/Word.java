package dev.gopikrishna19.miwok.types;

public class Word {
    private String txtMiwok;
    private String txtDefault;

    public Word(String txtMiwok, String txtDefault) {

        this.txtMiwok = txtMiwok;
        this.txtDefault = txtDefault;
    }

    public String getTxtMiwok() {

        return txtMiwok;
    }

    public String getTxtDefault() {

        return txtDefault;
    }
}
