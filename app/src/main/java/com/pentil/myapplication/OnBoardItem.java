package com.pentil.myapplication;

public class OnBoardItem {
    int imageID;
    String title;
    String description;
    String keterangan;
    int page;

    public OnBoardItem(int imageID, String title, String description, String keterangan, int page) {
        this.imageID = imageID;
        this.title = title;
        this.description = description;
        this.keterangan = keterangan;
        this.page = page;
    }

    public int getImageID() {
        return imageID;
    }

    public OnBoardItem() {
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
