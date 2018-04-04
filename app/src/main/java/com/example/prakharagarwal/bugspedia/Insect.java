package com.example.prakharagarwal.bugspedia;

import java.io.Serializable;

/**
 * Created by prakharagarwal on 04/04/18.
 */

public class Insect implements Serializable{
    String friendlyName;
    String scientificName;
    String classification;
    String imageAsset;
    float dangerLevel;

    public String getFriendlyName() {
        return friendlyName;
    }

    public void setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getImageAsset() {
        return imageAsset;
    }

    public void setImageAsset(String imageAsset) {
        this.imageAsset = imageAsset;
    }

    public float getDangerLevel() {
        return dangerLevel;
    }

    public void setDangerLevel(float dangerLevel) {
        this.dangerLevel = dangerLevel;
    }
}
