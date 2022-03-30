package ReBack.core.data;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WriterInformation {
    @SequenceGenerator(name = "writer_information_seq_generator",
            sequenceName = "writer_information_seq",
            initialValue = 1, allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "writer_information_seq_generator")
    private Long writerInformationCode;

    @Column(length=200)
    private String writerLecturePlace;

    @Column
    private Date availableStartTime;

    @Column
    private Date availableFinishTime;

    @Column(length=30)
    private String availableDay;

    @Column(length=100)
    private String trainingTopic;

    @Column
    private boolean trainingStatus;

    @Column
    private boolean feedbackStatus;

    @ManyToOne
    @JoinColumn(name="member_code")
    private Member memberCode;


}
