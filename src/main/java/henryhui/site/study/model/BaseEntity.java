package henryhui.site.study.model;

import henryhui.site.study.data.converter.LocalDateTimeConverter;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class BaseEntity {
    @Column(name = "create_time")
    @Convert(converter = LocalDateTimeConverter.class)
    public LocalDateTime createAt;

    @Column(name = "create_by")
    public String createBy;

    @Column(name = "modified_time")
    @Convert(converter = LocalDateTimeConverter.class)
    public LocalDateTime modifiedTime;

    @Column(name = "modified_by")
    public String modifiedBy;
}
