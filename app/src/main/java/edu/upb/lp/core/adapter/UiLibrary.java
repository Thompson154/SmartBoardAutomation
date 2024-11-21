package edu.upb.lp.core.adapter;

public interface UiLibrary  {

    /**
     * Configure the whole screen
     *
     * @param numberOfRows
     * @param numberOfColumns
     * @param verticalSpacing
     * @param horizontalSpacing
     * @param vertical
     * @param bottomSectionProportion
     */
    void configureScreen(int numberOfRows, int numberOfColumns,
                         int verticalSpacing, int horizontalSpacing, boolean vertical, double bottomSectionProportion);


    void setDynamicTitle(String title);


    /**
     * Define the colors for the toolbar.
     *
     * @param backgroundColorResId Resource ID of the background color.
     * @param titleColorResId Resource ID of the title text color.
     */
    void setToolbarColors(int backgroundColorResId, int titleColorResId);

    /**
     * Add a button. If the button already exists, it is updated
     *
     * @param name
     * @param textSize
     * @param buttonSize
     */
    void addButton(String name, int textSize, int buttonSize);

    /**
     * Remove a button
     *
     * @param name
     */
    void removeButton(String name);

    /**
     * Remove all buttons
     */
    void removeAllButtons();

    /**
     * Add a text field. If it already exists, it will be updated
     *
     * @param name
     * @param text
     * @param textSize
     * @param textFieldSize
     */
    void addTextField(String name, String text, int textSize, int textFieldSize);

    /**
     * Remove a text field
     *
     * @param name
     */
    void removeTextField(String name);

    /**
     * Remove all text fields
     */
    void removeAllTextFields();

    /**
     * Update a text field
     *
     * @param name
     * @param message
     */
    void updateTextField(String name, String message);

    /**
     * Set some text in a cell of the grid
     *
     * @param horizontal
     * @param vertical
     * @param text
     */
    void setTextOnCell(int vertical, int horizontal, String text);

    /**
     * Set the size of the text in a cell
     *
     * @param horizontal
     * @param vertical
     * @param size
     */
    void setTextSizeOnCell(int vertical, int horizontal, int size);

    /**
     * Set an image in the cell
     *
     * @param horizontal
     * @param vertical
     * @param image
     */
    void setImageOnCell(int vertical, int horizontal, String image);
}