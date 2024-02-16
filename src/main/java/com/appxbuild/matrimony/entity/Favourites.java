package com.appxbuild.matrimony.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table( name = "favourites")
public class Favourites {

    // define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnoreProperties("favourites")
    private Users users;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "agency_id", referencedColumnName = "id")
    @JsonIgnoreProperties("favourites")
    private Agencies agencies;

    @Column(name = "short_code")
    private String shortCode;

    @Column(name = "about_me")
    private String aboutMe;

    @Column(name = "age_value")
    private Integer ageValue;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "blood_group_id", referencedColumnName = "id")
    @JsonIgnoreProperties("favourites")
    private BloodGroups bloodGroups;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "gender_id", referencedColumnName = "id")
    @JsonIgnoreProperties("favourites")
    private Genders genders;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "marital_status_id", referencedColumnName = "id")
    @JsonIgnoreProperties("favourites")
    private MaritalStatuses maritalStatuses;

    @Column(name = "children")
    private Integer children;

    @Column(name = "children_desc")
    private String childrenDesc;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "financial_status_id", referencedColumnName = "id")
    @JsonIgnoreProperties("favourites")
    private FinancialStatuses financialStatuses;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "gotra_id", referencedColumnName = "id")
    @JsonIgnoreProperties("favourites")
    private Gotras gotras;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "body_type_id", referencedColumnName = "id")
    @JsonIgnoreProperties("favourites")
    private BodyTypes bodyTypes;

    @Column(name = "height")
    private Integer height;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "complexion_id", referencedColumnName = "id")
    @JsonIgnoreProperties("favourites")
    private Complexions complexions;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "drink_id", referencedColumnName = "id")
    @JsonIgnoreProperties("favourites")
    private Drinks drinks;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "occupation_id", referencedColumnName = "id")
    @JsonIgnoreProperties("favourites")
    private Occupations occupations;

    @Column(name = "occupation_desc")
    private String occupationDesc;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "smoke_id", referencedColumnName = "id")
    @JsonIgnoreProperties("favourites")
    private Smokes smokes;

    @Column(name = "weight")
    private Integer weight;

    @Column(name = "preferences")
    private String preferences;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "education_id", referencedColumnName = "id")
    @JsonIgnoreProperties("favourites")
    private Educations educations;

    @Column(name = "physical_disability")
    private Integer physicalDisability;

    @Column(name = "physical_disability_desc")
    private String physicalDisabilityDesc;

    @Column(name = "chronic_disease")
    private Integer chronicDisease;

    @Column(name = "chronic_disease_desc")
    private String chronicDiseaseDesc;

    @Column(name = "joint_family_interest")
    private Integer jointFamilyInterest;

    @Column(name = "kundli_interest")
    private Integer kundliInterest;

    @Column(name = "kundli_document_id")
    private Integer kundliDocumentId;

    @Column(name = "foreign_country_interest")
    private Integer foreignCountryInterest;

    @Column(name = "intercast_interest")
    private Integer intercastInterest;

    @Column(name = "vegetarian")
    private Integer vegetarian;

    @Column(name = "specs")
    private Integer specs;

    @Column(name = "married_brothers")
    private Integer marriedBrothers;

    @Column(name = "unmarried_brothers")
    private Integer unmarriedBrothers;

    @Column(name = "married_sisters")
    private Integer marriedSisters;

    @Column(name = "unmarried_sisters")
    private Integer unmarriedSisters;

    @Column(name = "father_name")
    private String fatherName;

    @Column(name = "mother_name")
    private String motherName;

    @Column(name = "father_information")
    private String fatherInformation;

    @Column(name = "father_email")
    private String fatherEmail;

    @Column(name = "mother_information")
    private String motherInformation;

    @Column(name = "brothers_information")
    private String brothersInformation;

    @Column(name = "sisters_information")
    private String sistersInformation;

    @Column(name = "mother_maiden_name")
    private String motherMaidenName;

    @Column(name = "is_parents_marriage_intercast")
    private Integer isParentsMarriageIntercast;

    @Column(name = "current_address")
    private String currentAddress;

    // current_country_id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "current_country_id", referencedColumnName = "id")
    @JsonIgnoreProperties("favourites")
    private Countries currentCountryId;

    // current_state_id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "current_state_id", referencedColumnName = "id")
    @JsonIgnoreProperties("favourites")
    private States currentStateId;

    @Column(name = "current_state_name")
    private String currentStateName;

    // current_city_id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "current_city_id", referencedColumnName = "id")
    @JsonIgnoreProperties("favourites")
    private Cities currentCityId;

    @Column(name = "current_city_name")
    private String currentCityName;

    @Column(name = "current_pincode")
    private String currentPincode;

    @Column(name = "permanent_address")
    private String permanentAddress;

    // permanent_country_id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "permanent_country_id", referencedColumnName = "id")
    @JsonIgnoreProperties("favourites")
    private Countries permanentCountryId;

    // permanent_state_id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "permanent_state_id", referencedColumnName = "id")
    @JsonIgnoreProperties("favourites")
    private States permanentStateId;

    @Column(name = "permanent_state_name")
    private String permanentStateName;

    // permanent_city_id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "permanent_city_id", referencedColumnName = "id")
    @JsonIgnoreProperties("favourites")
    private Cities permanentCityId;

    @Column(name = "permanent_city_name")
    private String permanentCityName;

    @Column(name = "permanent_pincode")
    private String permanentPincode;

    @Column(name = "father_mobile")
    private String fatherMobile;

    @Column(name = "mother_mobile")
    private String motherMobile;

    @Column(name = "sister_mobile")
    private String sisterMobile;

    @Column(name = "brother_mobile")
    private String brotherMobile;

    @Column(name = "email")
    private String email;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "yearly_income")
    private Integer yearlyIncome;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "company_location")
    private String companyLocation;

    @Column(name = "birth_date_time")
    private LocalDateTime birthDateTime;

    @Column(name = "birth_name")
    private String birthName;

    @Column(name = "birth_place")
    private String birthPlace;

    @Column(name = "mangal")
    private Integer mangal;

    @Column(name = "hobbies")
    private String hobbies;

    @Column(name = "approved")
    private Integer approved;

    @Column(name = "closure")
    private Integer closure;

    @Column(name = "closure_reason")
    private String closureReason;

    @Column(name = "primary_thumbnail_id")
    private Integer primaryThumbnailId;

    @Column(name = "reference_1_desc")
    private String reference1Desc;

    @Column(name = "reference_2_desc")
    private String reference2Desc;

    @Column(name = "designation_name")
    private String designationName;

    @Column(name = "degree_desc")
    private String degreeDesc;

    @Column(name = "created", updatable = false, nullable = false)
    private LocalDateTime created;

    @Column(name = "modified")
    private LocalDateTime modified;

    // define constructor
    public Favourites() {
    }

    public Favourites(String shortCode, String aboutMe, Integer ageValue, Integer children, String childrenDesc, Integer height, String occupationDesc, Integer weight, String preferences, Integer physicalDisability, String physicalDisabilityDesc, Integer chronicDisease, String chronicDiseaseDesc, Integer jointFamilyInterest, Integer kundliInterest, Integer kundliDocumentId, Integer foreignCountryInterest, Integer intercastInterest, Integer vegetarian, Integer specs, Integer marriedBrothers, Integer unmarriedBrothers, Integer marriedSisters, Integer unmarriedSisters, String fatherName, String motherName, String fatherInformation, String fatherEmail, String motherInformation, String brothersInformation, String sistersInformation, String motherMaidenName, Integer isParentsMarriageIntercast, String currentAddress, String currentStateName, String currentCityName, String currentPincode, String permanentAddress, String permanentStateName, String permanentCityName, String permanentPincode, String fatherMobile, String motherMobile, String sisterMobile, String brotherMobile, String email, String mobile, Integer yearlyIncome, String companyName, String companyLocation, LocalDateTime birthDateTime, String birthName, String birthPlace, Integer mangal, String hobbies, Integer approved, Integer closure, String closureReason, Integer primaryThumbnailId, String reference1Desc, String reference2Desc, String designationName, String degreeDesc, LocalDateTime created, LocalDateTime modified) {
        this.shortCode = shortCode;
        this.aboutMe = aboutMe;
        this.ageValue = ageValue;
        this.children = children;
        this.childrenDesc = childrenDesc;
        this.height = height;
        this.occupationDesc = occupationDesc;
        this.weight = weight;
        this.preferences = preferences;
        this.physicalDisability = physicalDisability;
        this.physicalDisabilityDesc = physicalDisabilityDesc;
        this.chronicDisease = chronicDisease;
        this.chronicDiseaseDesc = chronicDiseaseDesc;
        this.jointFamilyInterest = jointFamilyInterest;
        this.kundliInterest = kundliInterest;
        this.kundliDocumentId = kundliDocumentId;
        this.foreignCountryInterest = foreignCountryInterest;
        this.intercastInterest = intercastInterest;
        this.vegetarian = vegetarian;
        this.specs = specs;
        this.marriedBrothers = marriedBrothers;
        this.unmarriedBrothers = unmarriedBrothers;
        this.marriedSisters = marriedSisters;
        this.unmarriedSisters = unmarriedSisters;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.fatherInformation = fatherInformation;
        this.fatherEmail = fatherEmail;
        this.motherInformation = motherInformation;
        this.brothersInformation = brothersInformation;
        this.sistersInformation = sistersInformation;
        this.motherMaidenName = motherMaidenName;
        this.isParentsMarriageIntercast = isParentsMarriageIntercast;
        this.currentAddress = currentAddress;
        this.currentStateName = currentStateName;
        this.currentCityName = currentCityName;
        this.currentPincode = currentPincode;
        this.permanentAddress = permanentAddress;
        this.permanentStateName = permanentStateName;
        this.permanentCityName = permanentCityName;
        this.permanentPincode = permanentPincode;
        this.fatherMobile = fatherMobile;
        this.motherMobile = motherMobile;
        this.sisterMobile = sisterMobile;
        this.brotherMobile = brotherMobile;
        this.email = email;
        this.mobile = mobile;
        this.yearlyIncome = yearlyIncome;
        this.companyName = companyName;
        this.companyLocation = companyLocation;
        this.birthDateTime = birthDateTime;
        this.birthName = birthName;
        this.birthPlace = birthPlace;
        this.mangal = mangal;
        this.hobbies = hobbies;
        this.approved = approved;
        this.closure = closure;
        this.closureReason = closureReason;
        this.primaryThumbnailId = primaryThumbnailId;
        this.reference1Desc = reference1Desc;
        this.reference2Desc = reference2Desc;
        this.designationName = designationName;
        this.degreeDesc = degreeDesc;
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

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Agencies getAgencies() {
        return agencies;
    }

    public void setAgencies(Agencies agencies) {
        this.agencies = agencies;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public Integer getAgeValue() {
        return ageValue;
    }

    public void setAgeValue(Integer ageValue) {
        this.ageValue = ageValue;
    }

    public BloodGroups getBloodGroups() {
        return bloodGroups;
    }

    public void setBloodGroups(BloodGroups bloodGroups) {
        this.bloodGroups = bloodGroups;
    }

    public Genders getGenders() {
        return genders;
    }

    public void setGenders(Genders genders) {
        this.genders = genders;
    }

    public MaritalStatuses getMaritalStatuses() {
        return maritalStatuses;
    }

    public void setMaritalStatuses(MaritalStatuses maritalStatuses) {
        this.maritalStatuses = maritalStatuses;
    }

    public Integer getChildren() {
        return children;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }

    public String getChildrenDesc() {
        return childrenDesc;
    }

    public void setChildrenDesc(String childrenDesc) {
        this.childrenDesc = childrenDesc;
    }

    public FinancialStatuses getFinancialStatuses() {
        return financialStatuses;
    }

    public void setFinancialStatuses(FinancialStatuses financialStatuses) {
        this.financialStatuses = financialStatuses;
    }

    public Gotras getGotras() {
        return gotras;
    }

    public void setGotras(Gotras gotras) {
        this.gotras = gotras;
    }

    public BodyTypes getBodyTypes() {
        return bodyTypes;
    }

    public void setBodyTypes(BodyTypes bodyTypes) {
        this.bodyTypes = bodyTypes;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Complexions getComplexions() {
        return complexions;
    }

    public void setComplexions(Complexions complexions) {
        this.complexions = complexions;
    }

    public Drinks getDrinks() {
        return drinks;
    }

    public void setDrinks(Drinks drinks) {
        this.drinks = drinks;
    }

    public Occupations getOccupations() {
        return occupations;
    }

    public void setOccupations(Occupations occupations) {
        this.occupations = occupations;
    }

    public String getOccupationDesc() {
        return occupationDesc;
    }

    public void setOccupationDesc(String occupationDesc) {
        this.occupationDesc = occupationDesc;
    }

    public Smokes getSmokes() {
        return smokes;
    }

    public void setSmokes(Smokes smokes) {
        this.smokes = smokes;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getPreferences() {
        return preferences;
    }

    public void setPreferences(String preferences) {
        this.preferences = preferences;
    }

    public Educations getEducations() {
        return educations;
    }

    public void setEducations(Educations educations) {
        this.educations = educations;
    }

    public Integer getPhysicalDisability() {
        return physicalDisability;
    }

    public void setPhysicalDisability(Integer physicalDisability) {
        this.physicalDisability = physicalDisability;
    }

    public String getPhysicalDisabilityDesc() {
        return physicalDisabilityDesc;
    }

    public void setPhysicalDisabilityDesc(String physicalDisabilityDesc) {
        this.physicalDisabilityDesc = physicalDisabilityDesc;
    }

    public Integer getChronicDisease() {
        return chronicDisease;
    }

    public void setChronicDisease(Integer chronicDisease) {
        this.chronicDisease = chronicDisease;
    }

    public String getChronicDiseaseDesc() {
        return chronicDiseaseDesc;
    }

    public void setChronicDiseaseDesc(String chronicDiseaseDesc) {
        this.chronicDiseaseDesc = chronicDiseaseDesc;
    }

    public Integer getJointFamilyInterest() {
        return jointFamilyInterest;
    }

    public void setJointFamilyInterest(Integer jointFamilyInterest) {
        this.jointFamilyInterest = jointFamilyInterest;
    }

    public Integer getKundliInterest() {
        return kundliInterest;
    }

    public void setKundliInterest(Integer kundliInterest) {
        this.kundliInterest = kundliInterest;
    }

    public Integer getKundliDocumentId() {
        return kundliDocumentId;
    }

    public void setKundliDocumentId(Integer kundliDocumentId) {
        this.kundliDocumentId = kundliDocumentId;
    }

    public Integer getForeignCountryInterest() {
        return foreignCountryInterest;
    }

    public void setForeignCountryInterest(Integer foreignCountryInterest) {
        this.foreignCountryInterest = foreignCountryInterest;
    }

    public Integer getIntercastInterest() {
        return intercastInterest;
    }

    public void setIntercastInterest(Integer intercastInterest) {
        this.intercastInterest = intercastInterest;
    }

    public Integer getVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(Integer vegetarian) {
        this.vegetarian = vegetarian;
    }

    public Integer getSpecs() {
        return specs;
    }

    public void setSpecs(Integer specs) {
        this.specs = specs;
    }

    public Integer getMarriedBrothers() {
        return marriedBrothers;
    }

    public void setMarriedBrothers(Integer marriedBrothers) {
        this.marriedBrothers = marriedBrothers;
    }

    public Integer getUnmarriedBrothers() {
        return unmarriedBrothers;
    }

    public void setUnmarriedBrothers(Integer unmarriedBrothers) {
        this.unmarriedBrothers = unmarriedBrothers;
    }

    public Integer getMarriedSisters() {
        return marriedSisters;
    }

    public void setMarriedSisters(Integer marriedSisters) {
        this.marriedSisters = marriedSisters;
    }

    public Integer getUnmarriedSisters() {
        return unmarriedSisters;
    }

    public void setUnmarriedSisters(Integer unmarriedSisters) {
        this.unmarriedSisters = unmarriedSisters;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getFatherInformation() {
        return fatherInformation;
    }

    public void setFatherInformation(String fatherInformation) {
        this.fatherInformation = fatherInformation;
    }

    public String getFatherEmail() {
        return fatherEmail;
    }

    public void setFatherEmail(String fatherEmail) {
        this.fatherEmail = fatherEmail;
    }

    public String getMotherInformation() {
        return motherInformation;
    }

    public void setMotherInformation(String motherInformation) {
        this.motherInformation = motherInformation;
    }

    public String getBrothersInformation() {
        return brothersInformation;
    }

    public void setBrothersInformation(String brothersInformation) {
        this.brothersInformation = brothersInformation;
    }

    public String getSistersInformation() {
        return sistersInformation;
    }

    public void setSistersInformation(String sistersInformation) {
        this.sistersInformation = sistersInformation;
    }

    public String getMotherMaidenName() {
        return motherMaidenName;
    }

    public void setMotherMaidenName(String motherMaidenName) {
        this.motherMaidenName = motherMaidenName;
    }

    public Integer getIsParentsMarriageIntercast() {
        return isParentsMarriageIntercast;
    }

    public void setIsParentsMarriageIntercast(Integer isParentsMarriageIntercast) {
        this.isParentsMarriageIntercast = isParentsMarriageIntercast;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    public Countries getCurrentCountryId() {
        return currentCountryId;
    }

    public void setCurrentCountryId(Countries currentCountryId) {
        this.currentCountryId = currentCountryId;
    }

    public States getCurrentStateId() {
        return currentStateId;
    }

    public void setCurrentStateId(States currentStateId) {
        this.currentStateId = currentStateId;
    }

    public String getCurrentStateName() {
        return currentStateName;
    }

    public void setCurrentStateName(String currentStateName) {
        this.currentStateName = currentStateName;
    }

    public Cities getCurrentCityId() {
        return currentCityId;
    }

    public void setCurrentCityId(Cities currentCityId) {
        this.currentCityId = currentCityId;
    }

    public String getCurrentCityName() {
        return currentCityName;
    }

    public void setCurrentCityName(String currentCityName) {
        this.currentCityName = currentCityName;
    }

    public String getCurrentPincode() {
        return currentPincode;
    }

    public void setCurrentPincode(String currentPincode) {
        this.currentPincode = currentPincode;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public Countries getPermanentCountryId() {
        return permanentCountryId;
    }

    public void setPermanentCountryId(Countries permanentCountryId) {
        this.permanentCountryId = permanentCountryId;
    }

    public States getPermanentStateId() {
        return permanentStateId;
    }

    public void setPermanentStateId(States permanentStateId) {
        this.permanentStateId = permanentStateId;
    }

    public String getPermanentStateName() {
        return permanentStateName;
    }

    public void setPermanentStateName(String permanentStateName) {
        this.permanentStateName = permanentStateName;
    }

    public Cities getPermanentCityId() {
        return permanentCityId;
    }

    public void setPermanentCityId(Cities permanentCityId) {
        this.permanentCityId = permanentCityId;
    }

    public String getPermanentCityName() {
        return permanentCityName;
    }

    public void setPermanentCityName(String permanentCityName) {
        this.permanentCityName = permanentCityName;
    }

    public String getPermanentPincode() {
        return permanentPincode;
    }

    public void setPermanentPincode(String permanentPincode) {
        this.permanentPincode = permanentPincode;
    }

    public String getFatherMobile() {
        return fatherMobile;
    }

    public void setFatherMobile(String fatherMobile) {
        this.fatherMobile = fatherMobile;
    }

    public String getMotherMobile() {
        return motherMobile;
    }

    public void setMotherMobile(String motherMobile) {
        this.motherMobile = motherMobile;
    }

    public String getSisterMobile() {
        return sisterMobile;
    }

    public void setSisterMobile(String sisterMobile) {
        this.sisterMobile = sisterMobile;
    }

    public String getBrotherMobile() {
        return brotherMobile;
    }

    public void setBrotherMobile(String brotherMobile) {
        this.brotherMobile = brotherMobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getYearlyIncome() {
        return yearlyIncome;
    }

    public void setYearlyIncome(Integer yearlyIncome) {
        this.yearlyIncome = yearlyIncome;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyLocation() {
        return companyLocation;
    }

    public void setCompanyLocation(String companyLocation) {
        this.companyLocation = companyLocation;
    }

    public LocalDateTime getBirthDateTime() {
        return birthDateTime;
    }

    public void setBirthDateTime(LocalDateTime birthDateTime) {
        this.birthDateTime = birthDateTime;
    }

    public String getBirthName() {
        return birthName;
    }

    public void setBirthName(String birthName) {
        this.birthName = birthName;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public Integer getMangal() {
        return mangal;
    }

    public void setMangal(Integer mangal) {
        this.mangal = mangal;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public Integer getApproved() {
        return approved;
    }

    public void setApproved(Integer approved) {
        this.approved = approved;
    }

    public Integer getClosure() {
        return closure;
    }

    public void setClosure(Integer closure) {
        this.closure = closure;
    }

    public String getClosureReason() {
        return closureReason;
    }

    public void setClosureReason(String closureReason) {
        this.closureReason = closureReason;
    }

    public Integer getPrimaryThumbnailId() {
        return primaryThumbnailId;
    }

    public void setPrimaryThumbnailId(Integer primaryThumbnailId) {
        this.primaryThumbnailId = primaryThumbnailId;
    }

    public String getReference1Desc() {
        return reference1Desc;
    }

    public void setReference1Desc(String reference1Desc) {
        this.reference1Desc = reference1Desc;
    }

    public String getReference2Desc() {
        return reference2Desc;
    }

    public void setReference2Desc(String reference2Desc) {
        this.reference2Desc = reference2Desc;
    }

    public String getDesignationName() {
        return designationName;
    }

    public void setDesignationName(String designationName) {
        this.designationName = designationName;
    }

    public String getDegreeDesc() {
        return degreeDesc;
    }

    public void setDegreeDesc(String degreeDesc) {
        this.degreeDesc = degreeDesc;
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

    // toString()

    @Override
    public String toString() {
        return "Favourites{" +
                "id=" + id +
                ", users=" + users +
                ", agencies=" + agencies +
                ", shortCode='" + shortCode + '\'' +
                ", aboutMe='" + aboutMe + '\'' +
                ", ageValue=" + ageValue +
                ", bloodGroups=" + bloodGroups +
                ", genders=" + genders +
                ", maritalStatuses=" + maritalStatuses +
                ", children=" + children +
                ", childrenDesc='" + childrenDesc + '\'' +
                ", financialStatuses=" + financialStatuses +
                ", gotras=" + gotras +
                ", bodyTypes=" + bodyTypes +
                ", height=" + height +
                ", complexions=" + complexions +
                ", drinks=" + drinks +
                ", occupations=" + occupations +
                ", occupationDesc='" + occupationDesc + '\'' +
                ", smokes=" + smokes +
                ", weight=" + weight +
                ", preferences='" + preferences + '\'' +
                ", educations=" + educations +
                ", physicalDisability=" + physicalDisability +
                ", physicalDisabilityDesc='" + physicalDisabilityDesc + '\'' +
                ", chronicDisease=" + chronicDisease +
                ", chronicDiseaseDesc='" + chronicDiseaseDesc + '\'' +
                ", jointFamilyInterest=" + jointFamilyInterest +
                ", kundliInterest=" + kundliInterest +
                ", kundliDocumentId=" + kundliDocumentId +
                ", foreignCountryInterest=" + foreignCountryInterest +
                ", intercastInterest=" + intercastInterest +
                ", vegetarian=" + vegetarian +
                ", specs=" + specs +
                ", marriedBrothers=" + marriedBrothers +
                ", unmarriedBrothers=" + unmarriedBrothers +
                ", marriedSisters=" + marriedSisters +
                ", unmarriedSisters=" + unmarriedSisters +
                ", fatherName='" + fatherName + '\'' +
                ", motherName='" + motherName + '\'' +
                ", fatherInformation='" + fatherInformation + '\'' +
                ", fatherEmail='" + fatherEmail + '\'' +
                ", motherInformation='" + motherInformation + '\'' +
                ", brothersInformation='" + brothersInformation + '\'' +
                ", sistersInformation='" + sistersInformation + '\'' +
                ", motherMaidenName='" + motherMaidenName + '\'' +
                ", isParentsMarriageIntercast=" + isParentsMarriageIntercast +
                ", currentAddress='" + currentAddress + '\'' +
                ", currentCountryId=" + currentCountryId +
                ", currentStateId=" + currentStateId +
                ", currentStateName='" + currentStateName + '\'' +
                ", currentCityId=" + currentCityId +
                ", currentCityName='" + currentCityName + '\'' +
                ", currentPincode='" + currentPincode + '\'' +
                ", permanentAddress='" + permanentAddress + '\'' +
                ", permanentCountryId=" + permanentCountryId +
                ", permanentStateId=" + permanentStateId +
                ", permanentStateName='" + permanentStateName + '\'' +
                ", permanentCityId=" + permanentCityId +
                ", permanentCityName='" + permanentCityName + '\'' +
                ", permanentPincode='" + permanentPincode + '\'' +
                ", fatherMobile='" + fatherMobile + '\'' +
                ", motherMobile='" + motherMobile + '\'' +
                ", sisterMobile='" + sisterMobile + '\'' +
                ", brotherMobile='" + brotherMobile + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", yearlyIncome=" + yearlyIncome +
                ", companyName='" + companyName + '\'' +
                ", companyLocation='" + companyLocation + '\'' +
                ", birthDateTime=" + birthDateTime +
                ", birthName='" + birthName + '\'' +
                ", birthPlace='" + birthPlace + '\'' +
                ", mangal=" + mangal +
                ", hobbies='" + hobbies + '\'' +
                ", approved=" + approved +
                ", closure=" + closure +
                ", closureReason='" + closureReason + '\'' +
                ", primaryThumbnailId=" + primaryThumbnailId +
                ", reference1Desc='" + reference1Desc + '\'' +
                ", reference2Desc='" + reference2Desc + '\'' +
                ", designationName='" + designationName + '\'' +
                ", degreeDesc='" + degreeDesc + '\'' +
                ", created=" + created +
                ", modified=" + modified +
                '}';
    }
}