package com.appxbuild.matrimony.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "thumbnails")
public class Thumbnails {

    // define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "mime_type")
    private String mimeType;

    @Column(name = "extension")
    private String extension;

    @Column(name = "size")
    private Integer size;

    @Column(name = "path")
    private String path;

    @Column(name = "url")
    private String url;

    @Column(name = "chached_image_url")
    private String chachedImageUrl;

    @Column(name = "created", nullable = false, updatable = false)
    private LocalDateTime created;

    @Column(name = "modified")
    private LocalDateTime modified;

    // define constructor
    public Thumbnails() {}
    public Thumbnails(String name, String mimeType, String extension, Integer size, String path, String url, String chachedImageUrl, LocalDateTime created, LocalDateTime modified) {
        this.name = name;
        this.mimeType = mimeType;
        this.extension = extension;
        this.size = size;
        this.path = path;
        this.url = url;
        this.chachedImageUrl = chachedImageUrl;
        this.created = created;
        this.modified = modified;
    }

    // define getter/setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getChachedImageUrl() {
        return chachedImageUrl;
    }

    public void setChachedImageUrl(String chachedImageUrl) {
        this.chachedImageUrl = chachedImageUrl;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    // define toString() method
    @Override
    public String toString() {
        return "Thumbnails{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mimeType='" + mimeType + '\'' +
                ", extension='" + extension + '\'' +
                ", size='" + size + '\'' +
                ", path='" + path + '\'' +
                ", url='" + url + '\'' +
                ", chachedImageUrl='" + chachedImageUrl + '\'' +
                ", created=" + created +
                ", modified=" + modified +
                '}';
    }
}
