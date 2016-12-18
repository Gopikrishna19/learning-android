package dev.gopikrishna19.miwok.types;

public class Word {
    private static final int NO_IMAGE = -1;

    private String txtMiwok;
    private String txtDefault;
    private int imgIllustration;

    public Word(String txtDefault, String txtMiwok) {

        this(txtMiwok, txtDefault, NO_IMAGE);
    }

    public Word(String txtDefault, String txtMiwok, int imgIllustration) {

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

    boolean hasImage() {

        return imgIllustration != NO_IMAGE;
    }
}
