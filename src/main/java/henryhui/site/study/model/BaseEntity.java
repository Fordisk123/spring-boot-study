package henryhui.site.study.model;

import henryhui.site.study.data.converter.LocalDateTimeConverter;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
    @Column(name = "create_time")
    @CreatedDate
    @Convert(converter = LocalDateTimeConverter.class)
    public LocalDateTime createAt;

    @Column(name = "create_by")
    @CreatedBy
    public String createBy;

    @Column(name = "last_modified_time")
    @LastModifiedDate
    @Convert(converter = LocalDateTimeConverter.class)
    public LocalDateTime lastModifiedTime;

    @Column(name = "last_modified_by")
    @LastModifiedBy
    public String lastModifiedBy;
}
