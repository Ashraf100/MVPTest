package com.example.subeksha.myapplication.model;

/**
 * Created by Subeksha on 2/27/17.
 */

public class Brand {
    public Brand(int b_image, String b_name, int image_id, String textView) {
        this.setB_image(b_image);
        this.setImage_id(image_id);
        this.setB_name(b_name);
        this.setTextView(textView);
    }

    private int b_image;
    private int image_id;
    private String b_name;
    private String textView;

    public int getB_image() {

        return b_image;
    }

    public int getImage_id() {

        return image_id;
    }

    public void setB_image(
            int b_image) {

        this.b_image = b_image;
    }

    public void setImage_id(int image_id) {

        this.image_id = image_id;
    }

    public String getB_name() {

        return b_name;
    }

    public String getTextView() {

        return textView;
    }

    public void setB_name(String b_name) {

        this.b_name = b_name;
    }

    public void setTextView(String textView) {

        this.textView = textView;
    }



}

