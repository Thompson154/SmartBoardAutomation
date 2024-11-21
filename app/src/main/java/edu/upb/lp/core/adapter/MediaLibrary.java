package edu.upb.lp.core.adapter;

public interface MediaLibrary {
    /**
     * Show a temporary message on the screen
     *
     * @param message
     *            The message to be displayed
     */
    void showTemporaryMessage(String message);

    /**
     * Reproduce a sound, verify that the name of the sound file (without
     * extension) you put on res/raw folder is the same as the String param
     *
     * @param sound
     */
    void reproduceSound(String sound);

    /**
     * Stop all sounds
     */
    void stopSounds();
}
