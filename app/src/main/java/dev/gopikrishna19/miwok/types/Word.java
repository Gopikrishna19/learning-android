package dev.gopikrishna19.miwok.types;

public class Word {
    private String txtMiwok;
    private String txtDefault;
    private int imgIllustration;

    public Word(String txtMiwok, String txtDefault) {

        this(txtMiwok, txtDefault, 0);
    }

    public Word(String txtMiwok, String txtDefault, int imgIllustration) {

        this.txtMiwok = txtMiwok;
        this.txtDefault = txtDefault;
        this.imgIllustration = imgIllustration;
    }

    String getTxtMiwok() {

        return txtMiwok;
    }

    String getTxtDefault() {

        return txtDefault;
    }

    int getImgIllustration() {

        return imgIllustration;
    }
}
