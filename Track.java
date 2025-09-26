/**
 * This is for question 28 where we need to implement track I think I didnt read right
 */
 public class Track 
 {  
    private String artist;
    private String filename;

    public Track(String artist, String filename) 
    {
        this.artist = artist;
        this.filename = filename;
    }

    public String getArtist() 
    {
        return artist;
    }

    public String getFileName()
    {
        return filename;
    }

    @Override
    public String toString() 
    {
        return artist + " - " + filename;
    }
}