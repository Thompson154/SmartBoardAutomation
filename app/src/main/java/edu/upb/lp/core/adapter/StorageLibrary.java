package edu.upb.lp.core.adapter;

public interface StorageLibrary {
    /**
     * Store a String in the phone memory, to be retrieved anytime, even after
     * shutting down the telephone.
     *
     * @param key The key to store and retrieve the String.
     * @param value The String to be stored.
     */
    void storeString(String key, String value);

    /**
     * Store an int in the phone memory, to be retrieved anytime, even after
     * shutting down the telephone.
     *
     * @param key The key to store and retrieve the int.
     * @param value The int to be stored.
     */
    void storeInt(String key, int value);

    /**
     * Store a float in the phone memory, to be retrieved anytime, even after
     * shutting down the telephone.
     *
     * @param key The key to store and retrieve the float.
     * @param value The float to be stored.
     */
    void storeFloat(String key, float value);

    /**
     * Store a boolean in the phone memory, to be retrieved anytime, even after
     * shutting down the telephone.
     *
     * @param key The key to store and retrieve the boolean.
     * @param value The boolean to be stored.
     */
    void storeBoolean(String key, boolean value);

    /**
     * Retrieve a value from the phone memory.
     * @param key The with which the value was stored.
     * @return The String that was stored.
     */
    String retrieveString(String key);

    /**
     * Retrieve a value from the phone memory.
     * @param key The with which the value was stored.
     * @return The int that was stored.
     */
    int retrieveInt(String key);

    /**
     * Retrieve a value from the phone memory.
     * @param key The with which the value was stored.
     * @return The float that was stored.
     */
    float retrieveFloat(String key);

    /**
     * Retrieve a value from the phone memory.
     * @param key The with which the value was stored.
     * @return The boolean that was stored.
     */
    boolean retrieveBoolean(String key);
}
