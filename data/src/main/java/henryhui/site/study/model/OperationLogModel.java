package henryhui.site.study.model;

import henryhui.site.study.data.converter.LocalDateTimeConverter;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "operation_log")
public class OperationLogModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name = "operate")
    String operate;

    @Column(name = "operate_username")
    String operateUsername;

    @Column(name = "class_name")
    String className;

    @Column(name = "method_name")
    String methodName;

    @Column(name = "start_time")
    @Convert(converter = LocalDateTimeConverter.class)
    LocalDateTime startTime;

    @Column(name = "end_time")
    @Convert(converter = LocalDateTimeConverter.class)
    LocalDateTime endTime;

    @Column(name = "cost_time")
    long costTime;
}
