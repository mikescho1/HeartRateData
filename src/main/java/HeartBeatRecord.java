import javax.persistence.*;
import java.time.LocalDate;
import java.util.Map;


@Entity
@Table(name = "heartRates")
public class HeartBeatRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate startDate;
    private String type;
    private String sourceName;
    private String sourceVersion;
    private String device;
    private String unit;
    private String creationDate;
    private String MetadataEntry;



    private String endDate;
    private Integer beatsPerMinute;


    public HeartBeatRecord() {
    }

    public HeartBeatRecord(LocalDate startDate, String endDate, Integer beatsPerMinute) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.beatsPerMinute = beatsPerMinute;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }



    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getBeatsPerMinute() {
        return beatsPerMinute;
    }

    public void setBeatsPerMinute(Integer beatsPerMinute) {
        this.beatsPerMinute = beatsPerMinute;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getSourceVersion() {
        return sourceVersion;
    }

    public void setSourceVersion(String sourceVersion) {
        this.sourceVersion = sourceVersion;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getMetadataEntry() {
        return MetadataEntry;
    }

    public void setMetadataEntry(String metadataEntry) {
        MetadataEntry = metadataEntry;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override public String toString() {
        return "{Start Time : " + startDate + ", End Time : " + endDate + "}";
    }

}
