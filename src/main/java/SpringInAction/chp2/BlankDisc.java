package SpringInAction.chp2;

public class BlankDisc implements CompactDisc{
    private String title;
    private String artist;

    public BlankDisc(String artist, String title) {
        this.title = title;
        this.artist = artist;
    }

    public BlankDisc() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }
}
