package inhatc.spring.shop.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@EntityListeners(value = {AuditingEntityListener.class})    //JPA에게 해당 Entity는 Auditing 기능을 사용한다는 것을 알림
@MappedSuperclass   // 상속받는 클래스에게 매핑 정보만 제공하는 클래스
@Getter
@Setter
public abstract class BaseTimeEntity {

    @CreatedDate
    @Column(updatable = false)  // 업데이트 불가능, 등록 시간은 바뀌면 안되기 때문
    private LocalDateTime regDate;

    @LastModifiedDate
    private LocalDateTime updateDate;



}
