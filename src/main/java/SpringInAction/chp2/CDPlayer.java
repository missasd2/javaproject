package SpringInAction.chp2;

public class CDPlayer implements MediaPlayer{
    private CompactDisc compactDisc;

    @Override
    public void setCompactDisc(CompactDisc compactDisc) {
        this.compactDisc = compactDisc;
    }

    public void play() {
        compactDisc.play();
    }
}
