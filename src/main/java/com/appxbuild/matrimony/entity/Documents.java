package com.appxbuild.matrimony.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "documents")
public class Documents {

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

    @Column(name = "cached_image_url")
    private String cachedImageUrl;

    @Column(name = "is_verified")
    private Byte isVerified;

    @Column(name = "verified_by")
    private String verifiedBy;

    @Column(name = "created", nullable = false, updatable = false)
    private LocalDateTime created;

    @Column(name = "modified")
    private LocalDateTime modified;

    @OneToMany(mappedBy = "documents", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("documents")
    private List<DocumentsUserProfiles> documentsUserProfiles;

    // define constructor
    public Documents(){

    }
    public Documents(String name, String mimeType, String extension, Integer size, String path, String url, String cachedImageUrl, Byte isVerified, String verifiedBy, LocalDateTime created, LocalDateTime modified) {
        this.name = name;
        this.mimeType = mimeType;
        this.extension = extension;
        this.size = size;
        this.path = path;
        this.url = url;
        this.cachedImageUrl = cachedImageUrl;
        this.isVerified = isVerified;
        this.verifiedBy = verifiedBy;
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

    public String getCachedImageUrl() {
        return cachedImageUrl;
    }

    public void setCachedImageUrl(String cachedImageUrl) {
        this.cachedImageUrl = cachedImageUrl;
    }

    public Byte getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(Byte isVerified) {
        this.isVerified = isVerified;
    }

    public String getVerifiedBy() {
        return verifiedBy;
    }

    public void setVerifiedBy(String verifiedBy) {
        this.verifiedBy = verifiedBy;
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
        return "Documents{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mimeType='" + mimeType + '\'' +
                ", extension='" + extension + '\'' +
                ", size=" + size +
                ", path='" + path + '\'' +
                ", url='" + url + '\'' +
                ", cachedImageUrl='" + cachedImageUrl + '\'' +
                ", isVerified=" + isVerified +
                ", verifiedBy='" + verifiedBy + '\'' +
                ", created=" + created +
                ", modified=" + modified +
                '}';
    }

}
