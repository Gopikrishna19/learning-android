package dev.gopikrishna19.miwok.types;

public class Word {
    private static final int NO_IMAGE = -1;

    private String txtMiwok;
    private String txtDefault;
    private int rawPronunciation;
    private int imgIllustration;

    public Word(String txtDefault, String txtMiwok, int rawPronunciation) {

        this(txtMiwok, txtDefault, rawPronunciation, NO_IMAGE);
    }

    public Word(String txtDefault, String txtMiwok, int rawPronunciation, int imgIllustration) {

        this.txtMiwok = txtMiwok;
        this.txtDefault = txtDefault;
        this.rawPronunciation = rawPronunciation;
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

    public int getRawPronunciation() {

        return rawPronunciation;
    }
}
