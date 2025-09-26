import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 7.3
 */
public class MusicOrganizer
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<Track> trackList;
    // A player for the music files.
    private MusicPlayer player;
        
    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        trackList = new ArrayList<>();
        player = new MusicPlayer();
    }
    
    public void processAllTracks(){
        for (Track track : trackList){
            System.out.println(track);
        }
    }
    
    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addTrack(Track track)
    {
        trackList.add(track);
    }
    
    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfTracks()
    {
        return trackList.size();
    }
    
    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listTrack(int index)
    {
        if(validIndex(index)) {
            Track track = trackList.get(index);
            System.out.println(track);
        }
    }
    
    /**
     * Show a list of all the files in the collection.
     */
    public void listAllTracks()
    {
        for(Track track : trackList) {
            System.out.println(track);
        }
    }
    
    /**
     * Lists the file names with the associated index.
     */
    public void listWithIndex()
    {
        int position = 0;
        for(Track track : trackList) {
            System.out.println(position + ": " + track);
            position++;
        }
    }
    
    public void listMatching(String searchString)
    {
        boolean found = false;
        for(Track track : trackList) {
            if(track.getArtist().contains(searchString) || track.getFileName().contains(searchString)) 
            {
            System.out.println(track);
            found = true;
            }
        }
        if(!found) {
            System.out.println("No matches found for: " + searchString);
        }
    }
    
    public void playSamplesByArtist(String artist)
    {
        boolean found = false;
        for(Track track : trackList) {
            if(track.getArtist().contains(artist)) {
                player.playSample(track.getFileName());
                found = true;
            }
        }
        if(!found) {
            System.out.println("No tracks found for artist: " + artist);
        }
    }
    
    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeTrack(int index)
    {
        if(validIndex(index)) {
            trackList.remove(index);
        }
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        if(validIndex(index)) {
            Track track = trackList.get(index);
            player.startPlaying(track.getFileName());
        }
    }
    
    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }

    /**
     * Play a file in the collection. Only return once playing has finished.
     * @param index The index of the file to be played.
     */
    public void playAndWait(int index)
    {
        if(validIndex(index)) {
            Track track = trackList.get(index);
            player.playSample(track.getFileName());
        }
    }

    /**
     * Determine whether the given index is valid for the collection.
     * Print an error message if it is not.
     * @param index The index to be checked.
     * @return true if the index is valid, false otherwise.
     */
    private boolean validIndex(int index)
    {
        // The return value.
        // Set according to whether the index is valid or not.
        boolean valid;
        
        if(index < 0) {
            System.out.println("Index cannot be negative: " + index);
            valid = false;
        }
        else if(index >= trackList.size()) {
            System.out.println("Index is too large: " + index);
            valid = false;
        }
        else {
            valid = true;
        }
        return valid;
    }
}
